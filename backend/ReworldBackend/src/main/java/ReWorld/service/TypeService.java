package ReWorld.service;

import ReWorld.entity.Type;
import ReWorld.exception.TypeNotFoundException;
import ReWorld.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import ReWorld.mapper.TypeMapper;
import org.springframework.stereotype.Service;
import ReWorld.dto.TypeDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeService {

    private final TypeRepository typeRepository;
    private final TypeMapper mapper;

    @Autowired
    public TypeService(TypeRepository typeRepository, TypeMapper mapper) {
        this.typeRepository = typeRepository;
        this.mapper = mapper;
    }

    // get all
    public List<TypeDTO> getAllTypes() {
        List<Type> types = typeRepository.findAll();
        if (types.isEmpty()) {
            throw new RuntimeException("No hay tipos registrados");
        }
        return types.stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    // get by id
    public TypeDTO getTypeById(Long id) {
        Type type = typeRepository.findById(id)
                .orElseThrow(() -> new TypeNotFoundException("Tipo no encontrado con id " + id));
        return mapper.toDTO(type);
    }

    // create
    public TypeDTO createType(TypeDTO dto) {
        if (dto.getName() == null || dto.getName().isBlank()) {
            throw new IllegalArgumentException("El nombre del tipo es requerido");
        }
        Type type = mapper.toEntity(dto);
        Type saved = typeRepository.save(type);
        return mapper.toDTO(saved);
    }

    // update
    public TypeDTO updateType(Long id, TypeDTO dto) {
        Type existing = typeRepository.findById(id)
                .orElseThrow(() -> new TypeNotFoundException("Tipo no encontrado con id " + id));

        existing.setName(dto.getName());
        Type updated = typeRepository.save(existing);
        return mapper.toDTO(updated);
    }

    // delete
    public TypeDTO deleteType(Long id) {
        Type type = typeRepository.findById(id)
                .orElseThrow(() -> new TypeNotFoundException("Tipo no encontrado con id " + id));
        typeRepository.delete(type);
        return mapper.toDTO(type);
    }
}
