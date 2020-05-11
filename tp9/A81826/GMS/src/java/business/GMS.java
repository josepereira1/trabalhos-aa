package business;

import beans.GameBeanLocal;
import beans.PlatformBeanLocal;
import beans.UserBeanLocal;
import org.orm.PersistentException;
import org.orm.PersistentSession;

import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class GMS {

    private final PlatformBeanLocal platformBean = lookupPlatformBeanLocal();
    private final GameBeanLocal gameBean = lookupGameBeanLocal();
    private final UserBeanLocal userBean = lookupUserBeanLocal();
    private static GMS gms;
    private static PersistentSession session = null;
    
    private GMS() {
        
    }
    
    public static PersistentSession getSession() {
        if(session == null) {
            try {
                session = MddpPersistentManager.instance().getSession();
            } catch(PersistentException e) {
                e.printStackTrace();
            }
        }
        return session;
    }
    
    public static GMS getGMS() {
        if(gms == null) gms = new GMS();
        return gms;
    }
    
    private UserBeanLocal lookupUserBeanLocal() {
        try {
            Context c = new InitialContext();
            return (UserBeanLocal) c.lookup("java:global/GMS/UserBean!beans.UserBeanLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    private GameBeanLocal lookupGameBeanLocal() {
        try {
            Context c = new InitialContext();
            return (GameBeanLocal) c.lookup("java:global/GMS/GameBean!beans.GameBeanLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private PlatformBeanLocal lookupPlatformBeanLocal() {
        try {
            Context c = new InitialContext();
            return (PlatformBeanLocal) c.lookup("java:global/GMS/PlatformBean!beans.PlatformBeanLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public Collection<User> getAllUsers() throws PersistentException {
        return userBean.getAllUsers();
    }

    public Collection<Game> allGames() throws PersistentException {
        return gameBean.allGames();
    }

    public Collection<Platform> allPlatforms() throws PersistentException {
        return platformBean.allPlatforms();
    }

    public User getUserByName(String name) throws PersistentException, UserDontExistException {
        return userBean.getUserByName(name);
    }

    public Game getGameByName(String name) throws PersistentException, GameDontExistException {
        return gameBean.getGameByName(name);
    }

    public Platform getPlatformByName(String name) throws PersistentException, PlatformDontExistException {
        return platformBean.getPlatformByName(name);
    }

    public Collection<Game> getGamesByUser(String name) throws UserDontExistException, PersistentException {
        return gameBean.getGamesByUser(name);
    }

    public void registerUser(User user) throws UserAlreadyExistsException, PersistentException {
        userBean.registerUser(user);
    }

    public void registerGame(Game game) throws GameAlreadyExistsException, PersistentException {
        gameBean.registerGame(game);
    }

    public void registerPlatform(Platform platform) throws PlatformAlreadyExistsException, PersistentException {
        platformBean.registerPlatform(platform);
    }

    public void addGameToUser(String game, String user) throws GameDontExistException, PersistentException, UserDontExistException {
        userBean.addGameToUser(game, user);
    }

    public void deleteGame(String name) throws GameDontExistException, PersistentException {
        gameBean.deleteGame(name);
    }
    
    public boolean login(String username, String password) throws PersistentException, UserDontExistException {
        User u = userBean.getUserByName(username);
        return u.getPassword().equals(password);
    }
}
