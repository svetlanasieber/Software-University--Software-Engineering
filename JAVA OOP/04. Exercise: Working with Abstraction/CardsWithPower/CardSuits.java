package CardWithPower;

public enum CardSuits {
    CLUBS(0), //пика
    DIAMONDS(13), //каро
    HEARTS(26), //купа
    SPADES(39);//спатия

    private int value;

    CardSuits (int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
