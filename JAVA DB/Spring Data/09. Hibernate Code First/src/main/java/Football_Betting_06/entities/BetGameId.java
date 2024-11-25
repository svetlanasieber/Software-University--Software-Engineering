package Football_Betting_06.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BetGameId implements Serializable {
    @Column(name = "game_id")
    private int gameId;

    @Column(name = "bet_id")
    private int betId;

    public BetGameId() {}
    public BetGameId(int gameId, int betId) {
        this.gameId = gameId;
        this.betId = betId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getBetId() {
        return betId;
    }

    public void setBetId(int betId) {
        this.betId = betId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BetGameId betGameId = (BetGameId) o;
        return gameId == betGameId.gameId && betId == betGameId.betId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, betId);
    }
}
