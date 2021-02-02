package pl.pjatk.blog.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.pjatk.blog.model.Comment;
import pl.pjatk.blog.model.Post;
import pl.pjatk.blog.service.CommentService;
import pl.pjatk.blog.service.PostService;

import java.util.List;

public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public ResponseEntity<List<Comment>> findAll() {
        return ResponseEntity.ok(commentService.findAll());
    }

    @PostMapping
    public ResponseEntity<Comment> save(@RequestBody Comment comment) {
        return ResponseEntity.ok(commentService.save(comment));
    }
}
