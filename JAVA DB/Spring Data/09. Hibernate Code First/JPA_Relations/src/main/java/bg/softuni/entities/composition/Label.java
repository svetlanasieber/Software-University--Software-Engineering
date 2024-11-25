package bg.softuni.entities.composition;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jdk.jfr.Unsigned;

@Entity
@Table(name = "labels")
public class Label {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic
    private String title;

    @Basic
    private String subtitle;

    @OneToOne(mappedBy = "label", targetEntity = Shampoo.class)
    private Shampoo shampoo;

    public Label() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Shampoo getShampoo() {
        return shampoo;
    }

    public void setShampoo(Shampoo shampoo) {
        this.shampoo = shampoo;
    }
}
