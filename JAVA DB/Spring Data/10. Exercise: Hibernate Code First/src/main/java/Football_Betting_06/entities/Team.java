package Football_Betting_06.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(length = 3, nullable = false)
    private String logo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "primary_kit_color", referencedColumnName = "id")
    private Color primaryKitColor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "secondary_kit_color", referencedColumnName = "id")
    private Color secondaryKitColor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "town_id", referencedColumnName = "id")
    private Town town;

    @Column(nullable = false)
    private double budget;

    @OneToMany(mappedBy = "team", targetEntity = Player.class)
    private List<Player> players = new ArrayList<>();

    @OneToMany(mappedBy ="homeTeam",targetEntity= Game.class)
    private Set<Game> homeGames = new HashSet<>();

    @OneToMany(mappedBy ="awayTeam",targetEntity= Game.class)
    private Set<Game> awayGames = new HashSet<>();

    public Team() {}
    public Team(String name, String logo, Color primaryKitColor, Color secondaryKitColor, Town town, double budget) {
        this.name = name;
        this.logo = logo;
        this.primaryKitColor = primaryKitColor;
        this.secondaryKitColor = secondaryKitColor;
        this.town = town;
        this.budget = budget;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Color getPrimaryKitColor() {
        return primaryKitColor;
    }

    public void setPrimaryKitColor(Color primaryKitColor) {
        this.primaryKitColor = primaryKitColor;
    }

    public Color getSecondaryKitColor() {
        return secondaryKitColor;
    }

    public void setSecondaryKitColor(Color secondaryKitColor) {
        this.secondaryKitColor = secondaryKitColor;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Set<Game> getHomeGames() {
        return homeGames;
    }

    public void setHomeGames(Set<Game> homeGames) {
        this.homeGames = homeGames;
    }

    public Set<Game> getAwayGames() {
        return awayGames;
    }

    public void setAwayGames(Set<Game> awayGames) {
        this.awayGames = awayGames;
    }
}
