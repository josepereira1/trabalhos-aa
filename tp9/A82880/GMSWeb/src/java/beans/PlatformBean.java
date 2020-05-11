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
import pt.uminho.di.aa.Platform;
import pt.uminho.di.aa.PlatformDAO;
import pt.uminho.di.aa.PlatformExistsException;

/**
 *
 * @author josepereira
 */
@Stateless
public class PlatformBean implements PlatformBeanLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public void registerPlatform(Platform platform) throws PersistentException, PlatformExistsException {
        if(!containsPlatform(platform.getName())) PlatformDAO.save(platform);
        else throw new PlatformExistsException(platform.getName());
    }
    
    private boolean containsPlatform(String name) throws PersistentException {
        Platform res = null;
        PersistentSession session = GMS.getSession();
        if(session != null)res = PlatformDAO.getPlatformByORMID(session, name);
        else res = PlatformDAO.getPlatformByORMID(name);
        if(res == null) return false;
        else return true;
    }
}
