package pt.uminho.di.aa;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Format implements Serializable {
    @Id
    private int kind;
    private String description;

    public Format() {
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
                ", description='" + description + '\'' +
                ", kind=" + kind +
                '}';
    }
}
