package pl.pjatk.blog.service;

import org.springframework.stereotype.Service;
import pl.pjatk.blog.model.Author;
import pl.pjatk.blog.repository.AuthorRepository;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Service
public class AuthorService {

    private AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> findAll(){
        return authorRepository.findAll();
    }

    public Author save(Author author) {
        return authorRepository.save(author);
    }
}
