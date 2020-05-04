/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import aa.GMS;
import aa.Game;
import aa.User;
import aa.UserAlreadyExistsException;
import aa.UserDAO;
import aa.UserNotExistsException;
import java.util.Arrays;
import java.util.Collection;
import javax.ejb.Stateless;
import org.orm.PersistentException;

/**
 *
 * @author Ricardo Petronilho
 */
@Stateless
public class UserSessionBean implements UserSessionBeanLocal {

    @Override
    public void registerUser(User user) throws PersistentException, UserAlreadyExistsException {
        if (UserDAO.getUserByORMID(GMS.getSession(), user.getName()) != null) throw new UserAlreadyExistsException(user.getName());
        UserDAO.save(user);
    }

    @Override
    public User getUser(String name) throws PersistentException, UserNotExistsException {
        User user = UserDAO.getUserByORMID(GMS.getSession(), name);
        if (user == null) throw new UserNotExistsException(name);
        return user;
    }

    @Override
    public Collection<Game> getUserGames(String userName) throws PersistentException, UserNotExistsException {
        User user =  UserDAO.getUserByORMID(GMS.getSession(), userName);
        if (user == null) throw new UserNotExistsException(userName);
        return Arrays.asList(user.games.toArray());
    }

    @Override
    public boolean autenticateUser(String username, String password) throws PersistentException, UserNotExistsException {
        User user = this.getUser(username);
        return user.getPassword().equals(password);
    }

    @Override
    public void addGameToUser(String username, Game game) throws PersistentException, UserNotExistsException {
        User user = getUser(username);  
        user.games.add(game);
        UserDAO.save(user);
    }
}
