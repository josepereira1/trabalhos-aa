package aa;

public class PlatformAlreadyExistsException extends Exception {
    public PlatformAlreadyExistsException(String name) {
        super(name);
    }
}
