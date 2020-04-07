package pt.uminho.di.aa;

public class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(String error) {
        super(error);
    }
}
