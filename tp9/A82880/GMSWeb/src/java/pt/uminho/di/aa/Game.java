/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: josepereira(Universidade do Minho)
 * License Type: Academic
 */
package pt.uminho.di.aa;

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
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_GAME_PLATFORM) {
			this.platform = (pt.uminho.di.aa.Platform) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private String name;
	
	private pt.uminho.di.aa.Platform platform;
	
	private int year;
	
	private float price;
	
	private String description;
	
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
	
	public void setPrice(float value) {
		this.price = value;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setPlatform(pt.uminho.di.aa.Platform value) {
		this.platform = value;
	}
	
	public pt.uminho.di.aa.Platform getPlatform() {
		return platform;
	}
	
	public String toString() {
		return String.valueOf(getName());
	}
	
}
