package harvesters.entity.field;

public class RiceField extends Field {
    private static final int CROP_REDUCTION = 2;

    public RiceField(String name, int crop) {
        super(name, crop);
    }

    @Override
    public void reduceCrop() {
        setCrop(getCrop() - CROP_REDUCTION);
    }
}