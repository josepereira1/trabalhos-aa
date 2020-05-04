/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import business.Game;
import business.GameAlreadyExistsException;
import business.GameDontExistException;
import business.UserDontExistException;
import java.util.Collection;
import javax.ejb.Local;
import org.orm.PersistentException;

/**
 *
 * @author joaomarques
 */
@Local
public interface GameBeanLocal {
    Collection<Game> allGames() throws PersistentException;
    Game getGameByName(String name) throws PersistentException, GameDontExistException;
    Collection<Game> getGamesByUser(String name) throws UserDontExistException, PersistentException;
    void registerGame(Game game) throws GameAlreadyExistsException, PersistentException;
    void deleteGame(String name) throws GameDontExistException, PersistentException;
}
