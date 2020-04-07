package business;

public class UserAlreadyExistsException extends Exception{
    public UserAlreadyExistsException(String error) {
        super(error);
    }
}
