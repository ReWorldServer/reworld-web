package ReWorld.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ReWorld.entity.Type;
import ReWorld.dto.TypeDTO;

@Mapper(componentModel = "spring")
public interface TypeMapper {
    TypeDTO toDTO(Type type);
    Type toEntity(TypeDTO dto);
}
