package pl.pjatk.blog.service;

import org.springframework.stereotype.Service;
import pl.pjatk.blog.model.Author;
import pl.pjatk.blog.model.AuthorWithCategory;
import pl.pjatk.blog.model.Post;
import pl.pjatk.blog.repository.AuthorRepository;
import pl.pjatk.blog.repository.PostRepository;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PostService {
    private PostRepository postRepository;
    private final AuthorRepository authorRepository;

    public PostService(PostRepository postRepository, AuthorRepository authorRepository) {
        this.postRepository = postRepository;
        this.authorRepository = authorRepository;
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    //TODO findbyid
    public Optional<Post> findById(Long idPost) {
        return postRepository.findById(idPost);
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public AuthorWithCategory getPostByAuthorPostAndCategoryPost(Long idAuthor, String categoryPost) {
        Optional<Author> author = authorRepository.findById(idAuthor);

        if (author.isPresent()) {
            List<Post> listOfPost = postRepository.findByauthorPostAndCategoryPost(author.get(), categoryPost);
            return new AuthorWithCategory(author.get().getNameAuthor(), categoryPost, listOfPost.size());
        } else {
            throw new NoSuchElementException(String.format("User with %s does not exist.", idAuthor));
        }
    }

    public void delete(Long idPost) {
        postRepository.deleteById(idPost);
    }

    public Post update(Long idPost, Post updatedPost) {
        updatedPost.setIdPost(idPost);
        if (findById(updatedPost.getIdPost()).isPresent()) {
            updatedPost.setTimePost(new Date());
            return postRepository.save(updatedPost);
        } else {
            return null;
        }
    }

}
