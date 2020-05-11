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

public class PlatformCriteria extends AbstractORMCriteria {
	public final StringExpression name;
	public final IntegerExpression year;
	public final StringExpression description;
	public final StringExpression manufacturer;
	
	public PlatformCriteria(Criteria criteria) {
		super(criteria);
		name = new StringExpression("name", this);
		year = new IntegerExpression("year", this);
		description = new StringExpression("description", this);
		manufacturer = new StringExpression("manufacturer", this);
	}
	
	public PlatformCriteria(PersistentSession session) {
		this(session.createCriteria(Platform.class));
	}
	
	public PlatformCriteria() throws PersistentException {
		this(MddpPersistentManager.instance().getSession());
	}
	
	public Platform uniquePlatform() {
		return (Platform) super.uniqueResult();
	}
	
	public Platform[] listPlatform() {
		java.util.List list = super.list();
		return (Platform[]) list.toArray(new Platform[list.size()]);
	}
}

