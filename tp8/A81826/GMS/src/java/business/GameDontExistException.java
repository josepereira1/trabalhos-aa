package business;

public class GameDontExistException extends Exception {
    public GameDontExistException(String error) {
        super(error);
    }
}
