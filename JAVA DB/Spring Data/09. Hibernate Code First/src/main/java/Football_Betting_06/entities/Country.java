package Football_Betting_06.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "countries")
public class Country {
    @Id
    @Column(length = 3)
    private String id;

    @Column(name = "country_name")
    private String countryName;

    @Column(name = "continent_id")
    @ManyToMany
    @JoinTable(name = "countries_continents",
    joinColumns = @JoinColumn(name = "country_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "continent_id", referencedColumnName = "id"))
    private List<Continent> continent = new ArrayList<>();

    @OneToMany(mappedBy = "country", targetEntity = Town.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Town> towns = new ArrayList<>();

    public Country() {}
    public Country(String countryName, Continent continent) {
        this.countryName = countryName;
        this.continent.add(continent);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public List<Continent> getContinent() {
        return continent;
    }

    public void setContinent(List<Continent> continent) {
        this.continent = continent;
    }

    public List<Town> getTowns() {
        return towns;
    }

    public void setTowns(List<Town> towns) {
        this.towns = towns;
    }
}
