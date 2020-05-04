/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Local;
import org.orm.PersistentException;
import pt.uminho.di.aa.Game;
import pt.uminho.di.aa.GameExistsException;
import pt.uminho.di.aa.GameNotExistsException;
import pt.uminho.di.aa.GameSetCollection;
import pt.uminho.di.aa.InvalidParametersException;
import pt.uminho.di.aa.UserNotExistsException;
/**
 *
 * @author josepereira
 */
@Local
public interface GameBeanLocal {
    String sayHello(String name);
    void registerGame(Game game) throws PersistentException, GameExistsException, InvalidParametersException;
    void addGameToPersonalLibrary(String username, String gameName) throws PersistentException, UserNotExistsException, InvalidParametersException, GameNotExistsException;
    GameSetCollection listUserGames(String username) throws PersistentException;
    Game[] listAllGames() throws PersistentException;
    Game searchGame(String name) throws PersistentException, GameNotExistsException, InvalidParametersException;
    boolean deleteGame(Game game) throws PersistentException, GameNotExistsException;
}
