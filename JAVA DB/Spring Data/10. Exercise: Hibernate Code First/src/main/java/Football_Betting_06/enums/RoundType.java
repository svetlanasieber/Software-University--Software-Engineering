package Football_Betting_06.enums;

public enum RoundType {
    GROUP_STAGE("Group Stage"),
    FINAL_1_8("1/8 Final"),
    FINAL_1_4("1/4 Final"),
    SEMI_FINAL("Semi-Final"),
    FINAL("Final");

    private final String value;

    RoundType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
