package handball.entities.equipment;

public class ElbowPad extends BaseEquipment{
    private static final int ELBOW_PAD_PROTECTION_VALUE =  90;
    private static final double ELBOW_PAD_PRICE=  25;
    public ElbowPad() {
        super(ELBOW_PAD_PROTECTION_VALUE, ELBOW_PAD_PRICE);
    }
}
