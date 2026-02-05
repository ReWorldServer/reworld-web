    package ReWorld.mapper;

    import org.mapstruct.Mapper;
    import ReWorld.entity.Product;
    import ReWorld.dto.ProductDTO;

    @Mapper(componentModel = "spring")
    public interface ProductMapper {
        ProductDTO toDTO(Product product);
        Product toEntity(ProductDTO dto);
    }
