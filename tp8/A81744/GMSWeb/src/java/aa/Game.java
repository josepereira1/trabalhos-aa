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

public class Game {
	public Game() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Game))
			return false;
		Game game = (Game)aObj;
		if ((getName() != null && !getName().equals(game.getName())) || (getName() == null && game.getName() != null))
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (getName() == null ? 0 : getName().hashCode());
		return hashcode;
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_GAME_USERS) {
			return ORM_users;
		}
		else if (key == ORMConstants.KEY_GAME_PLATFORMS) {
			return ORM_platforms;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private String name;
	
	private int year;
	
	private double price;
	
	private String description;
	
	private java.util.Set ORM_users = new java.util.HashSet();
	
	private java.util.Set ORM_platforms = new java.util.HashSet();
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return name;
	}
	
	public String getORMID() {
		return getName();
	}
	
	public void setYear(int value) {
		this.year = value;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setPrice(double value) {
		this.price = value;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getDescription() {
		return description;
	}
	
	private void setORM_Users(java.util.Set value) {
		this.ORM_users = value;
	}
	
	private java.util.Set getORM_Users() {
		return ORM_users;
	}
	
	public final aa.UserSetCollection users = new aa.UserSetCollection(this, _ormAdapter, ORMConstants.KEY_GAME_USERS, ORMConstants.KEY_USER_GAMES, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_Platforms(java.util.Set value) {
		this.ORM_platforms = value;
	}
	
	private java.util.Set getORM_Platforms() {
		return ORM_platforms;
	}
	
	public final aa.PlatformSetCollection platforms = new aa.PlatformSetCollection(this, _ormAdapter, ORMConstants.KEY_GAME_PLATFORMS, ORMConstants.KEY_PLATFORM_GAMES, ORMConstants.KEY_MUL_MANY_TO_MANY);

	@Override
	public String toString() {
		return "Game{" +
				//"_ormAdapter=" + _ormAdapter +
				"name='" + name + '\'' +
				", year=" + year +
				", price=" + price +
				", description='" + description + '\'' +
				//", ORM_users=" + ORM_users +
				//", ORM_platforms=" + ORM_platforms +
				//", users=" + users +
				//", platforms=" + platforms +
				'}';
	}
}
