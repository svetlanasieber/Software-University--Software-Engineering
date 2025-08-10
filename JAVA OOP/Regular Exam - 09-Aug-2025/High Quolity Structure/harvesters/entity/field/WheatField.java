package harvesters.entity.field;

public class WheatField extends BaseField {

    public WheatField(String name, int crop) {
        super(name, crop);
    }

    @Override
    public void reduceCrop() {
        this.setCrop(this.getCrop() - 1);
    }
}