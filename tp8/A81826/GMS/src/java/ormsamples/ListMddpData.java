/**
 * Licensee: joaomarques(Universidade do Minho)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class ListMddpData {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing User...");
		business.User[] businessUsers = business.UserDAO.listUserByQuery(null, null);
		int length = Math.min(businessUsers.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(businessUsers[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Game...");
		business.Game[] businessGames = business.GameDAO.listGameByQuery(null, null);
		length = Math.min(businessGames.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(businessGames[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Platform...");
		business.Platform[] businessPlatforms = business.PlatformDAO.listPlatformByQuery(null, null);
		length = Math.min(businessPlatforms.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(businessPlatforms[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing User by Criteria...");
		business.UserCriteria lbusinessUserCriteria = new business.UserCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lbusinessUserCriteria.name.eq();
		lbusinessUserCriteria.setMaxResults(ROW_COUNT);
		business.User[] businessUsers = lbusinessUserCriteria.listUser();
		int length =businessUsers== null ? 0 : Math.min(businessUsers.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(businessUsers[i]);
		}
		System.out.println(length + " User record(s) retrieved."); 
		
		System.out.println("Listing Game by Criteria...");
		business.GameCriteria lbusinessGameCriteria = new business.GameCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lbusinessGameCriteria.name.eq();
		lbusinessGameCriteria.setMaxResults(ROW_COUNT);
		business.Game[] businessGames = lbusinessGameCriteria.listGame();
		length =businessGames== null ? 0 : Math.min(businessGames.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(businessGames[i]);
		}
		System.out.println(length + " Game record(s) retrieved."); 
		
		System.out.println("Listing Platform by Criteria...");
		business.PlatformCriteria lbusinessPlatformCriteria = new business.PlatformCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lbusinessPlatformCriteria.name.eq();
		lbusinessPlatformCriteria.setMaxResults(ROW_COUNT);
		business.Platform[] businessPlatforms = lbusinessPlatformCriteria.listPlatform();
		length =businessPlatforms== null ? 0 : Math.min(businessPlatforms.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(businessPlatforms[i]);
		}
		System.out.println(length + " Platform record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListMddpData listMddpData = new ListMddpData();
			try {
				listMddpData.listTestData();
				//listMddpData.listByCriteria();
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
