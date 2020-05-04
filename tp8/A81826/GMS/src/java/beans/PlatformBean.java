/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import business.GMS;
import business.Platform;
import business.PlatformAlreadyExistsException;
import business.PlatformCriteria;
import business.PlatformDAO;
import business.PlatformDontExistException;
import java.util.Arrays;
import java.util.Collection;
import javax.ejb.Stateless;
import org.orm.PersistentException;

/**
 *
 * @author joaomarques
 */
@Stateless
public class PlatformBean implements PlatformBeanLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public Collection<Platform> allPlatforms() throws PersistentException {
        return Arrays.asList(PlatformDAO.listPlatformByCriteria(new PlatformCriteria(GMS.getSession())));
    }
    
    @Override
    public Platform getPlatformByName(String name) throws PersistentException, PlatformDontExistException {
        Platform p = PlatformDAO.getPlatformByORMID(GMS.getSession(),name);
        if(p == null) throw new PlatformDontExistException(name);
        return p;
    }
    @Override
    public void registerPlatform(Platform platform) throws PersistentException, PlatformAlreadyExistsException {
        Platform p = PlatformDAO.getPlatformByORMID(GMS.getSession(),platform.getName());
        if(p != null) throw new PlatformAlreadyExistsException(platform.getName());
        PlatformDAO.save(platform);
    }
}
