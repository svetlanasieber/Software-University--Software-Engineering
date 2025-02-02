namespace FootballBetting.DomainClasses
{
    public class ResultPrediction
    {
        public int Id { get; set; }
        public WinDrawLost Prediction { get; set; }

    }
}
//•	ResultPrediction – Id, Prediction (possible values - Home Team Win, Draw Game, Away Team Win)