/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import aa.Game;
import aa.User;
import aa.UserAlreadyExistsException;
import aa.UserNotExistsException;
import java.util.Collection;
import javax.ejb.Local;
import org.orm.PersistentException;

/**
 *
 * @author Ricardo Petronilho
 */
@Local
public interface UserSessionBeanLocal {
    void registerUser(User user) throws PersistentException, UserAlreadyExistsException;
    public User getUser(String name) throws PersistentException, UserNotExistsException;
    Collection<Game> getUserGames(String userName) throws PersistentException, UserNotExistsException;
    boolean autenticateUser(String name, String password) throws PersistentException, UserNotExistsException;
    void addGameToUser(String username, Game game) throws PersistentException, UserNotExistsException;
}
