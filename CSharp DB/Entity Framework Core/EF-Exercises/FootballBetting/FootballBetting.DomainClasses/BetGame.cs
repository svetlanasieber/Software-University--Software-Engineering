namespace FootballBetting.DomainClasses
{
    public class BetGame
    {
        public int BetId { get; set; }
        public Bet Bet { get; set; }

        public int GameId { get; set; }
        public Game Game { get; set; }

        public int ResultPredictionId { get; set; }
        public ResultPrediction ResultPrediction { get; set; }

}
}
//•	BetGame – Game, Bet, Result Prediction(PK = Game + Bet)