/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import aa.Platform;
import aa.PlatformAlreadyExistsException;
import aa.PlatformNotExistsException;
import java.util.Collection;
import javax.ejb.Local;
import org.orm.PersistentException;

/**
 *
 * @author Ricardo Petronilho
 */
@Local
public interface PlatformSessionBeanLocal {
    void registerPlatform(Platform platform) throws PersistentException, PlatformAlreadyExistsException;
    Platform getPlatform(String platformname) throws PersistentException, PlatformNotExistsException;
    Collection<Platform> getAllPlatforms() throws PersistentException;
}
