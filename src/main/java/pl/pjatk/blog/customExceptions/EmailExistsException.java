package pl.pjatk.blog.customExceptions;

public class EmailExistsException extends Exception {
    public EmailExistsException(String errorMessage) {
        super(errorMessage);
    }
}
