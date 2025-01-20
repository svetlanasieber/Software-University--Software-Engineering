package handball.entities.equipment;

public class Kneepad extends BaseEquipment {
    private static final int KNEEPAD_PROTECTION_VALUE =  120;
    private static final double KNEEPAD_PRICE=  15;

    public Kneepad() {
        super(KNEEPAD_PROTECTION_VALUE, KNEEPAD_PRICE);
    }
}
