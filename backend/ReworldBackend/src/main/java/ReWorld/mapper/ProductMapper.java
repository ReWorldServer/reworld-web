package ReWorld.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ReWorld.entity.Product;
import ReWorld.dto.ProductDTO;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDTO toDTO(Product product);
    Product toEntity(ProductDTO dto);
}
