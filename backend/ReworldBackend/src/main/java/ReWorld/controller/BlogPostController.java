package ReWorld.controller;

import ReWorld.dto.BlogPostDTO;
import ReWorld.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogposts")
public class BlogPostController {

    private final BlogPostService service;

    @Autowired
    public BlogPostController(BlogPostService service) {
        this.service = service;
    }

    @GetMapping
    public List<BlogPostDTO> getAll() {
        return service.getAllBlogPosts();
    }

    @GetMapping("/{id}")
    public BlogPostDTO getById(@PathVariable Long id) {
        return service.getBlogPostById(id);
    }

    @PostMapping
    public BlogPostDTO create(@RequestBody BlogPostDTO dto) {
        return service.createBlogPost(dto);
    }

    @PutMapping("/{id}")
    public BlogPostDTO update(@PathVariable Long id, @RequestBody BlogPostDTO dto) {
        return service.updateBlogPost(id, dto);
    }

    @DeleteMapping("/{id}")
    public BlogPostDTO delete(@PathVariable Long id) {
        return service.deleteBlogPost(id);
    }
}
