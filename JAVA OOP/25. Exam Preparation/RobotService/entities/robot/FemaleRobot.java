package robotService.entities.robot;

public class FemaleRobot extends BaseRobot{
    private static final int INITIAL_KILOGRAMS_FOR_FEMALE_ROBOT = 7;
    public FemaleRobot(String name, String kind, double price) {
        super(name, kind, INITIAL_KILOGRAMS_FOR_FEMALE_ROBOT, price);
    }


    @Override
    public void eating() {
        super.setKilograms(super.getKilograms() + 1);

    }
}
