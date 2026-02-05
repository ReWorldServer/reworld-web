package ReWorld.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ReWorld.entity.BlogPost;

@Repository
public interface BlogPostRepository extends JpaRepository <BlogPost , Long> {
}
