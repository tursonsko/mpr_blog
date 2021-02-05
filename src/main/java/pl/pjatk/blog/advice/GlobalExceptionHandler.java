package pl.pjatk.blog.advice;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.pjatk.blog.customExceptions.EmailExistsException;
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleMethodArgumentNotValidException() {
        return new ResponseEntity<>("Provided email address does not match with standards :)", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmailExistsException.class)
    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
    public ResponseEntity<Object> handleEmailExistsException(EmailExistsException exception) {
        return new ResponseEntity<>(exception.toString(), HttpStatus.NOT_ACCEPTABLE);
    }
}
