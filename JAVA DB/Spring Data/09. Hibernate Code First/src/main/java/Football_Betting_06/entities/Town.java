package Football_Betting_06.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "towns")
public class Town {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Country country;

    @OneToMany(mappedBy = "town", targetEntity = Team.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Team> teams = new ArrayList<>();

    public Town() {}
    public Town(String name, Country country) {
        this.name = name;
        this.country = country;
    }
}
