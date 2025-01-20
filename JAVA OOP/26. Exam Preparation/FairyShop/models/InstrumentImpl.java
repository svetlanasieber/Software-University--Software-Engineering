package fairyShop.models;

import fairyShop.models.Instrument;

import static fairyShop.common.ExceptionMessages.INSTRUMENT_POWER_LESS_THAN_ZERO;

public class InstrumentImpl implements Instrument {
    private static final int DECREASE_INSTRUMENT_POWER = 10;

    private int power;

    public InstrumentImpl(int power) {
        setPower(power);
    }

    private void setPower(int power) {
        if (power < 0) {
            throw new IllegalArgumentException(INSTRUMENT_POWER_LESS_THAN_ZERO);
        }
        this.power = power;
    }

    @Override
    public int getPower() {
        return power;
    }

    @Override
    public void use() {
        setPower(Math.max(this.power - DECREASE_INSTRUMENT_POWER, 0));
    }

    @Override
    public boolean isBroken() {
        return this.power == 0;
    }
}
