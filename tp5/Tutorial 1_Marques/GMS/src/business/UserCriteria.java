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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class UserCriteria extends AbstractORMCriteria {
	public final StringExpression name;
	public final StringExpression email;
	public final StringExpression password;
	public final CollectionExpression games;
	
	public UserCriteria(Criteria criteria) {
		super(criteria);
		name = new StringExpression("name", this);
		email = new StringExpression("email", this);
		password = new StringExpression("password", this);
		games = new CollectionExpression("ORM_Games", this);
	}
	
	public UserCriteria(PersistentSession session) {
		this(session.createCriteria(User.class));
	}
	
	public UserCriteria() throws PersistentException {
		this(MddpPersistentManager.instance().getSession());
	}
	
	public GameCriteria createGamesCriteria() {
		return new GameCriteria(createCriteria("ORM_Games"));
	}
	
	public User uniqueUser() {
		return (User) super.uniqueResult();
	}
	
	public User[] listUser() {
		java.util.List list = super.list();
		return (User[]) list.toArray(new User[list.size()]);
	}
}

