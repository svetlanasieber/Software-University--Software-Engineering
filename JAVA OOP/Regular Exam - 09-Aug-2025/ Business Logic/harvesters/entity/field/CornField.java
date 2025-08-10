package harvesters.entity.field;

public class CornField extends Field {
    private static final int CROP_REDUCTION = 3;

    public CornField(String name, int crop) {
        super(name, crop);
    }

    @Override
    public void reduceCrop() {
        setCrop(getCrop() - CROP_REDUCTION);
    }
}