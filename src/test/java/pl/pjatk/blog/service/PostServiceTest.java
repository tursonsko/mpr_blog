package pl.pjatk.blog.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.pjatk.blog.model.Author;
import pl.pjatk.blog.repository.AuthorRepository;
import pl.pjatk.blog.repository.PostRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class PostServiceTest {
    @InjectMocks
    private PostService postService;

    @Mock
    private PostRepository postRepository;

    @Test
    public void testFindByIdWorksProperly() {

        //given

        //when

        //then

    }
}
