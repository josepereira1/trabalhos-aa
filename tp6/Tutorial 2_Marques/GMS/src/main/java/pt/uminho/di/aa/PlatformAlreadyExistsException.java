package pt.uminho.di.aa;

public class PlatformAlreadyExistsException extends Exception {
    public PlatformAlreadyExistsException(String error) {
        super(error);
    }
}
