package pl.pjatk.blog.service;

import org.springframework.stereotype.Service;
import pl.pjatk.blog.model.Author;
import pl.pjatk.blog.model.Comment;
import pl.pjatk.blog.repository.AuthorRepository;
import pl.pjatk.blog.repository.CommentRepository;

import java.util.List;

@Service
public class CommentService {
    private CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> findAll(){
        return commentRepository.findAll();
    }

    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }
}
