package ReWorld.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ReWorld.entity.Type;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogPost {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private LocalDateTime datep = LocalDateTime.now();
    private String image;
    private String author;
    @Lob
    private String content;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;


}
