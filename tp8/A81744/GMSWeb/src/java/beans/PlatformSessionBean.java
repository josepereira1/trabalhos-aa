/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import aa.GMS;
import aa.Platform;
import aa.PlatformAlreadyExistsException;
import aa.PlatformCriteria;
import aa.PlatformDAO;
import aa.PlatformNotExistsException;
import java.util.Arrays;
import java.util.Collection;
import javax.ejb.Stateless;
import org.orm.PersistentException;
import org.orm.PersistentSession;

/**
 *
 * @author Ricardo Petronilho
 */
@Stateless
public class PlatformSessionBean implements PlatformSessionBeanLocal {

    @Override
    public Collection<Platform> getAllPlatforms() throws PersistentException {
        Platform[] platforms = PlatformDAO.listPlatformByCriteria(new PlatformCriteria(GMS.getSession()));
        return Arrays.asList(platforms);
    }

    @Override
    public void registerPlatform(Platform platform) throws PersistentException, PlatformAlreadyExistsException {
        if (PlatformDAO.getPlatformByORMID(GMS.getSession(), platform.getName()) != null) throw new PlatformAlreadyExistsException(platform.getName());
        PlatformDAO.save(platform);
    }

    @Override
    public Platform getPlatform(String platformname) throws PersistentException, PlatformNotExistsException {
        Platform platform = PlatformDAO.getPlatformByORMID(GMS.getSession(), platformname);
        if (platform == null) throw new PlatformNotExistsException(platformname);
        return platform;
    }
}
