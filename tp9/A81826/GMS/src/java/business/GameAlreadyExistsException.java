package business;

public class GameAlreadyExistsException extends Exception {
    public GameAlreadyExistsException(String error) {
        super(error);
    }
}
