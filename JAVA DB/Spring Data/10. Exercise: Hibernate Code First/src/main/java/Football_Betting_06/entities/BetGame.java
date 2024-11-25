package Football_Betting_06.entities;

import Football_Betting_06.enums.ResultPrediction;
import javax.persistence.*;
import java.util.Objects;

@Entity(name = "bet_games")
public class BetGame {
    // PK - Game + Bet

    @EmbeddedId
    private BetGameId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("game_id")
    private Game game;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("bet_id")
    private Bet bet;

    @Enumerated(EnumType.STRING)
    private ResultPrediction resultPrediction;

    public BetGame() {}
    public BetGame(Game game, Bet bet, ResultPrediction resultPrediction) {
        this.id = new BetGameId(game.getId(), bet.getId());
        this.game = game;
        this.bet = bet;
        this.resultPrediction = resultPrediction;
    }

    public BetGameId getId() {
        return id;
    }

    public void setId(BetGameId id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }

    public ResultPrediction getResultPrediction() {
        return resultPrediction;
    }

    public void setResultPrediction(ResultPrediction resultPrediction) {
        this.resultPrediction = resultPrediction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BetGame betGame = (BetGame) o;
        return Objects.equals(id, betGame.id) && Objects.equals(game, betGame.game) && Objects.equals(bet, betGame.bet) && resultPrediction == betGame.resultPrediction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, game, bet, resultPrediction);
    }
}
