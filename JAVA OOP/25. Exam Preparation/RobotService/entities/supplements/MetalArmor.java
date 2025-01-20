package robotService.entities.supplements;

public class MetalArmor extends  BaseSupplement{

    private static final int HARDNESS_METAL_ARMOR = 5;
    private static final double PRICE_METAL_ARMOR = 15;
    public MetalArmor() {
        super(HARDNESS_METAL_ARMOR, PRICE_METAL_ARMOR);
    }
}
