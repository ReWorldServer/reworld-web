package ReWorld.mapper;

import ReWorld.dto.BlogPostDTO;
import ReWorld.entity.BlogPost;
import ReWorld.entity.Type;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Mapper(componentModel = "spring")
public interface BlogPostMapper {

    @Mapping(source = "type.name", target = "type")
    BlogPostDTO toDTO(BlogPost blogPost);

    @Mapping(source = "type", target = "type")
    BlogPost toEntity(BlogPostDTO dto);

    // Conversión de Type ↔ String
    default String map(Type value) {
        return value != null ? value.getName() : null;
    }

    default Type map(String value) {
        if (value == null) return null;
        Type type = new Type();
        type.setName(value);
        return type;
    }

    // Conversión de fecha
    default LocalDateTime mapDate(String value) {
        if (value == null) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(value, formatter).atStartOfDay();
    }

    default String mapDate(LocalDateTime value) {
        if (value == null) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return value.format(formatter);
    }

    // Conversión de content
    default String mapContent(List<Map<String, Object>> content) {
        if (content == null) return null;
        try {
            return new ObjectMapper().writeValueAsString(content);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error serializando content", e);
        }
    }

    default List<Map<String, Object>> mapContent(String content) {
        if (content == null) return null;
        try {
            return new ObjectMapper().readValue(content, new TypeReference<List<Map<String, Object>>>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error deserializando content", e);
        }
    }

}

