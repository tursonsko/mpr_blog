package pl.pjatk.blog.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import pl.pjatk.blog.customExceptions.CountMaxCommentsException;
import pl.pjatk.blog.model.Author;
import pl.pjatk.blog.model.Comment;
import pl.pjatk.blog.model.Post;
import pl.pjatk.blog.repository.AuthorRepository;
import pl.pjatk.blog.repository.CommentRepository;
import pl.pjatk.blog.repository.PostRepository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    private CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    public List<Comment> findAll(){
        return commentRepository.findAll();
    }

    public Comment save(Comment comment, Long idPost) {
        Optional<Post> optionalPost = postRepository.findById(idPost);
        if (optionalPost.isEmpty()) {
            throw new DataIntegrityViolationException(String.format("Cannot add comment becasue there is no Post with Id No. %s", idPost));
        } else {
            Calendar c = Calendar.getInstance();
            c.setTime(comment.getTimeComment());
            c.add(Calendar.SECOND, -15);/*zmienic na minute*/

            Date currentDateMinusOne = c.getTime();
            Long count = commentRepository.getCommentsYoungerThanOneMinute(currentDateMinusOne);

            if (count < 5) {
                return commentRepository.save(comment);
            } else {
                throw new CountMaxCommentsException(String.format("You are allowed to add maximum %s comments in 1 minute", count));
            }
        }

    }

}
