package catHouse.entities.cat;

public class LonghairCat extends BaseCat{
    private static final int LONG_HAIR_CAT_INITIAL_KILOGRAMS = 9;
    public LonghairCat(String name, String breed, double price) {
        super(name, breed, price);
    }

    @Override
    public void eating() {
        super.setKilograms(LONG_HAIR_CAT_INITIAL_KILOGRAMS + 3);

    }

}
