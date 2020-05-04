/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.ejb.Stateless;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import pt.uminho.di.aa.Checksum;
import pt.uminho.di.aa.GMS;
import pt.uminho.di.aa.InvalidParametersException;
import pt.uminho.di.aa.User;
import pt.uminho.di.aa.UserDAO;
import pt.uminho.di.aa.UserExistsException;

/**
 *
 * @author josepereira
 */
@Stateless
public class UserBean implements UserBeanLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Override
    public String sayHello(String name) {
        return "Hello" + name;
    }
    
    public boolean login(String name, String password) throws PersistentException, NoSuchAlgorithmException {
        
        if(name != null && password !=null && containsUser(name)){
            String cryptPassword = Checksum.getFileChecksum(password.getBytes(), MessageDigest.getInstance("SHA-256"));
            return cryptPassword.equals(UserDAO.getUserByORMID(name).getPassword());
        }else
            return false;
    }
    public void registerUser(User user) throws PersistentException, UserExistsException, NoSuchAlgorithmException, InvalidParametersException {
        if((user.getName() == null || user.getName().equals("")) || (user.getPassword() == null || user.getPassword().equals("")) || (user.getEmail() == null || user.getEmail().equals(""))) throw new InvalidParametersException();
        if(!containsUser(user.getName())){
            //  create user with an hashed password.
            if(user.getPassword() != null)user.setPassword(Checksum.getFileChecksum(user.getPassword().getBytes(), MessageDigest.getInstance("SHA-256")));
            UserDAO.save(user);
        }
        else throw new UserExistsException(user.getName());
    }
    
    private boolean containsUser(String name) throws PersistentException {
        User res = null;
        PersistentSession session = GMS.getSession();
        if(session != null)res = UserDAO.getUserByORMID(session, name);
        else res = UserDAO.getUserByORMID(name);
        if(res == null) return false;
        else return true;
    }
}
