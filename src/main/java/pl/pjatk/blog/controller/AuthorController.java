package pl.pjatk.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.blog.model.Author;
import pl.pjatk.blog.service.AuthorService;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<List<Author>> findAll() {
        return ResponseEntity.ok(authorService.findAll());
    }

    @GetMapping("/{idAuthor}")
    public ResponseEntity<Optional<Author>> findById(@PathVariable Long idAuthor) {
        Optional<Author> optionalAuthor = authorService.findById(idAuthor);
        if (optionalAuthor.isPresent()) {
            return ResponseEntity.ok(optionalAuthor);
        } else {
            throw new NoSuchElementException(String.format("There is no Author with ID No. %s", idAuthor));
        }
    }

    @PostMapping
    public ResponseEntity<Author> save(@Valid @RequestBody Author newAuthor) throws Exception {
        return ResponseEntity.ok(authorService.save(newAuthor));
    }
}
