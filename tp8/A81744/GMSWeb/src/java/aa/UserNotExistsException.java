package aa;

public class UserNotExistsException extends Exception {
    public UserNotExistsException(String userName) {
        super(userName);
    }
}
