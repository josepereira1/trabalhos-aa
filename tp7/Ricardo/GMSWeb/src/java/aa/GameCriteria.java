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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class GameCriteria extends AbstractORMCriteria {
	public final StringExpression name;
	public final IntegerExpression year;
	public final DoubleExpression price;
	public final StringExpression description;
	public final CollectionExpression users;
	public final CollectionExpression platforms;
	
	public GameCriteria(Criteria criteria) {
		super(criteria);
		name = new StringExpression("name", this);
		year = new IntegerExpression("year", this);
		price = new DoubleExpression("price", this);
		description = new StringExpression("description", this);
		users = new CollectionExpression("ORM_Users", this);
		platforms = new CollectionExpression("ORM_Platforms", this);
	}
	
	public GameCriteria(PersistentSession session) {
		this(session.createCriteria(Game.class));
	}
	
	public GameCriteria() throws PersistentException {
		this(GMSPersistentManager.instance().getSession());
	}
	
	public UserCriteria createUsersCriteria() {
		return new UserCriteria(createCriteria("ORM_Users"));
	}
	
	public PlatformCriteria createPlatformsCriteria() {
		return new PlatformCriteria(createCriteria("ORM_Platforms"));
	}
	
	public Game uniqueGame() {
		return (Game) super.uniqueResult();
	}
	
	public Game[] listGame() {
		java.util.List list = super.list();
		return (Game[]) list.toArray(new Game[list.size()]);
	}
}

