package pt.uminho.di.aa;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Format implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String description;
    private int kind;

    public Format() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    @Override
    public String toString() {
        return "Format{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", kind=" + kind +
                '}';
    }
}
