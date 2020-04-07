package pt.uminho.di.aa;

public class UserDontExistException extends Exception {
    public UserDontExistException(String error) {
        super(error);
    }
}
