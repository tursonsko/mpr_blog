package pl.pjatk.blog.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.pjatk.blog.model.Author;
import pl.pjatk.blog.repository.AuthorRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {

    @InjectMocks
    private AuthorService authorService;

    @Mock
    private AuthorRepository authorRepository;

    @Mock
    private Author author;

    @Test
    public void testFindAllIsEmpty() {
        assertThrows(NoSuchElementException.class, () -> authorService.findAll());
    }

    @Test
    public void testFindAllIsNotEmpty() {
        //given

        //when
        when(authorRepository.findAll()).thenReturn(List.of(author));
        List<Author> authorList = authorService.findAll();

        //then
        assertThat(authorList).isNotEmpty();
    }

    @Test
    public void testFindByIdWorksProperly() {

        //given
        when(author.getIdAuthor()).thenReturn(1L);
        when(authorRepository.findById(author.getIdAuthor())).thenReturn(Optional.of(author));
        //when
        Optional<Author> authorById = authorService.findById(author.getIdAuthor());
        //then
        assertThat(authorById).isNotNull();
        assertThat(authorById).isNotEmpty();
        assertThat(authorById.get().getIdAuthor()).isEqualTo(1L);
    }

}