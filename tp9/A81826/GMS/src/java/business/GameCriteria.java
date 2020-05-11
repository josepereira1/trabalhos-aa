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

public class GameCriteria extends AbstractORMCriteria {
	public final StringExpression name;
	public final StringExpression platformId;
	public final AssociationExpression platform;
	public final IntegerExpression year;
	public final FloatExpression price;
	public final StringExpression description;
	
	public GameCriteria(Criteria criteria) {
		super(criteria);
		name = new StringExpression("name", this);
		platformId = new StringExpression("platform.name", this);
		platform = new AssociationExpression("platform", this);
		year = new IntegerExpression("year", this);
		price = new FloatExpression("price", this);
		description = new StringExpression("description", this);
	}
	
	public GameCriteria(PersistentSession session) {
		this(session.createCriteria(Game.class));
	}
	
	public GameCriteria() throws PersistentException {
		this(MddpPersistentManager.instance().getSession());
	}
	
	public PlatformCriteria createPlatformCriteria() {
		return new PlatformCriteria(createCriteria("platform"));
	}
	
	public Game uniqueGame() {
		return (Game) super.uniqueResult();
	}
	
	public Game[] listGame() {
		java.util.List list = super.list();
		return (Game[]) list.toArray(new Game[list.size()]);
	}
}

