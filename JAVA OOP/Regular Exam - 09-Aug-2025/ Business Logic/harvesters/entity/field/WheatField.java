package harvesters.entity.field;

public class WheatField extends Field {
    private static final int CROP_REDUCTION = 1;

    public WheatField(String name, int crop) {
        super(name, crop);
    }

    @Override
    public void reduceCrop() {
        setCrop(getCrop() - CROP_REDUCTION);
    }
}