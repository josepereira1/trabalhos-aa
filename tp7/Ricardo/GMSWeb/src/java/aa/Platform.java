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

public class Platform {
	public Platform() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Platform))
			return false;
		Platform platform = (Platform)aObj;
		if ((getName() != null && !getName().equals(platform.getName())) || (getName() == null && platform.getName() != null))
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (getName() == null ? 0 : getName().hashCode());
		return hashcode;
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_PLATFORM_GAMES) {
			return ORM_games;
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
	
	private String description;
	
	private String manufacturer;
	
	private java.util.Set ORM_games = new java.util.HashSet();
	
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
	
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setManufacturer(String value) {
		this.manufacturer = value;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	
	private void setORM_Games(java.util.Set value) {
		this.ORM_games = value;
	}
	
	private java.util.Set getORM_Games() {
		return ORM_games;
	}
	
	public final aa.GameSetCollection games = new aa.GameSetCollection(this, _ormAdapter, ORMConstants.KEY_PLATFORM_GAMES, ORMConstants.KEY_GAME_PLATFORMS, ORMConstants.KEY_MUL_MANY_TO_MANY);

	@Override
	public String toString() {
		return "Platform{" +
				//"_ormAdapter=" + _ormAdapter +
				"name='" + name + '\'' +
				", year=" + year +
				", description='" + description + '\'' +
				", manufacturer='" + manufacturer + '\'' +
				//", ORM_games=" + ORM_games +
				//", games=" + games +
				'}';
	}
}
