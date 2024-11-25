package bg.softuni.entities;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class IdEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public IdEntity() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
