/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import aa.Game;
import aa.GameAlreadyExistsException;
import aa.GameNotExistsException;
import java.util.Collection;
import javax.ejb.Local;
import org.orm.PersistentException;
import org.orm.PersistentSession;

/**
 *
 * @author Ricardo Petronilho
 */
@Local
public interface GameSessionBeanLocal {
    void registerGame(Game game) throws PersistentException, GameAlreadyExistsException;
    Collection<Game> getAllGames() throws PersistentException;
    Game getGame(String gameName) throws PersistentException, GameNotExistsException;
    void deleteGame(String gameName) throws PersistentException, GameNotExistsException;
}
