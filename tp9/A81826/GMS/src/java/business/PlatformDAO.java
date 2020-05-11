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

public class PlatformDAO {
	public static Platform loadPlatformByORMID(String name) throws PersistentException {
		try {
			PersistentSession session = MddpPersistentManager.instance().getSession();
			return loadPlatformByORMID(session, name);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Platform getPlatformByORMID(String name) throws PersistentException {
		try {
			PersistentSession session = MddpPersistentManager.instance().getSession();
			return getPlatformByORMID(session, name);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Platform loadPlatformByORMID(String name, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MddpPersistentManager.instance().getSession();
			return loadPlatformByORMID(session, name, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Platform getPlatformByORMID(String name, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MddpPersistentManager.instance().getSession();
			return getPlatformByORMID(session, name, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Platform loadPlatformByORMID(PersistentSession session, String name) throws PersistentException {
		try {
			return (Platform) session.load(business.Platform.class, name);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Platform getPlatformByORMID(PersistentSession session, String name) throws PersistentException {
		try {
			return (Platform) session.get(business.Platform.class, name);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Platform loadPlatformByORMID(PersistentSession session, String name, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Platform) session.load(business.Platform.class, name, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Platform getPlatformByORMID(PersistentSession session, String name, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Platform) session.get(business.Platform.class, name, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPlatform(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MddpPersistentManager.instance().getSession();
			return queryPlatform(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPlatform(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MddpPersistentManager.instance().getSession();
			return queryPlatform(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Platform[] listPlatformByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MddpPersistentManager.instance().getSession();
			return listPlatformByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Platform[] listPlatformByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MddpPersistentManager.instance().getSession();
			return listPlatformByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPlatform(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From business.Platform as Platform");
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
	
	public static List queryPlatform(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From business.Platform as Platform");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Platform", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Platform[] listPlatformByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryPlatform(session, condition, orderBy);
			return (Platform[]) list.toArray(new Platform[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Platform[] listPlatformByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryPlatform(session, condition, orderBy, lockMode);
			return (Platform[]) list.toArray(new Platform[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Platform loadPlatformByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MddpPersistentManager.instance().getSession();
			return loadPlatformByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Platform loadPlatformByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MddpPersistentManager.instance().getSession();
			return loadPlatformByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Platform loadPlatformByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Platform[] platforms = listPlatformByQuery(session, condition, orderBy);
		if (platforms != null && platforms.length > 0)
			return platforms[0];
		else
			return null;
	}
	
	public static Platform loadPlatformByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Platform[] platforms = listPlatformByQuery(session, condition, orderBy, lockMode);
		if (platforms != null && platforms.length > 0)
			return platforms[0];
		else
			return null;
	}
	
	public static java.util.Iterator iteratePlatformByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MddpPersistentManager.instance().getSession();
			return iteratePlatformByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePlatformByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MddpPersistentManager.instance().getSession();
			return iteratePlatformByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePlatformByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From business.Platform as Platform");
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
	
	public static java.util.Iterator iteratePlatformByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From business.Platform as Platform");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Platform", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Platform createPlatform() {
		return new business.Platform();
	}
	
	public static boolean save(business.Platform platform) throws PersistentException {
		try {
			MddpPersistentManager.instance().saveObject(platform);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(business.Platform platform) throws PersistentException {
		try {
			MddpPersistentManager.instance().deleteObject(platform);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(business.Platform platform) throws PersistentException {
		try {
			MddpPersistentManager.instance().getSession().refresh(platform);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(business.Platform platform) throws PersistentException {
		try {
			MddpPersistentManager.instance().getSession().evict(platform);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Platform loadPlatformByCriteria(PlatformCriteria platformCriteria) {
		Platform[] platforms = listPlatformByCriteria(platformCriteria);
		if(platforms == null || platforms.length == 0) {
			return null;
		}
		return platforms[0];
	}
	
	public static Platform[] listPlatformByCriteria(PlatformCriteria platformCriteria) {
		return platformCriteria.listPlatform();
	}
}
