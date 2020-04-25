package aa;

public class GameNotExistsException extends Exception {
    public GameNotExistsException(String gameName) {
        super(gameName);
    }
}
