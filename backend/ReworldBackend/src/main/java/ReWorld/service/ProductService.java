package ReWorld.service;

import ReWorld.dto.ProductDTO;
import ReWorld.entity.Product;
import ReWorld.mapper.ProductMapper;
import ReWorld.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepo;

    @Autowired
    public ProductService(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    // --- READ ALL ---
    public List<ProductDTO> getAllProducts() {
        return productRepo.findAll()
                .stream()
                .map(ProductMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    // --- READ BY ID ---
    public ProductDTO getProductById(Long id) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        return ProductMapper.INSTANCE.toDTO(product);
    }

    // --- CREATE ---
    public ProductDTO createProduct(ProductDTO dto) {
        if (dto.getName() == null || dto.getName().isBlank()) { // <-- corregido
            throw new IllegalArgumentException("Nombre del producto es requerido");
        }
        Product product = ProductMapper.INSTANCE.toEntity(dto);
        Product saved = productRepo.save(product);
        return ProductMapper.INSTANCE.toDTO(saved);
    }

    // --- UPDATE ---
    public ProductDTO updateProduct(Long id, ProductDTO dto) {
        Product existing = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        existing.setName(dto.getName()); // <-- corregido
        existing.setPrice(dto.getPrice());

        Product updated = productRepo.save(existing);
        return ProductMapper.INSTANCE.toDTO(updated);
    }



    // --- DELETE ---
    public ProductDTO deleteProduct(Long id) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        productRepo.deleteById(id);
        return ProductMapper.INSTANCE.toDTO(product);
    }
}
