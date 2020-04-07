package business;

public class PlatformDontExistException extends Exception {
    public PlatformDontExistException(String error) {
        super(error);
    }
}
