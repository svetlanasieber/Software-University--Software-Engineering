package Football_Betting_06.entities;

import Football_Betting_06.enums.PositionType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "positions")
public class Position {
    @Id
    @Column(length = 2)
    private String id;

    @Enumerated(EnumType.STRING)
    private PositionType positionType;

    @OneToMany(mappedBy = "position", targetEntity = Player.class)
    private List<Player> players = new ArrayList<>();

    public Position() {}
    public Position(PositionType positionType) {
        this.positionType = positionType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
