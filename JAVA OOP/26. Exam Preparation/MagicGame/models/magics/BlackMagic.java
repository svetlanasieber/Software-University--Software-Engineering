package magicGame.models.magics;

public class BlackMagic extends MagicImpl {
    private static final int FIRE_RATE_BLACK_MAGIC = 10;
    public BlackMagic(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        if (super.getBulletsCount() - FIRE_RATE_BLACK_MAGIC < 0){
            super.setBulletsCount(0);
            return 0;
        }else {
            setBulletsCount(getBulletsCount() -FIRE_RATE_BLACK_MAGIC);
            return FIRE_RATE_BLACK_MAGIC;
        }
    }
}
