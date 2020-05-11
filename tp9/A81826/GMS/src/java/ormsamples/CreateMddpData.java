/**
 * Licensee: joaomarques(Universidade do Minho)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class CreateMddpData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = business.MddpPersistentManager.instance().getSession().beginTransaction();
		try {
			business.User lbusinessUser = business.UserDAO.createUser();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : games, name
			business.UserDAO.save(lbusinessUser);
			business.Game lbusinessGame = business.GameDAO.createGame();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : price, year, name
			business.GameDAO.save(lbusinessGame);
			business.Platform lbusinessPlatform = business.PlatformDAO.createPlatform();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : year, name
			business.PlatformDAO.save(lbusinessPlatform);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateMddpData createMddpData = new CreateMddpData();
			try {
				createMddpData.createTestData();
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
