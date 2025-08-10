package harvesters.entity.field;

public class CornField extends BaseField {

    public CornField(String name, int crop) {
        super(name, crop);
    }

    @Override
    public void reduceCrop() {
        this.setCrop(this.getCrop() - 3);
    }
}