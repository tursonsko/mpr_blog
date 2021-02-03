package pl.pjatk.blog.service;

import org.springframework.stereotype.Service;
import pl.pjatk.blog.model.Author;
import pl.pjatk.blog.model.Post;
import pl.pjatk.blog.repository.PostRepository;

import java.util.List;

@Service
public class PostService {
    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> findAll(){
        return postRepository.findAll();
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public List<Object[]> getPostByAuthorPostAndCategoryPost(Long idAuthor, String categoryPost) {
//        idAuthor = Author.class.getAnnotation()
        return postRepository.getPostByAuthorPostAndCategoryPost(idAuthor, categoryPost);
    }
}
