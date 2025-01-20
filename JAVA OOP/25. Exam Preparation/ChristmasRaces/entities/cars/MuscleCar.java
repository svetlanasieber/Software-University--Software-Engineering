package christmasRaces.entities.cars;

import static christmasRaces.common.ExceptionMessages.INVALID_HORSE_POWER;

public class MuscleCar extends BaseCar {
    private static final double CUBIC_CENTIMETERS_MUSCLE_CAR = 5000.0;
    private static final int MIN_HORSEPOWER_MUSCLE_CAR = 400;
    private static final int MAX_HORSEPOWER_MUSCLE_CAR = 600;


    public MuscleCar(String model, int horsePower) {
        super(model, horsePower, CUBIC_CENTIMETERS_MUSCLE_CAR);


    }

    private static boolean isValidRange(int horsePower) {
        return horsePower >= MIN_HORSEPOWER_MUSCLE_CAR && horsePower <= MAX_HORSEPOWER_MUSCLE_CAR;
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
