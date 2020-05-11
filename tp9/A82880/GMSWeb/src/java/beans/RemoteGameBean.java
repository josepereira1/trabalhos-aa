/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Stateless;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import pt.uminho.di.aa.GMS;
import pt.uminho.di.aa.Game;
import pt.uminho.di.aa.GameCriteria;
import pt.uminho.di.aa.GameDAO;
import pt.uminho.di.aa.GameExistsException;
import pt.uminho.di.aa.GameNotExistsException;
import pt.uminho.di.aa.GameSetCollection;
import pt.uminho.di.aa.InvalidParametersException;
import pt.uminho.di.aa.User;
import pt.uminho.di.aa.UserDAO;
import pt.uminho.di.aa.UserNotExistsException;

/**
 *
 * @author josepereira
 */
@Stateless
public class RemoteGameBean implements RemoteGameBeanRemote{

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public void registerGame(Game game) throws PersistentException, GameExistsException, InvalidParametersException {
        PersistentSession session = GMS.getSession();
        
        if(game.getName() == null || game.getName().equals("") || game.getPlatform() == null) throw new InvalidParametersException();
        if(!containsGame(game.getName())){
            GameDAO.save(game);
        }else throw new GameExistsException(game.getName());
    }

    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public void addGameToPersonalLibrary(String username, String gameName) throws PersistentException, UserNotExistsException, InvalidParametersException, GameNotExistsException {
        PersistentSession session = GMS.getSession();
        
        if(username == null || username.equals("") || gameName == null || gameName.equals("")) throw new InvalidParametersException();
        if(!containsUser(username)) throw new UserNotExistsException(username);

        if(containsGame(gameName)){
            Game game = null;

            if(session == null) game = GameDAO.getGameByORMID(gameName);
            else game = GameDAO.getGameByORMID(session, gameName);

            User user = UserDAO.getUserByORMID(username);
            user.games.add(game);
            UserDAO.save(user);
        }
        else throw new GameNotExistsException(gameName);
    }
    
    public GameSetCollection listUserGames(String username) throws PersistentException {
        PersistentSession session = GMS.getSession();
        
        if(containsUser(username))
            if(session != null)
                return UserDAO.getUserByORMID(session, username).games;
            else return UserDAO.getUserByORMID(username).games;
        return null;
    }

    public Game[] listAllGames() throws PersistentException {
        PersistentSession session = GMS.getSession();
        
        if(session != null)return GameDAO.listGameByCriteria(new GameCriteria(session));
        else return GameDAO.listGameByCriteria(new GameCriteria());
    }
    
    public Game searchGame(String name) throws PersistentException, GameNotExistsException, InvalidParametersException {
        PersistentSession session = GMS.getSession();
        
        if(name == null || name.equals("")) throw new InvalidParametersException();
        if(containsGame(name))
            if(session != null) return GameDAO.getGameByORMID(session, name);
            else return GameDAO.getGameByORMID(name);
        else throw new GameNotExistsException(name);
    }
    
    public boolean deleteGame(Game game) throws PersistentException, GameNotExistsException {
        PersistentSession session = GMS.getSession();
        
        if(containsGame(game.getName())) return GameDAO.delete(game);
        else throw new GameNotExistsException(game.getName());
    }
    
    private boolean containsUser(String name) throws PersistentException {
        PersistentSession session = GMS.getSession();
        
        User res = null;
        if(session != null)res = UserDAO.getUserByORMID(session, name);
        else res = UserDAO.getUserByORMID(name);
        if(res == null) return false;
        else return true;
    }

    private boolean containsGame(String name) throws PersistentException {
        PersistentSession session = GMS.getSession();
        
        Game res = null;
        if(session != null)res = GameDAO.getGameByORMID(session, name);
        else res = GameDAO.getGameByORMID(name);
        if(res == null) return false;
        else return true;
    }
}
