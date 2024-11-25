package Football_Betting_06.entities;

import Football_Betting_06.enums.RoundType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "rounds")
public class Round {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private RoundType name;

    @OneToMany(mappedBy ="round",targetEntity= Game.class)
    private Set<Game> games = new HashSet<>();

    public Round() {}
    public Round(RoundType name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RoundType getName() {
        return name;
    }

    public void setName(RoundType name) {
        this.name = name;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }
}
