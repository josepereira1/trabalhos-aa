/**
 * Licensee: Ricardo Petronilho(Universidade do Minho)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class ListGMSData {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing User...");
		aa.User[] aaUsers = aa.UserDAO.listUserByQuery(null, null);
		int length = Math.min(aaUsers.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(aaUsers[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Game...");
		aa.Game[] aaGames = aa.GameDAO.listGameByQuery(null, null);
		length = Math.min(aaGames.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(aaGames[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Platform...");
		aa.Platform[] aaPlatforms = aa.PlatformDAO.listPlatformByQuery(null, null);
		length = Math.min(aaPlatforms.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(aaPlatforms[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing User by Criteria...");
		aa.UserCriteria laaUserCriteria = new aa.UserCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//laaUserCriteria.name.eq();
		laaUserCriteria.setMaxResults(ROW_COUNT);
		aa.User[] aaUsers = laaUserCriteria.listUser();
		int length =aaUsers== null ? 0 : Math.min(aaUsers.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(aaUsers[i]);
		}
		System.out.println(length + " User record(s) retrieved."); 
		
		System.out.println("Listing Game by Criteria...");
		aa.GameCriteria laaGameCriteria = new aa.GameCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//laaGameCriteria.name.eq();
		laaGameCriteria.setMaxResults(ROW_COUNT);
		aa.Game[] aaGames = laaGameCriteria.listGame();
		length =aaGames== null ? 0 : Math.min(aaGames.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(aaGames[i]);
		}
		System.out.println(length + " Game record(s) retrieved."); 
		
		System.out.println("Listing Platform by Criteria...");
		aa.PlatformCriteria laaPlatformCriteria = new aa.PlatformCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//laaPlatformCriteria.name.eq();
		laaPlatformCriteria.setMaxResults(ROW_COUNT);
		aa.Platform[] aaPlatforms = laaPlatformCriteria.listPlatform();
		length =aaPlatforms== null ? 0 : Math.min(aaPlatforms.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(aaPlatforms[i]);
		}
		System.out.println(length + " Platform record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListGMSData listGMSData = new ListGMSData();
			try {
				listGMSData.listTestData();
				//listGMSData.listByCriteria();
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
