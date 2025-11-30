package ReWorld.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class BlogPostDTO {
    private Long id;
    private String title;       // corregido
    private String description;
    private LocalDateTime datep;
    private String image;
    private String author;
    private List<Map<String, Object>> content;  // asegúrate que exista
    private String type;
}
