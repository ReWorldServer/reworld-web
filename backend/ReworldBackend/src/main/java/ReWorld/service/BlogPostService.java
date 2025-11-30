package ReWorld.service;

import ReWorld.dto.BlogPostDTO;
import ReWorld.entity.BlogPost;
import ReWorld.exception.BlogPostNotFoundException;
import ReWorld.exception.NoBlogPostsFoundException;
import ReWorld.exception.InvalidBlogPostException;
import ReWorld.mapper.BlogPostMapper;
import ReWorld.repository.BlogPostRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogPostService {

    private final BlogPostRepository blogPostRepo;
    private final BlogPostMapper mapper;

    @Autowired
    public BlogPostService(BlogPostRepository blogPostRepo, BlogPostMapper mapper) {
        this.blogPostRepo = blogPostRepo;
        this.mapper = mapper;
    }

    // get all
    public List<BlogPostDTO> getAllBlogPosts() {
        List<BlogPost> posts = blogPostRepo.findAll();
        if (posts.isEmpty()) {
            return null;
        }
        return posts.stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    // get by id
    public BlogPostDTO getBlogPostById(Long id) {
        BlogPost post = blogPostRepo.findById(id)
                .orElseThrow(() -> new BlogPostNotFoundException("Entrada no encontrada con id " + id));
        return mapper.toDTO(post);
    }

    // create
    public BlogPostDTO createBlogPost(BlogPostDTO dto) {
        if (dto.getTitle() == null || dto.getTitle().isBlank()) {
            throw new InvalidBlogPostException("El título es requerido");
        }
        if (dto.getContent() == null || dto.getContent().isEmpty()) {
            throw new InvalidBlogPostException("El contenido es requerido");
        }

        BlogPost post = mapper.toEntity(dto);
        try {
            ObjectMapper mapperJson = new ObjectMapper();
            String contentJson = mapperJson.writeValueAsString(dto.getContent());
            post.setContent(contentJson);
        } catch (Exception e) {
            throw new RuntimeException("Error serializando contenido", e);
        }
        BlogPost saved = blogPostRepo.save(post);
        return mapper.toDTO(saved);
    }

    // update
    public BlogPostDTO updateBlogPost(Long id, BlogPostDTO dto) {
        BlogPost existing = blogPostRepo.findById(id)
                .orElseThrow(() -> new BlogPostNotFoundException("Entrada no encontrada con id " + id));

        if (dto.getTitle() != null && !dto.getTitle().isBlank()) {
            existing.setTitle(dto.getTitle());
        }
        if (dto.getDescription() != null) {
            existing.setDescription(dto.getDescription());
        }
        if (dto.getImage() != null) {
            existing.setImage(dto.getImage());
        }
        if (dto.getContent() != null && !dto.getContent().isEmpty()) {
            try {
                ObjectMapper mapperJson = new ObjectMapper();
                String contentJson = mapperJson.writeValueAsString(dto.getContent());
                existing.setContent(contentJson);
            } catch (Exception e) {
                throw new RuntimeException("Error serializando contenido", e);
            }
        }

        BlogPost updated = blogPostRepo.save(existing);
        return mapper.toDTO(updated);
    }

    // delete
    public BlogPostDTO deleteBlogPost(Long id) {
        BlogPost post = blogPostRepo.findById(id)
                .orElseThrow(() -> new BlogPostNotFoundException("Entrada no encontrada con id " + id));
        blogPostRepo.delete(post);
        return mapper.toDTO(post);
    }
}



