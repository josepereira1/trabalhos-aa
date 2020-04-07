package pt.uminho.di.aa;

public class GameDontExistsException extends Exception {
    public GameDontExistsException(String error) {
        super(error);
    }
}
