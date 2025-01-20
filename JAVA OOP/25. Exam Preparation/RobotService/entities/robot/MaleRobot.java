package robotService.entities.robot;

public class MaleRobot extends BaseRobot{
    private static final int INITIAL_KILOGRAMS_FOR_MALE_ROBOT = 9;
    public MaleRobot(String name, String kind, double price) {
        super(name, kind, INITIAL_KILOGRAMS_FOR_MALE_ROBOT, price);
    }

    @Override
    public void eating() {
        super.setKilograms(super.getKilograms() +3 );

    }
}
