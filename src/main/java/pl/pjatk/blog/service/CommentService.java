package pl.pjatk.blog.service;

import org.springframework.stereotype.Service;
import pl.pjatk.blog.model.Author;
import pl.pjatk.blog.model.Comment;
import pl.pjatk.blog.repository.AuthorRepository;
import pl.pjatk.blog.repository.CommentRepository;

import java.util.Calendar;
import java.util.Date;
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

        Calendar c = Calendar.getInstance();
        c.setTime(comment.getTimeComment());
        //zmienic na minute
        c.add(Calendar.SECOND, -15);

        Date currentDateMinusOne = c.getTime();
        Long count = commentRepository.getCommentsYoungerThanOneMinute(currentDateMinusOne);

        if(count < 5) {
            return commentRepository.save(comment);
        }
        return new Comment();
    }
}
