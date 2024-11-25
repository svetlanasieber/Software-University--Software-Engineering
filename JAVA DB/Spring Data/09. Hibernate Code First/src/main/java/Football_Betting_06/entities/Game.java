package Football_Betting_06.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity(name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne()
    @JoinColumn(name = "home_team_id", referencedColumnName = "id")
    private Team homeTeam;

    @ManyToOne()
    @JoinColumn(name = "away_team_id", referencedColumnName = "id")
    private Team awayTeam;

    @Column(name = "home_goals")
    private int homeGoals;

    @Column(name = "away_goals")
    private int awayGoals;

    @Column(name = "date_and_time")
    private LocalDateTime dateAndTime;

    @Column(name = "home_team_win_bet_rate")
    private double homeTeamWinBetRate;

    @Column(name = "away_team_win_bet_rate")
    private double awayTeamWinBetRate;

    @Column(name = "draw_game_bet_rate")
    private double drawGameBetRate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "round_id", referencedColumnName = "id")
    private Round round;

    @ManyToOne(optional = false)
    @JoinColumn(name = "competition_id", referencedColumnName = "id")
    private Competition competition;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    private Set<PlayerStatistics> players= new HashSet<>();

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    private Set<BetGame> bets = new HashSet<>();

    public Game() {}
    public Game(Team homeTeam, Team awayTeam, int homeGoals, int awayGoals, LocalDateTime dateAndTime, double homeTeamWinBetRate, double awayTeamWinBetRate, double drawGameBetRate, Round round, Competition competition) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
        this.dateAndTime = dateAndTime;
        this.homeTeamWinBetRate = homeTeamWinBetRate;
        this.awayTeamWinBetRate = awayTeamWinBetRate;
        this.drawGameBetRate = drawGameBetRate;
        this.round = round;
        this.competition = competition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(int homeGoals) {
        this.homeGoals = homeGoals;
    }

    public int getAwayGoals() {
        return awayGoals;
    }

    public void setAwayGoals(int awayGoals) {
        this.awayGoals = awayGoals;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public double getHomeTeamWinBetRate() {
        return homeTeamWinBetRate;
    }

    public void setHomeTeamWinBetRate(double homeTeamWinBetRate) {
        this.homeTeamWinBetRate = homeTeamWinBetRate;
    }

    public double getAwayTeamWinBetRate() {
        return awayTeamWinBetRate;
    }

    public void setAwayTeamWinBetRate(double awayTeamWinBetRate) {
        this.awayTeamWinBetRate = awayTeamWinBetRate;
    }

    public double getDrawGameBetRate() {
        return drawGameBetRate;
    }

    public void setDrawGameBetRate(double drawGameBetRate) {
        this.drawGameBetRate = drawGameBetRate;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public Set<PlayerStatistics> getPlayers() {
        return players;
    }

    public void setPlayers(Set<PlayerStatistics> players) {
        this.players = players;
    }

    public Set<BetGame> getBets() {
        return bets;
    }

    public void setBets(Set<BetGame> bets) {
        this.bets = bets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return id == game.id && homeGoals == game.homeGoals && awayGoals == game.awayGoals && Double.compare(game.homeTeamWinBetRate, homeTeamWinBetRate) == 0 && Double.compare(game.awayTeamWinBetRate, awayTeamWinBetRate) == 0 && Double.compare(game.drawGameBetRate, drawGameBetRate) == 0 && Objects.equals(homeTeam, game.homeTeam) && Objects.equals(awayTeam, game.awayTeam) && Objects.equals(dateAndTime, game.dateAndTime) && Objects.equals(round, game.round) && Objects.equals(competition, game.competition) && Objects.equals(players, game.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, homeTeam, awayTeam, homeGoals, awayGoals, dateAndTime, homeTeamWinBetRate, awayTeamWinBetRate, drawGameBetRate, round, competition, players);
    }
}
