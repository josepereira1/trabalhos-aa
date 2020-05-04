/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import business.GMS;
import business.Game;
import business.GameAlreadyExistsException;
import business.GameCriteria;
import business.GameDAO;
import business.GameDontExistException;
import business.User;
import business.UserCriteria;
import business.UserDAO;
import business.UserDontExistException;
import java.util.Arrays;
import java.util.Collection;
import javax.ejb.Stateless;
import org.orm.PersistentException;

/**
 *
 * @author joaomarques
 */
@Stateless
public class GameBean implements GameBeanLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public Collection<Game> allGames() throws PersistentException {
        return  Arrays.asList(GameDAO.listGameByCriteria(new GameCriteria(GMS.getSession())));
    }
    
    @Override
    public Game getGameByName(String name) throws PersistentException, GameDontExistException {
        Game g = GameDAO.getGameByORMID(GMS.getSession(),name);
        if(g == null) throw new GameDontExistException(name);
        return g;
    }
    
    @Override
    public Collection<Game> getGamesByUser(String name) throws UserDontExistException, PersistentException {
        User u = UserDAO.getUserByORMID(GMS.getSession(),name);
        if(u == null) throw new UserDontExistException(name);
        return Arrays.asList(u.games.toArray());
    }
    
    @Override
    public void registerGame(Game game) throws GameAlreadyExistsException, PersistentException {
        Game g = GameDAO.getGameByORMID(GMS.getSession(),game.getName());
        if(g != null) throw new GameAlreadyExistsException(game.getName());
        GameDAO.save(game);
    }
    
    @Override
    public void deleteGame(String name) throws GameDontExistException, PersistentException {
        Game game = GameDAO.getGameByORMID(GMS.getSession(),name);
        if(game == null) throw new GameDontExistException(name);
        User[] users = UserDAO.listUserByCriteria(new UserCriteria(GMS.getSession()));
        for (User user : users) {
            Game[] games = user.games.toArray();
            for (Game value : games) {
                if (value.equals(game)) {
                    user.games.remove(game);
                    break;
                }
            }
        }
        GameDAO.delete(game);
    }
}
