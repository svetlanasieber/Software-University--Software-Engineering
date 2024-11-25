package Football_Betting_06.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(name = "squad_number", nullable = false)
    private int squadNumber;

    @ManyToOne(optional = false)
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    private Team team;

    @ManyToOne(optional = false)
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private Position position;

    @Column(nullable = false)
    private boolean isInjured;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private Set<PlayerStatistics> games= new HashSet<>();

    public Player() {}
    public Player(String name, int squadNumber, Team team, Position position, boolean isInjured) {
        this.name = name;
        this.squadNumber = squadNumber;
        this.team = team;
        this.position = position;
        this.isInjured = isInjured;
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

    public int getSquadNumber() {
        return squadNumber;
    }

    public void setSquadNumber(int squadNumber) {
        this.squadNumber = squadNumber;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public boolean isInjured() {
        return isInjured;
    }

    public void setInjured(boolean injured) {
        isInjured = injured;
    }

    public Set<PlayerStatistics> getGames() {
        return games;
    }

    public void setGames(Set<PlayerStatistics> games) {
        this.games = games;
    }
}
