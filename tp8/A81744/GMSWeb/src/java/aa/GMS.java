package aa;

import beans.GameSessionBeanLocal;
import beans.PlatformSessionBeanLocal;
import beans.UserSessionBeanLocal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.orm.PersistentException;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.hibernate.Query;
import org.orm.PersistentSession;

public class GMS implements IGMS {

    private UserSessionBeanLocal userSessionBean = lookupUserSessionBeanLocal();
    private PlatformSessionBeanLocal platformSessionBean = lookupPlatformSessionBeanLocal();
    private GameSessionBeanLocal gameSessionBean = lookupGameSessionBeanLocal();  
    
    private static IGMS gms = null;
    private static PersistentSession session = null;
    
    private GMS() {}
    
    public static IGMS getGMS() {
        if (gms == null) gms = new GMS();
        return gms;
    }
    
    public static PersistentSession getSession() throws PersistentException {
        if (session == null) session = GMSPersistentManager.instance().getSession();
        return session;
    }
    
    
    public void addGameToUser(String username, Game game) throws PersistentException, UserNotExistsException {
        this.userSessionBean.addGameToUser(username, game);
    }

    @Override
    public void registerUser(User user) throws PersistentException, UserAlreadyExistsException {
        this.userSessionBean.registerUser(user);
    }

    @Override
    public void registerGame(Game game) throws PersistentException, GameAlreadyExistsException {
       this.gameSessionBean.registerGame(game);
    }

    @Override
    public void registerPlatform(Platform platform) throws PersistentException, PlatformAlreadyExistsException {
        this.platformSessionBean.registerPlatform(platform);
    }
    
    @Override
    public User getUser(String username) throws PersistentException, UserNotExistsException {
        return this.userSessionBean.getUser(username);
    }
    
    @Override
    public Platform getPlatform(String platformname) throws PersistentException, PlatformNotExistsException {
        return this.platformSessionBean.getPlatform(platformname);
    }
    
    @Override
    public boolean autenticateUser(String username, String password) throws PersistentException, UserNotExistsException {
        return this.userSessionBean.autenticateUser(username, password);
    }

    @Override
    public Collection<Game> getUserGames(String username) throws PersistentException, UserNotExistsException {
        return this.userSessionBean.getUserGames(username);
    }

    @Override
    public Collection<Game> getAllGames() throws PersistentException {
        return this.gameSessionBean.getAllGames();
    }

    @Override
    public Game getGame(String gameName) throws PersistentException, GameNotExistsException {
        return this.gameSessionBean.getGame(gameName);
    }

    @Override
    public void deleteGame(String gameName) throws PersistentException, GameNotExistsException {
        this.gameSessionBean.deleteGame(gameName);
    }
    
    @Override
    public Collection<Platform> getAllPlatforms() throws PersistentException {
        return this.platformSessionBean.getAllPlatforms();
    }

    private GameSessionBeanLocal lookupGameSessionBeanLocal() {
        try {
            Context c = new InitialContext();
            return (GameSessionBeanLocal) c.lookup("java:global/GMSWeb/GameSessionBean!beans.GameSessionBeanLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private PlatformSessionBeanLocal lookupPlatformSessionBeanLocal() {
        try {
            Context c = new InitialContext();
            return (PlatformSessionBeanLocal) c.lookup("java:global/GMSWeb/PlatformSessionBean!beans.PlatformSessionBeanLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private UserSessionBeanLocal lookupUserSessionBeanLocal() {
        try {  
            Context c = new InitialContext();
            return (UserSessionBeanLocal) c.lookup("java:global/GMSWeb/UserSessionBean!beans.UserSessionBeanLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    
}