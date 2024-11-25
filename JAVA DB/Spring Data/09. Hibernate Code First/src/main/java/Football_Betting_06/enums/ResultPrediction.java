package Football_Betting_06.enums;

public enum ResultPrediction {
    HOME_WIN("Home team Win"),
    AWAY_WIN("Away team Win"),
    DRAW("Draw game");

    private final String value;

    ResultPrediction(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
