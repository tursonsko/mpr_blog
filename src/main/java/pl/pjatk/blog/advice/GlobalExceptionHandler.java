package pl.pjatk.blog.advice;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.pjatk.blog.customExceptions.CountMaxCommentsException;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleElementException(NoSuchElementException exception){
        return new ResponseEntity<>(exception.toString(), HttpStatus.BAD_REQUEST);
    }
//
    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException exception) {
        return new ResponseEntity<>(exception.toString(), HttpStatus.CONFLICT);
    }
//custom
    @ExceptionHandler(CountMaxCommentsException.class)
    @ResponseStatus(value = HttpStatus.TOO_MANY_REQUESTS)
    public ResponseEntity<Object> handleCountMaxCommentsException(CountMaxCommentsException exception) {
        return new ResponseEntity<>(exception.toString(), HttpStatus.TOO_MANY_REQUESTS);
    }

}
