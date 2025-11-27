package ReWorld.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ReWorld.entity.Transfer;
import ReWorld.dto.TransferDTO;

@Mapper(uses = {ProductMapper.class}) // usa ProductMapper para mapear el campo product
public interface TransferMapper {
    TransferMapper INSTANCE = Mappers.getMapper(TransferMapper.class);

    TransferDTO toDTO(Transfer transfer);
    Transfer toEntity(TransferDTO dto);
}
