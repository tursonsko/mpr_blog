package pl.pjatk.blog.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pl.pjatk.blog.model.AuthorWithCategory;
import pl.pjatk.blog.model.Post;
import pl.pjatk.blog.service.PostService;

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
    public ResponseEntity<List<Post>> findAllPosts() {
        return ResponseEntity.ok(postService.findAllPosts());
    }

    @GetMapping("/{idPost}")
    public ResponseEntity<Optional<Post>> findPostById(@PathVariable Long idPost) {
        Optional<Post> byIdPost = postService.findPostById(idPost);
        if (byIdPost.isPresent()) {
            return ResponseEntity.ok(byIdPost);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{idAuthor}")
    public ResponseEntity<Post> saveSinglePost(@RequestBody Post post, @PathVariable Long idAuthor) {
        return ResponseEntity.ok(postService.saveSinglePost(post, idAuthor));
    }

    @DeleteMapping("/{idPost}")
    public ResponseEntity<Void> deleteSinglePostById(@PathVariable Long idPost) {
        postService.deleteSinglePostById(idPost);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{idPost}")
    public ResponseEntity<Post> updateBodyPost(@RequestBody Post post, @PathVariable Long idPost) {
        return ResponseEntity.ok(postService.updateBodyPost(idPost, post));
    }

    @GetMapping("/{idAuthor}/{categoryPost}")
    public ResponseEntity<AuthorWithCategory> findPostByAuthorAndCategory(@PathVariable Long idAuthor, @PathVariable String categoryPost) {
        AuthorWithCategory listOfPosts = postService.getPostByAuthorPostAndCategoryPost(idAuthor, categoryPost);
        return ResponseEntity.ok(listOfPosts);
    }

    @GetMapping("/filter/{pattern}")
    public ResponseEntity<List<Post>> findSpecificPost(@PathVariable String pattern) {
        return ResponseEntity.ok(postService.findSpecificPost(pattern));
    }
}