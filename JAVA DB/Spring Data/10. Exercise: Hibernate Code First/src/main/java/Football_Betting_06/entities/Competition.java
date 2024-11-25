package Football_Betting_06.entities;

import Football_Betting_06.enums.CompetitionType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "competitions")
public class Competition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private CompetitionType competitionType;

    @OneToMany(mappedBy ="competition",targetEntity= Game.class)
    private Set<Game> games = new HashSet<>();

    public Competition() {}
    public Competition(String name, CompetitionType competitionType) {
        this.name = name;
        this.competitionType = competitionType;
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

    public CompetitionType getCompetitionType() {
        return competitionType;
    }

    public void setCompetitionType(CompetitionType competitionType) {
        this.competitionType = competitionType;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }
}
