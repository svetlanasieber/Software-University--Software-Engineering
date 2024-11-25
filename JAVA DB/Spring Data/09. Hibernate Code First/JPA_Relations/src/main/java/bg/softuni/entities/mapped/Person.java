package bg.softuni.entities.mapped;

import bg.softuni.entities.IdEntity;
import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "people")
public class Person extends IdEntity {
    @Basic
    private String name;

    public Person() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
