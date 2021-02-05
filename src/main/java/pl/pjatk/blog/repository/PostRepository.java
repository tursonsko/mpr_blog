package pl.pjatk.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.pjatk.blog.model.Author;
import pl.pjatk.blog.model.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByAuthorPostAndCategoryPost(Author authorPost, String categoryPost);
}