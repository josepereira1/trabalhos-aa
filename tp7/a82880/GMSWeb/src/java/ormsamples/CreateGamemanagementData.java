/**
 * Licensee: josepereira(Universidade do Minho)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class CreateGamemanagementData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = pt.uminho.di.aa.GamemanagementPersistentManager.instance().getSession().beginTransaction();
		try {
			pt.uminho.di.aa.User lptuminhodiaaUser = pt.uminho.di.aa.UserDAO.createUser();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : games, name
			pt.uminho.di.aa.UserDAO.save(lptuminhodiaaUser);
			pt.uminho.di.aa.Game lptuminhodiaaGame = pt.uminho.di.aa.GameDAO.createGame();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : price, year, name
			pt.uminho.di.aa.GameDAO.save(lptuminhodiaaGame);
			pt.uminho.di.aa.Platform lptuminhodiaaPlatform = pt.uminho.di.aa.PlatformDAO.createPlatform();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : year, name
			pt.uminho.di.aa.PlatformDAO.save(lptuminhodiaaPlatform);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateGamemanagementData createGamemanagementData = new CreateGamemanagementData();
			try {
				createGamemanagementData.createTestData();
			}
			finally {
				pt.uminho.di.aa.GamemanagementPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
