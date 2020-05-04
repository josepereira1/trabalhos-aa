/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: joaomarques(Universidade do Minho)
 * License Type: Academic
 */
package business;

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class GameDAO {
	public static Game loadGameByORMID(String name) throws PersistentException {
		try {
			PersistentSession session = MddpPersistentManager.instance().getSession();
			return loadGameByORMID(session, name);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Game getGameByORMID(String name) throws PersistentException {
		try {
			PersistentSession session = MddpPersistentManager.instance().getSession();
			return getGameByORMID(session, name);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Game loadGameByORMID(String name, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MddpPersistentManager.instance().getSession();
			return loadGameByORMID(session, name, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Game getGameByORMID(String name, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MddpPersistentManager.instance().getSession();
			return getGameByORMID(session, name, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Game loadGameByORMID(PersistentSession session, String name) throws PersistentException {
		try {
			return (Game) session.load(business.Game.class, name);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Game getGameByORMID(PersistentSession session, String name) throws PersistentException {
		try {
			return (Game) session.get(business.Game.class, name);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Game loadGameByORMID(PersistentSession session, String name, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Game) session.load(business.Game.class, name, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Game getGameByORMID(PersistentSession session, String name, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Game) session.get(business.Game.class, name, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryGame(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MddpPersistentManager.instance().getSession();
			return queryGame(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryGame(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MddpPersistentManager.instance().getSession();
			return queryGame(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Game[] listGameByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MddpPersistentManager.instance().getSession();
			return listGameByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Game[] listGameByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MddpPersistentManager.instance().getSession();
			return listGameByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryGame(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From business.Game as Game");
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
		StringBuffer sb = new StringBuffer("From business.Game as Game");
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
			PersistentSession session = MddpPersistentManager.instance().getSession();
			return loadGameByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Game loadGameByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MddpPersistentManager.instance().getSession();
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
			PersistentSession session = MddpPersistentManager.instance().getSession();
			return iterateGameByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateGameByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MddpPersistentManager.instance().getSession();
			return iterateGameByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateGameByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From business.Game as Game");
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
		StringBuffer sb = new StringBuffer("From business.Game as Game");
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
		return new business.Game();
	}
	
	public static boolean save(business.Game game) throws PersistentException {
		try {
			MddpPersistentManager.instance().saveObject(game);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(business.Game game) throws PersistentException {
		try {
			MddpPersistentManager.instance().deleteObject(game);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(business.Game game) throws PersistentException {
		try {
			MddpPersistentManager.instance().getSession().refresh(game);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(business.Game game) throws PersistentException {
		try {
			MddpPersistentManager.instance().getSession().evict(game);
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
