package pl.pjatk.blog.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import pl.pjatk.blog.model.Author;
import pl.pjatk.blog.model.AuthorWithCategory;
import pl.pjatk.blog.model.Post;
import pl.pjatk.blog.repository.AuthorRepository;
import pl.pjatk.blog.repository.PostRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {
    private PostRepository postRepository;
    private final AuthorRepository authorRepository;

    public PostService(PostRepository postRepository, AuthorRepository authorRepository) {
        this.postRepository = postRepository;
        this.authorRepository = authorRepository;
    }

    public List<Post> findAllPosts() {
        List<Post> postList = postRepository.findAll();
        if (postList.size() > 0) {
            return postRepository.findAll();
        } else {
            throw new NoSuchElementException(String.format("Cannot find if there is no Post in DataBase :("));
        }
    }

    public Optional<Post> findPostById(Long idPost) {
        return postRepository.findById(idPost);
    }

    public Post saveSinglePost(Post post, Long idAuthor) {
        Optional<Author> author = authorRepository.findById(idAuthor);
        if (author.isPresent()) {
            return postRepository.save(post);
        } else {
            throw new DataIntegrityViolationException(String.format("Cannot add post because there is no Author with Id No.%s", idAuthor));
        }
    }

    public void deleteSinglePostById(Long idPost) {
        Optional<Post> optionalPost = postRepository.findById(idPost);
        if (optionalPost.isEmpty()) {
            throw new NoSuchElementException(String.format("There is no post with ID No.%s", idPost));
        } else {
            postRepository.deleteById(idPost);
        }
    }
//    NumberFormatException tu dziala
    public AuthorWithCategory getPostByAuthorPostAndCategoryPost(Long idAuthor, String categoryPost) {
        Optional<Author> optionalAuthor = authorRepository.findById(idAuthor);
        if (optionalAuthor.isPresent()) {
            List<Post> listOfPost = postRepository.findByAuthorPostAndCategoryPost(optionalAuthor.get(), categoryPost);
            return new AuthorWithCategory(optionalAuthor.get().getNameAuthor(), categoryPost, listOfPost.size());
        } else {
            throw new NoSuchElementException(String.format("Author with ID No.%s does not exist.", idAuthor));
        }
    }

    public Post updateBodyPost(Long idPost, Post updatedPost) {
        Optional<Post> post = postRepository.findById(idPost);
        if (post.isPresent()) {
            if (!(post.get().getBodyPost().equals(updatedPost.getBodyPost()))) {
                post.get().setBodyPost(updatedPost.getBodyPost());
            }
            postRepository.save(post.get());
            return post.get();
        } else {
            //todo zmienic to sprawdzic chyba spoko jest!!!!!!!!!!!!!!!!!!!!!!!!
            throw new NoSuchElementException(String.format("There is no post with ID No.%s", idPost));
        }
    }

    public List<Post> findSpecificPost(String pattern) {
        List<Post> listOfAllPosts = postRepository.findAll();
        return listOfAllPosts.stream()
                .filter(post -> post.getBodyPost()
                        .contains(pattern)).collect(Collectors.toList());
    }
}