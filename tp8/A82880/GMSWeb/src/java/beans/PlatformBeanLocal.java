/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Local;
import org.orm.PersistentException;
import pt.uminho.di.aa.Platform;
import pt.uminho.di.aa.PlatformExistsException;

/**
 *
 * @author josepereira
 */
@Local
public interface PlatformBeanLocal {
    void registerPlatform(Platform platform) throws PersistentException, PlatformExistsException;
}
