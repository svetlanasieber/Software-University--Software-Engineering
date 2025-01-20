package vehicleShop.models.worker;

public class SecondShift extends BaseWorker {
    private static  final int INITIAL_STRENGTH_SECOND_SHIFT  = 70;
    public SecondShift(String name){
        super(name,INITIAL_STRENGTH_SECOND_SHIFT);
    }

    @Override
    public void working() {
       super.setStrength(Math.max(getStrength() - 5, 0));
    }
}
