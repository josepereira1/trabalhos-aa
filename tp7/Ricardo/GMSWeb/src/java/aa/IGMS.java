package aa;

import org.orm.PersistentException;

import java.util.Collection;
import org.orm.PersistentSession;

public interface IGMS {
    void registerUser(User user, PersistentSession s) throws PersistentException, UserAlreadyExistsException;
    void registerGame(Game game, PersistentSession s) throws PersistentException, GameAlreadyExistsException;
    void registerPlatform(Platform platform, PersistentSession s) throws PersistentException, PlatformAlreadyExistsException;
    
    public User getUser(String name, PersistentSession s)  throws PersistentException, UserNotExistsException;
    boolean autenticateUser(String name, String password, PersistentSession s) throws PersistentException, UserNotExistsException;

    Collection<Game> getUserGames(String userName, PersistentSession s) throws PersistentException, UserNotExistsException;
    Collection<Game> getAllGames(PersistentSession s) throws PersistentException;

    Game getGame(String gameName, PersistentSession s) throws PersistentException, GameNotExistsException;
    void deleteGame(String gameName, PersistentSession s) throws PersistentException, GameNotExistsException;
}
