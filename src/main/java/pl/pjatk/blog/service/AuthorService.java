package pl.pjatk.blog.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
        List<Author> authorList = authorRepository.findAll();
        if (authorList.size() > 0) {
            return authorRepository.findAll();
        } else {

            //todo to poprawic!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            throw new NoSuchElementException(String.format("dupa"));
        }
    }



    //todo finbyid
    public Optional<Author> findById(Long idAuthor) {
        return authorRepository.findById(idAuthor);
    }

    //todo ma chodzi na woch wyjatkach
    public Author save(Author author) throws Exception {
        List<Author> authorList = authorRepository.findAll();
        for (Author author1 : authorList) {
            if ((author1.getEmailAuthor().equals(author.getEmailAuthor()))) {
                //todo obsluzyc to bo jest ZLE , sa 2 wyjatki z jednej metody i nie rzuca emailaEXists
                return authorRepository.save(author);
            }
        }
        throw new Exception("istnieje juz taki email w bazie");

        //todo sprawdzic MethodArgumentNotValidException bo cos sie zagubilem, trzeba to rozwiazac jakos
        //"todo cd." zeby smigalyob wyjatki w postmanie a nie rzuca 500
        //TODO POPATRZEC NA SAVE Z COMMENT_SERVICE I TAK TO ROZWIAZAC ZEBY CHODZILY OBA EXCEPTIONS
        //TODO CountMaxCommentsException to jest custom i chyba trzeba zrobic oba customy na emaile
        //todo na dwoch ifach mysle ze beda dzialac
    }
}