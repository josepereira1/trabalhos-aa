package business;

public class UserDontExistException extends Exception {
    public UserDontExistException(String error) {
        super(error);
    }
}
