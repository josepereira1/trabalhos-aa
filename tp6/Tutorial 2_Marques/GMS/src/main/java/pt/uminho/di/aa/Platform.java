package pt.uminho.di.aa;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Platform implements Serializable {

    @Id
    private String name;
    private int year;
    private String description;
    private String manufacturer;
    @OneToMany
    private Collection<Format> formats;

    public Platform() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Collection<Format> getFormats() {
        return formats;
    }

    public void setFormats(Collection<Format> formats) {
        this.formats = formats;
    }

    @Override
    public String toString() {
        return "Platform{" +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", description='" + description + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}
