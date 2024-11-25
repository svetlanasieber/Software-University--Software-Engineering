package Football_Betting_06.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "bets")
public class Bet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "bet_money")
    private double betMoney;

    @Column(name = "date_and_time")
    private LocalDateTime dateAndTime;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "bet", targetEntity = BetGame.class, cascade = CascadeType.ALL)
    private Set<BetGame> games  = new HashSet<>();

    public Bet(double betMoney, LocalDateTime dateAndTime, User user) {
        this.betMoney = betMoney;
        this.dateAndTime = dateAndTime;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBetMoney() {
        return betMoney;
    }

    public void setBetMoney(double betMoney) {
        this.betMoney = betMoney;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<BetGame> getGames() {
        return games;
    }

    public void setGames(Set<BetGame> games) {
        this.games = games;
    }
}
