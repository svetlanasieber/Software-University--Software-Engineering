package bg.softuni.entities.composition;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "batches")
public class Batch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic
    private String serial;

    @OneToMany(mappedBy = "batch", targetEntity = Shampoo.class, cascade = CascadeType.ALL)
    private Set<Shampoo> shampoo;

    public Batch() {
        this.shampoo = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Set<Shampoo> getShampoo() {
        return shampoo;
    }

    public void addShampoo(Shampoo shampoo) {
        this.shampoo.add(shampoo);
    }
}
