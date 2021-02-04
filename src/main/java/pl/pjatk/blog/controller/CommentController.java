package pl.pjatk.blog.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.blog.model.Comment;
import pl.pjatk.blog.model.Post;
import pl.pjatk.blog.service.CommentService;
import pl.pjatk.blog.service.PostService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public ResponseEntity<List<Comment>> findAll() {
        return ResponseEntity.ok(commentService.findAll());
    }

    //TODO findbyid

    //TODO delete

    //TODO update

    @PostMapping("/{idPost}")
    public ResponseEntity<Comment> save(@RequestBody Comment comment, @PathVariable Long idPost) {

        return ResponseEntity.ok(commentService.save(comment, idPost));
    }
}
