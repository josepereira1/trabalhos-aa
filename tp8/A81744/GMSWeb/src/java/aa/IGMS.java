package aa;

import org.orm.PersistentException;

import java.util.Collection;
import org.orm.PersistentSession;

public interface IGMS {   
    void registerUser(User user) throws PersistentException, UserAlreadyExistsException;
    public User getUser(String username) throws PersistentException, UserNotExistsException;
    Collection<Game> getUserGames(String username) throws PersistentException, UserNotExistsException;
    boolean autenticateUser(String username, String password) throws PersistentException, UserNotExistsException;
    void addGameToUser(String username, Game game) throws PersistentException, UserNotExistsException;

    void registerGame(Game game) throws PersistentException, GameAlreadyExistsException;
    Collection<Game> getAllGames() throws PersistentException;
    Game getGame(String gameName) throws PersistentException, GameNotExistsException;
    void deleteGame(String gameName) throws PersistentException, GameNotExistsException;
    
    void registerPlatform(Platform platform) throws PersistentException, PlatformAlreadyExistsException;
    Platform getPlatform(String platformname) throws PersistentException, PlatformNotExistsException;
    Collection<Platform> getAllPlatforms() throws PersistentException;
}
