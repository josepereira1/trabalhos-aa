/**
 * Licensee: josepereira(Universidade do Minho)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class CreateGamemanagementDatabaseSchema {
	public static void main(String[] args) {
		try {
			ORMDatabaseInitiator.createSchema(pt.uminho.di.aa.GamemanagementPersistentManager.instance());
			pt.uminho.di.aa.GamemanagementPersistentManager.instance().disposePersistentManager();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
