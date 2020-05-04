package business;

public class PlatformAlreadyExistsException extends Exception {
    public PlatformAlreadyExistsException(String error) {
        super(error);
    }
}
