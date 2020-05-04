/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import business.GMS;
import business.Game;
import business.GameDAO;
import business.GameDontExistException;
import business.User;
import business.UserAlreadyExistsException;
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
public class UserBean implements UserBeanLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public Collection<User> getAllUsers() throws PersistentException {
        return Arrays.asList(UserDAO.listUserByCriteria(new UserCriteria(GMS.getSession())));
    }
    
    @Override
    public User getUserByName(String name) throws PersistentException, UserDontExistException {
        User u = UserDAO.getUserByORMID(GMS.getSession(),name);
        if(u == null) throw new UserDontExistException(name);
        return u;
    }
    
    @Override
    public void registerUser(User user) throws UserAlreadyExistsException, PersistentException {
        User u = UserDAO.getUserByORMID(GMS.getSession(),user.getName());
        if(u != null) throw new UserAlreadyExistsException(user.getName());
        UserDAO.save(user);
    }
    
    @Override
    public void addGameToUser(String game, String user) throws GameDontExistException, PersistentException, UserDontExistException {
        Game g = GameDAO.getGameByORMID(GMS.getSession(),game);
        User u = UserDAO.getUserByORMID(GMS.getSession(),user);
        if(g == null) throw new GameDontExistException(game);
        if(u == null) throw new UserDontExistException(user);
        u.games.add(g);
        UserDAO.save(u);
    }
}
