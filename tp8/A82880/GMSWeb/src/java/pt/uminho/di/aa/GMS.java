package pt.uminho.di.aa;

import beans.GameBeanLocal;
import beans.PlatformBeanLocal;
import beans.UserBeanLocal;
import org.orm.PersistentException;
import org.orm.PersistentSession;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class GMS {

    PlatformBeanLocal platformBean = lookupPlatformBeanLocal();

    UserBeanLocal userBean = lookupUserBeanLocal();

    GameBeanLocal gameBean = lookupGameBeanLocal();
    
    private static GMS gms; //  Singleton
    private static PersistentSession session;
    
    protected GMS(){
        
    }
    
    //  Singleton
    public static GMS getGMS(){
        if(gms == null)gms = new GMS();
        return gms;
    }
    
    public static PersistentSession getSession(){
        if(session == null){
            try {
                session = GamemanagementPersistentManager.instance().getSession();
            } catch (PersistentException ex) {
                Logger.getLogger(GMS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return session;
    }
    
    public boolean login(String name, String password) throws PersistentException, NoSuchAlgorithmException {
        if(userBean != null)
            return userBean.login(name, password);
        else return false;
    }
    public void registerUser(User user) throws PersistentException, UserExistsException, NoSuchAlgorithmException, InvalidParametersException {
        if(userBean != null)
            userBean.registerUser(user);
    }

    public void registerGame(Game game) throws PersistentException, GameExistsException, InvalidParametersException {
        if(gameBean != null)
            gameBean.registerGame(game);
    }

    public void addGameToPersonalLibrary(String username, String gameName) throws PersistentException, UserNotExistsException, InvalidParametersException, GameNotExistsException {
        if(gameBean != null)gameBean.addGameToPersonalLibrary(username, gameName);
    }

    public void registerPlatform(Platform platform) throws PersistentException, PlatformExistsException {
        if(platformBean != null)platformBean.registerPlatform(platform);
    }

    public GameSetCollection listUserGames(String username) throws PersistentException {
        if(gameBean != null)
            return gameBean.listUserGames(username);
        else return null;
    }

    public Game[] listAllGames() throws PersistentException {
        if(gameBean != null)
            return gameBean.listAllGames();
        else return null;
    }

    public Game searchGame(String name) throws PersistentException, GameNotExistsException, InvalidParametersException {
        if(gameBean != null)
            return gameBean.searchGame(name);
        else return null;
    }

    public boolean deleteGame(Game game) throws PersistentException, GameNotExistsException {
        if(gameBean != null)
            return gameBean.deleteGame(game);
        else return false;
    }

    private GameBeanLocal lookupGameBeanLocal() {
        try {
            Context c = new InitialContext();
            return (GameBeanLocal) c.lookup("java:global/GMSWeb/GameBean!beans.GameBeanLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private UserBeanLocal lookupUserBeanLocal() {
        try {
            Context c = new InitialContext();
            return (UserBeanLocal) c.lookup("java:global/GMSWeb/UserBean!beans.UserBeanLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private PlatformBeanLocal lookupPlatformBeanLocal() {
        try {
            Context c = new InitialContext();
            return (PlatformBeanLocal) c.lookup("java:global/GMSWeb/PlatformBean!beans.PlatformBeanLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
