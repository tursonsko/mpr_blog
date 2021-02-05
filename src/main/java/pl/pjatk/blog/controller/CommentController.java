package pl.pjatk.blog.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pl.pjatk.blog.customExceptions.CountMaxCommentsException;
import pl.pjatk.blog.model.Comment;
import pl.pjatk.blog.model.Post;
import pl.pjatk.blog.service.CommentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comment")
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public ResponseEntity<List<Comment>> findAllComments() {
        return ResponseEntity.ok(commentService.findAllComments());
    }

    //todo sprawdzic
    @GetMapping("/{idComment}")
    public ResponseEntity<Optional<Comment>> findCommentById(@PathVariable Long idComment) {
        Optional<Comment> byIdComment = commentService.findCommentById(idComment);
        if (byIdComment.isPresent()) {
            return ResponseEntity.ok(byIdComment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //todo sprawdzic
    @DeleteMapping("/{idComment}")
    public ResponseEntity<Void> deleteSingleCommentById(@PathVariable Long idComment) {
        commentService.deleteSingleCommentById(idComment);
        return ResponseEntity.ok().build();
    }

    //TODO update
    @PutMapping("/{idComment}")
    public ResponseEntity<Comment> updateBodyComment(@RequestBody Comment comment, @PathVariable Long idComment) {
        return ResponseEntity.ok(commentService.updateBodyComment(idComment, comment));
    }

    @PostMapping("/{idPost}")
    public ResponseEntity<Comment> saveSingleComment(@RequestBody Comment comment, @PathVariable Long idPost) throws CountMaxCommentsException {
        return ResponseEntity.ok(commentService.saveSingleComment(comment, idPost));
    }
}