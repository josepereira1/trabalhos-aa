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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class PlatformDetachedCriteria extends AbstractORMDetachedCriteria {
	public final StringExpression name;
	public final IntegerExpression year;
	public final StringExpression description;
	public final StringExpression manufacturer;
	public final CollectionExpression games;
	
	public PlatformDetachedCriteria() {
		super(aa.Platform.class, aa.PlatformCriteria.class);
		name = new StringExpression("name", this.getDetachedCriteria());
		year = new IntegerExpression("year", this.getDetachedCriteria());
		description = new StringExpression("description", this.getDetachedCriteria());
		manufacturer = new StringExpression("manufacturer", this.getDetachedCriteria());
		games = new CollectionExpression("ORM_Games", this.getDetachedCriteria());
	}
	
	public PlatformDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, aa.PlatformCriteria.class);
		name = new StringExpression("name", this.getDetachedCriteria());
		year = new IntegerExpression("year", this.getDetachedCriteria());
		description = new StringExpression("description", this.getDetachedCriteria());
		manufacturer = new StringExpression("manufacturer", this.getDetachedCriteria());
		games = new CollectionExpression("ORM_Games", this.getDetachedCriteria());
	}
	
	public GameDetachedCriteria createGamesCriteria() {
		return new GameDetachedCriteria(createCriteria("ORM_Games"));
	}
	
	public Platform uniquePlatform(PersistentSession session) {
		return (Platform) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Platform[] listPlatform(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Platform[]) list.toArray(new Platform[list.size()]);
	}
}

