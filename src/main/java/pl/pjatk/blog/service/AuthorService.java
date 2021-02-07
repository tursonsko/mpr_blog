package pl.pjatk.blog.service;

import org.springframework.stereotype.Service;

import pl.pjatk.blog.customExceptions.EmailExistsException;
import pl.pjatk.blog.model.Author;
import pl.pjatk.blog.repository.AuthorRepository;

import java.util.*;

@Service
public class AuthorService {

    private AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> findAll() {
        authorRepository.count();
        List<Author> authorList = authorRepository.findAll();
        if (authorList.size() > 0) {
            return authorRepository.findAll();
        } else {
            throw new NoSuchElementException(String.format("Cannot find if there is no Author :("));
        }
    }

    public Optional<Author> findById(Long idAuthor) {
        return authorRepository.findById(idAuthor);
    }

    public Author save(Author newAuthor) throws Exception {
        List<Author> authorList = authorRepository.findAll();
        for (Author providedAuthor : authorList) {
            if ((providedAuthor.getEmailAuthor().equals(newAuthor.getEmailAuthor()))) {
                throw new EmailExistsException("Provided email already exists in DataBase!");
            }
        }
        return authorRepository.save(newAuthor);
    }
}