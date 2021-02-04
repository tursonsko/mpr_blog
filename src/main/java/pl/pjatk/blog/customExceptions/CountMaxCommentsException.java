package pl.pjatk.blog.customExceptions;

public class CountMaxCommentsException extends RuntimeException{
    public CountMaxCommentsException(String errorMessage) {
        super(errorMessage);
    }
}
