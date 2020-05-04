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
	
	private String name;
	
	private int year;
	
	private String description;
	
	private String manufacturer;
	
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
	
	public String toString() {
		return String.valueOf(getName());
	}
	
}
