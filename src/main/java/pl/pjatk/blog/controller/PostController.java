package pl.pjatk.blog.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.blog.model.Author;
import pl.pjatk.blog.model.Post;
import pl.pjatk.blog.service.AuthorService;
import pl.pjatk.blog.service.PostService;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/post")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<List<Post>> findAll() {
        return ResponseEntity.ok(postService.findAll());
    }

    @PostMapping
    public ResponseEntity<Post> save(@RequestBody Post post) {
        return ResponseEntity.ok(postService.save(post));
    }

    @GetMapping("/{idAuthor}/{categoryPost}")
    public ResponseEntity<List<Object[]>> findPostByAuthorAndCategory(@PathVariable Long idAuthor, @PathVariable String categoryPost) {
        List<Object[]> listOfPosts = postService.getPostByAuthorPostAndCategoryPost(idAuthor, categoryPost);
        return ResponseEntity.ok(listOfPosts);
    }


}

