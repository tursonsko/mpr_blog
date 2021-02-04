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
    public ResponseEntity<List<Post>> findAll() {
        return ResponseEntity.ok(postService.findAll());
    }

    @GetMapping("/{idPost}")
    public ResponseEntity<Optional<Post>> findById(@PathVariable Long idPost) {
        Optional<Post> byIdPost = postService.findById(idPost);
        if(byIdPost.isPresent()) {
            return ResponseEntity.ok(byIdPost);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{idAuthor}")
    public ResponseEntity<Post> save(@RequestBody Post post, @PathVariable Long idAuthor) {
        return ResponseEntity.ok(postService.save(post, idAuthor));
    }


    @DeleteMapping("/{idPost}")
    public ResponseEntity<Void> delete(@PathVariable Long idPost) {
        postService.delete(idPost);
        return ResponseEntity.ok().build();
    }


    @PutMapping("/{idPost}")
    public ResponseEntity<Post> update(@RequestBody Post post, @PathVariable Long idPost) {
        return ResponseEntity.ok(postService.update(idPost, post));
    }


    @GetMapping("/{idAuthor}/{categoryPost}")
    public ResponseEntity<AuthorWithCategory> findPostByAuthorAndCategory(@PathVariable Long idAuthor, @PathVariable String categoryPost) {
        AuthorWithCategory listOfPosts = postService.getPostByAuthorPostAndCategoryPost(idAuthor, categoryPost);
        return ResponseEntity.ok(listOfPosts);
    }

}

