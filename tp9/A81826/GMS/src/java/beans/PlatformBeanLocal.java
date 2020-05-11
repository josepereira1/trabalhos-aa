/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import business.Platform;
import business.PlatformAlreadyExistsException;
import business.PlatformDontExistException;
import java.util.Collection;
import javax.ejb.Local;
import org.orm.PersistentException;
import org.orm.PersistentSession;

/**
 *
 * @author joaomarques
 */
@Local
public interface PlatformBeanLocal {
    Collection<Platform> allPlatforms() throws PersistentException;
    Platform getPlatformByName(String name) throws PersistentException, PlatformDontExistException;
    void registerPlatform(Platform platform) throws PersistentException, PlatformAlreadyExistsException;
}
