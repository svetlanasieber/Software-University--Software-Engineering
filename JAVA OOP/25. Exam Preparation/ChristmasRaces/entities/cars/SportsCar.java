package christmasRaces.entities.cars;

import static christmasRaces.common.ExceptionMessages.INVALID_HORSE_POWER;

public class SportsCar extends BaseCar {
    private static final double CUBIC_CENTIMETERS_SPORT_CAR = 3000.0;
    private static final int MIN_HORSEPOWER_SPORT_CAR = 250;
    private static final int MAX_HORSEPOWER_SPORT_CAR = 450;

    public SportsCar(String model, int horsePower) {
        super(model, horsePower, CUBIC_CENTIMETERS_SPORT_CAR);
    }

    private static boolean isValidRange(int horsePower) {
        return horsePower >= MIN_HORSEPOWER_SPORT_CAR && horsePower <= MAX_HORSEPOWER_SPORT_CAR;
    }

    @Override
    protected void setHorsePower(int horsePower) {
        if (isValidRange(horsePower)) {
            super.setHorsePower(horsePower);
        } else {
            throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER, horsePower));

        }


    }

}
