package Football_Betting_06.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PlayerStatisticsId implements Serializable {
    @Column(name = "game_id")
    private int gameId;

    @Column(name = "player_id")
    private int playerId;

    public PlayerStatisticsId() {}
    public PlayerStatisticsId(int gameId, int playerId) {
        this.gameId = gameId;
        this.playerId = playerId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }
}
