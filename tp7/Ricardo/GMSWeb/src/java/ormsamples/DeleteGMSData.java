/**
 * Licensee: Ricardo Petronilho(Universidade do Minho)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class DeleteGMSData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = aa.GMSPersistentManager.instance().getSession().beginTransaction();
		try {
			aa.User laaUser = aa.UserDAO.loadUserByQuery(null, null);
			// Delete the persistent object
			aa.UserDAO.delete(laaUser);
			aa.Game laaGame = aa.GameDAO.loadGameByQuery(null, null);
			// Delete the persistent object
			aa.GameDAO.delete(laaGame);
			aa.Platform laaPlatform = aa.PlatformDAO.loadPlatformByQuery(null, null);
			// Delete the persistent object
			aa.PlatformDAO.delete(laaPlatform);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeleteGMSData deleteGMSData = new DeleteGMSData();
			try {
				deleteGMSData.deleteTestData();
			}
			finally {
				aa.GMSPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
