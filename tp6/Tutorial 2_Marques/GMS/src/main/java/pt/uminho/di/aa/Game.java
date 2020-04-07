package pt.uminho.di.aa;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Game implements Serializable {
    @Id
    private String name;
    private int year;
    private double price;
    private String description;
    @OneToOne
    private Platform platform;

    public Game() {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    @Override
    public String toString() {
        return "Game{" +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", platform=" + platform +
                '}';
    }
}
