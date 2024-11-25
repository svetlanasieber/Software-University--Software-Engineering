package Bills_Payment_System_05.enums;

public enum BillingDetailType {
    CREDIT_CARD("CREDIT CARD"),
    BANK_ACCOUNT("BANK ACCOUNT");

    private final String value;

    BillingDetailType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
