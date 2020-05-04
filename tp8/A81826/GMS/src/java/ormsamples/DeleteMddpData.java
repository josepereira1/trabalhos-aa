/**
 * Licensee: joaomarques(Universidade do Minho)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class DeleteMddpData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = business.MddpPersistentManager.instance().getSession().beginTransaction();
		try {
			business.User lbusinessUser = business.UserDAO.loadUserByQuery(null, null);
			// Delete the persistent object
			business.UserDAO.delete(lbusinessUser);
			business.Game lbusinessGame = business.GameDAO.loadGameByQuery(null, null);
			// Delete the persistent object
			business.GameDAO.delete(lbusinessGame);
			business.Platform lbusinessPlatform = business.PlatformDAO.loadPlatformByQuery(null, null);
			// Delete the persistent object
			business.PlatformDAO.delete(lbusinessPlatform);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeleteMddpData deleteMddpData = new DeleteMddpData();
			try {
				deleteMddpData.deleteTestData();
			}
			finally {
				business.MddpPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
