/**
 * Licensee: joaomarques(Universidade do Minho)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateMddpData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = business.MddpPersistentManager.instance().getSession().beginTransaction();
		try {
			business.User lbusinessUser = business.UserDAO.loadUserByQuery(null, null);
			// Update the properties of the persistent object
			business.UserDAO.save(lbusinessUser);
			business.Game lbusinessGame = business.GameDAO.loadGameByQuery(null, null);
			// Update the properties of the persistent object
			business.GameDAO.save(lbusinessGame);
			business.Platform lbusinessPlatform = business.PlatformDAO.loadPlatformByQuery(null, null);
			// Update the properties of the persistent object
			business.PlatformDAO.save(lbusinessPlatform);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving User by UserCriteria");
		business.UserCriteria lbusinessUserCriteria = new business.UserCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbusinessUserCriteria.name.eq();
		System.out.println(lbusinessUserCriteria.uniqueUser());
		
		System.out.println("Retrieving Game by GameCriteria");
		business.GameCriteria lbusinessGameCriteria = new business.GameCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbusinessGameCriteria.name.eq();
		System.out.println(lbusinessGameCriteria.uniqueGame());
		
		System.out.println("Retrieving Platform by PlatformCriteria");
		business.PlatformCriteria lbusinessPlatformCriteria = new business.PlatformCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbusinessPlatformCriteria.name.eq();
		System.out.println(lbusinessPlatformCriteria.uniquePlatform());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateMddpData retrieveAndUpdateMddpData = new RetrieveAndUpdateMddpData();
			try {
				retrieveAndUpdateMddpData.retrieveAndUpdateTestData();
				//retrieveAndUpdateMddpData.retrieveByCriteria();
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
