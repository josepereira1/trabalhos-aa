/**
 * Licensee: Ricardo Petronilho(Universidade do Minho)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateGMSData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = aa.GMSPersistentManager.instance().getSession().beginTransaction();
		try {
			aa.User laaUser = aa.UserDAO.loadUserByQuery(null, null);
			// Update the properties of the persistent object
			aa.UserDAO.save(laaUser);
			aa.Game laaGame = aa.GameDAO.loadGameByQuery(null, null);
			// Update the properties of the persistent object
			aa.GameDAO.save(laaGame);
			aa.Platform laaPlatform = aa.PlatformDAO.loadPlatformByQuery(null, null);
			// Update the properties of the persistent object
			aa.PlatformDAO.save(laaPlatform);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving User by UserCriteria");
		aa.UserCriteria laaUserCriteria = new aa.UserCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//laaUserCriteria.name.eq();
		System.out.println(laaUserCriteria.uniqueUser());
		
		System.out.println("Retrieving Game by GameCriteria");
		aa.GameCriteria laaGameCriteria = new aa.GameCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//laaGameCriteria.name.eq();
		System.out.println(laaGameCriteria.uniqueGame());
		
		System.out.println("Retrieving Platform by PlatformCriteria");
		aa.PlatformCriteria laaPlatformCriteria = new aa.PlatformCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//laaPlatformCriteria.name.eq();
		System.out.println(laaPlatformCriteria.uniquePlatform());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateGMSData retrieveAndUpdateGMSData = new RetrieveAndUpdateGMSData();
			try {
				retrieveAndUpdateGMSData.retrieveAndUpdateTestData();
				//retrieveAndUpdateGMSData.retrieveByCriteria();
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
