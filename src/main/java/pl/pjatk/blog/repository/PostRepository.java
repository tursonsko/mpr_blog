package pl.pjatk.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjatk.blog.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
