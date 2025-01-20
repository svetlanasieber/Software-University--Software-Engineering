package christmasPastryShop.entities.booths;

public class OpenBooth extends BaseBooth{

    private static final double PRICE_PER_PERSON_OPEN_BOOT =2.50;
    public OpenBooth(int boothNumber, int capacity) {
        super(boothNumber, capacity, PRICE_PER_PERSON_OPEN_BOOT);
    }
}
