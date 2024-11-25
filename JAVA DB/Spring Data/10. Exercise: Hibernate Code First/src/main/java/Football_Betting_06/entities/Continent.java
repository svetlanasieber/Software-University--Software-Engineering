package Football_Betting_06.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "continents")
public class Continent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "continent_name")
    private String continentName;

    @ManyToMany(mappedBy = "continent", targetEntity = Country.class)
    private List<Country> countries = new ArrayList<>();

    public Continent() {}
    public Continent(String continentName) {
        this.continentName = continentName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContinentName() {
        return continentName;
    }

    public void setContinentName(String continentName) {
        this.continentName = continentName;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }
}
