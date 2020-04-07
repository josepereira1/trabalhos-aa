package pt.uminho.di.aa;

public class GameAlreadyExistsException extends Exception {
    public GameAlreadyExistsException(String error) {
        super(error);
    }
}
