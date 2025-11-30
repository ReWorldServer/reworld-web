package ReWorld.service;

import ReWorld.dto.ProductDTO;
import ReWorld.entity.Product;
import ReWorld.exception.NoProductsFoundException;
import ReWorld.exception.ProductNotFoundException;
import ReWorld.mapper.ProductMapper;
import ReWorld.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepo;
    private final ProductMapper mapper;

    @Autowired
    public ProductService(ProductRepository productRepo, ProductMapper mapper) {
        this.productRepo = productRepo;
        this.mapper = mapper;
    }

    // getall
    public List<ProductDTO> getAllProducts() {
        List <Product> products = productRepo.findAll();
        if (products.isEmpty()) {
            throw new NoProductsFoundException("No hay productos");
        }
        return products.stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    // getbyid
    public ProductDTO getProductById(Long id) {
        Product product = productRepo.findById(id)
                .orElseThrow(()-> new ProductNotFoundException("Producto no enonctrado con ese id " + id ));
        return mapper.toDTO(product);
    }

    // create
    public ProductDTO createProduct(ProductDTO dto) {
        if (dto.getName() == null || dto.getName().isBlank()) {
            throw new IllegalArgumentException("Nombre del producto es requerido");
        }
        Product product = mapper.toEntity(dto);
        Product saved = productRepo.save(product);
        return mapper.toDTO(saved);
    }

    // update
    public ProductDTO updateProduct(Long id, ProductDTO dto) {
        Product existing = productRepo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Producto no encontrado con id " + id));

        existing.setName(dto.getName());
        existing.setPrice(dto.getPrice());

        Product updated = productRepo.save(existing);
        return mapper.toDTO(updated);
    }

    // delete
    public ProductDTO deleteProduct(Long id) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Producto no encontrado con id " + id));
        productRepo.delete(product);
        return mapper.toDTO(product);
    }
}
