package pl.pjatk.blog.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.pjatk.blog.customExceptions.CountMaxCommentsException;
import pl.pjatk.blog.model.Author;
import pl.pjatk.blog.model.Comment;
import pl.pjatk.blog.model.Post;
import pl.pjatk.blog.repository.AuthorRepository;
import pl.pjatk.blog.repository.CommentRepository;
import pl.pjatk.blog.repository.PostRepository;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


import java.util.*;

@ExtendWith(MockitoExtension.class)
public class CommentServiceTest {
    @InjectMocks
    private CommentService commentService;

    @Mock
    private CommentRepository commentRepository;

    @Mock
    private PostRepository postRepository;

    @Mock
    private Comment comment;

    @Mock
    private Post post;

    @Mock
    private Date date;
//nie dziala
    @Test
    public void shouldSaveSingleComment() throws CountMaxCommentsException {
        Date date = new Date();
        Comment comment = new Comment("wojtek", "to jest komentarz");
        Calendar c = Calendar.getInstance();
        Post post = new Post("dupa", "plityka", List.of(comment));
        Mockito.when(postRepository.findById(1L)).thenReturn(Optional.of(post));
        Mockito.when(commentRepository.getCommentsYoungerThanOneMinute(date)).thenReturn(2L);
        Mockito.when(commentRepository.save(comment)).thenReturn(comment);
        Comment commentRetrieved = commentService.saveSingleComment(comment, comment.getIdComment());
        assertThat(commentRetrieved).isNotNull();
    }

    @Test
    public void testFindAllIsEmpty() {
        assertThrows(NoSuchElementException.class, () -> commentService.findAllComments());
    }

}
