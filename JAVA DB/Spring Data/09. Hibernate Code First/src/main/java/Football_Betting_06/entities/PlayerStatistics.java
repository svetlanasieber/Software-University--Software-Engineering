package Football_Betting_06.entities;

import javax.persistence.*;

@Entity(name = "player_statistics")
public class PlayerStatistics {
    // PK - Game + Player

    @EmbeddedId
    private PlayerStatisticsId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("game_id")
    private Game game;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("player_id")
    private Player player;

    @Column(name = "scored_goals")
    private int scoredGoals;

    @Column(nullable = false)
    private int assists;

    @Column(name = "minutes_played")
    private int minutesPlayed;

    public PlayerStatistics() {}
    public PlayerStatistics(Game game, Player player, int scoredGoals, int assists, int minutesPlayed) {
        this.game = game;
        this.player = player;
        this.scoredGoals = scoredGoals;
        this.assists = assists;
        this.minutesPlayed = minutesPlayed;
    }

    public PlayerStatisticsId getId() {
        return id;
    }

    public void setId(PlayerStatisticsId id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getScoredGoals() {
        return scoredGoals;
    }

    public void setScoredGoals(int scoredGoals) {
        this.scoredGoals = scoredGoals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getMinutesPlayed() {
        return minutesPlayed;
    }

    public void setMinutesPlayed(int minutesPlayed) {
        this.minutesPlayed = minutesPlayed;
    }
}
