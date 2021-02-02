package pl.pjatk.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjatk.blog.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
