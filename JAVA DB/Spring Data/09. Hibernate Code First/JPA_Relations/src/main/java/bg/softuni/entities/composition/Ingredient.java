package bg.softuni.entities.composition;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ingredients")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic
    private String name;

    @ManyToMany(mappedBy = "ingredients", targetEntity = Shampoo.class)
    private List<Shampoo> shampoos;

    public Ingredient() {
        this.shampoos = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Shampoo> getShampoos() {
        return shampoos;
    }

    public void setShampoos(List<Shampoo> shampoos) {
        this.shampoos = shampoos;
    }
}
