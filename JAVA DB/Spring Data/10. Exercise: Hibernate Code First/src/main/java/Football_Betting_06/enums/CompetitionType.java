package Football_Betting_06.enums;

public enum CompetitionType {
    LOCAL("Local"),
    NATIONAL("National"),
    INTERNATIONAL("International");

    private final String value;

    CompetitionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
