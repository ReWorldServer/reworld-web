package ReWorld.exception;

public class NoBlogPostsFoundException extends RuntimeException {
    public NoBlogPostsFoundException(String message) {
        super(message);
    }
}
