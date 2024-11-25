package Football_Betting_06.enums;

public enum PositionType {
    GOALKEEPER("Goalkeeper"),
    DEFENDER("Defender"),
    MIDFIELDER("Midfielder"),
    STRIKER("Striker");

    private final String value;

    PositionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
