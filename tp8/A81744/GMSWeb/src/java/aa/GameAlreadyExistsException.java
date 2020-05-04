package aa;

public class GameAlreadyExistsException extends Exception {
    public GameAlreadyExistsException(String name) {
        super(name);
    }
}
