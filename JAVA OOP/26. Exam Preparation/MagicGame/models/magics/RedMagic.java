package magicGame.models.magics;

public class RedMagic extends MagicImpl {
    private static final int FIRE_RATE_RED_MAGIC = 1;

    public RedMagic(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        if (super.getBulletsCount() - FIRE_RATE_RED_MAGIC < 0) {
            super.setBulletsCount(0);
            return 0;
        } else {

            super.setBulletsCount(getBulletsCount() - FIRE_RATE_RED_MAGIC);
            setBulletsCount(FIRE_RATE_RED_MAGIC);
            return FIRE_RATE_RED_MAGIC;
        }


    }
}
