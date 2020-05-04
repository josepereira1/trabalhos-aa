/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Ricardo Petronilho(Universidade do Minho)
 * License Type: Academic
 */
package aa;

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class GameDAO {
	public static Game loadGameByORMID(String name) throws PersistentException {
		try {
			PersistentSession session = GMSPersistentManager.instance().getSession();
			return loadGameByORMID(session, name);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Game getGameByORMID(String name) throws PersistentException {
		try {
			PersistentSession session = GMSPersistentManager.instance().getSession();
			return getGameByORMID(session, name);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Game loadGameByORMID(String name, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = GMSPersistentManager.instance().getSession();
			return loadGameByORMID(session, name, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Game getGameByORMID(String name, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = GMSPersistentManager.instance().getSession();
			return getGameByORMID(session, name, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Game loadGameByORMID(PersistentSession session, String name) throws PersistentException {
		try {
			return (Game) session.load(aa.Game.class, name);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Game getGameByORMID(PersistentSession session, String name) throws PersistentException {
		try {
			return (Game) session.get(aa.Game.class, name);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Game loadGameByORMID(PersistentSession session, String name, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Game) session.load(aa.Game.class, name, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Game getGameByORMID(PersistentSession session, String name, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Game) session.get(aa.Game.class, name, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryGame(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = GMSPersistentManager.instance().getSession();
			return queryGame(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryGame(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = GMSPersistentManager.instance().getSession();
			return queryGame(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Game[] listGameByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = GMSPersistentManager.instance().getSession();
			return listGameByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Game[] listGameByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = GMSPersistentManager.instance().getSession();
			return listGameByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryGame(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From aa.Game as Game");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryGame(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From aa.Game as Game");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Game", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Game[] listGameByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryGame(session, condition, orderBy);
			return (Game[]) list.toArray(new Game[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Game[] listGameByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryGame(session, condition, orderBy, lockMode);
			return (Game[]) list.toArray(new Game[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Game loadGameByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = GMSPersistentManager.instance().getSession();
			return loadGameByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Game loadGameByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = GMSPersistentManager.instance().getSession();
			return loadGameByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Game loadGameByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Game[] games = listGameByQuery(session, condition, orderBy);
		if (games != null && games.length > 0)
			return games[0];
		else
			return null;
	}
	
	public static Game loadGameByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Game[] games = listGameByQuery(session, condition, orderBy, lockMode);
		if (games != null && games.length > 0)
			return games[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateGameByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = GMSPersistentManager.instance().getSession();
			return iterateGameByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateGameByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = GMSPersistentManager.instance().getSession();
			return iterateGameByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateGameByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From aa.Game as Game");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateGameByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From aa.Game as Game");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Game", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Game createGame() {
		return new aa.Game();
	}
	
	public static boolean save(aa.Game game) throws PersistentException {
		try {
			GMSPersistentManager.instance().saveObject(game);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(aa.Game game) throws PersistentException {
		try {
			GMSPersistentManager.instance().deleteObject(game);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(aa.Game game)throws PersistentException {
		try {
			aa.User[] lUserss = game.users.toArray();
			for(int i = 0; i < lUserss.length; i++) {
				lUserss[i].games.remove(game);
			}
			aa.Platform[] lPlatformss = game.platforms.toArray();
			for(int i = 0; i < lPlatformss.length; i++) {
				lPlatformss[i].games.remove(game);
			}
			return delete(game);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(aa.Game game, org.orm.PersistentSession session)throws PersistentException {
		try {
			aa.User[] lUserss = game.users.toArray();
			for(int i = 0; i < lUserss.length; i++) {
				lUserss[i].games.remove(game);
			}
			aa.Platform[] lPlatformss = game.platforms.toArray();
			for(int i = 0; i < lPlatformss.length; i++) {
				lPlatformss[i].games.remove(game);
			}
			try {
				session.delete(game);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(aa.Game game) throws PersistentException {
		try {
			GMSPersistentManager.instance().getSession().refresh(game);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(aa.Game game) throws PersistentException {
		try {
			GMSPersistentManager.instance().getSession().evict(game);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Game loadGameByCriteria(GameCriteria gameCriteria) {
		Game[] games = listGameByCriteria(gameCriteria);
		if(games == null || games.length == 0) {
			return null;
		}
		return games[0];
	}
	
	public static Game[] listGameByCriteria(GameCriteria gameCriteria) {
		return gameCriteria.listGame();
	}
}
