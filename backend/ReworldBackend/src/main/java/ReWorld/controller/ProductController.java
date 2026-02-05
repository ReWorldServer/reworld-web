    package ReWorld.controller;

    import ReWorld.dto.ProductDTO;
    import ReWorld.service.ProductService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @RestController
    @RequestMapping("/api/products")
    public class ProductController {

        private final ProductService productService;

        @Autowired
        public ProductController(ProductService productService) {
            this.productService = productService;
        }

        // getall
        @GetMapping
        public ResponseEntity<List<ProductDTO>> getAllProducts() {
            return ResponseEntity.ok(productService.getAllProducts());
        }

        // getbyid
        @GetMapping("/{id}")
        public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
            return ResponseEntity.ok(productService.getProductById(id));
        }

        // create
        @PostMapping
        public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO dto) {
            return ResponseEntity.status(201).body(productService.createProduct(dto));
        }

        // update
        @PutMapping("/{id}")
        public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody ProductDTO dto) {
            return ResponseEntity.ok(productService.updateProduct(id, dto));
        }

        // delete
        @DeleteMapping("/{id}")
        public ResponseEntity<ProductDTO> deleteProduct(@PathVariable Long id) {
            return ResponseEntity.ok(productService.deleteProduct(id));
        }
    }
