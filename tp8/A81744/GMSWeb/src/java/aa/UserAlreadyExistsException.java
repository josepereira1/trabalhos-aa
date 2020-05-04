package aa;

public class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(String name) {
        super(name);
    }
}
