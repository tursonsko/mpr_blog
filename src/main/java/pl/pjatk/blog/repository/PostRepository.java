package pl.pjatk.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.pjatk.blog.model.Author;
import pl.pjatk.blog.model.AuthorWithCategory;
import pl.pjatk.blog.model.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByauthorPostAndCategoryPost(Author authorPost, String categoryPost);
}
