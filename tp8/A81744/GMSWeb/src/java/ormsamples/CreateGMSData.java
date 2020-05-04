/**
 * Licensee: Ricardo Petronilho(Universidade do Minho)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class CreateGMSData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = aa.GMSPersistentManager.instance().getSession().beginTransaction();
		try {
			aa.User laaUser = aa.UserDAO.createUser();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : games, name
			aa.UserDAO.save(laaUser);
			aa.Game laaGame = aa.GameDAO.createGame();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : platforms, users, price, year, name
			aa.GameDAO.save(laaGame);
			aa.Platform laaPlatform = aa.PlatformDAO.createPlatform();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : games, year, name
			aa.PlatformDAO.save(laaPlatform);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateGMSData createGMSData = new CreateGMSData();
			try {
				createGMSData.createTestData();
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
