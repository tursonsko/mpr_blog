package pl.pjatk.blog.customExceptions;

public class CountMaxCommentsException extends Exception{
    public CountMaxCommentsException(String errorMessage) {
        super(errorMessage);
    }
}
