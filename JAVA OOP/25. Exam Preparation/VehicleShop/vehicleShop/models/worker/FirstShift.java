package vehicleShop.models.worker;

public class FirstShift extends BaseWorker{

    private static  final int INITIAL_STRENGTH_FIRST_SHIFT  = 100;



    public FirstShift(String name) {
        super(name, INITIAL_STRENGTH_FIRST_SHIFT);
    }
}
