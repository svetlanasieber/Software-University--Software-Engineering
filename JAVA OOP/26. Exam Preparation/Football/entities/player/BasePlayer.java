package football.entities.player;

import static football.common.ExceptionMessages.*;

public abstract class BasePlayer implements Player {

    private String name;
    private String nationality;

    private double kg;
    private int strength;

    protected BasePlayer(String name, String nationality, double kg, int strength) {
        setName(name);
        setNationality(nationality);
        this.kg = kg;
        setStrength(strength);
    }

    @Override
    public void setName(String name) {
        if (isNullOrWhitespace(name)) {
            throw new NullPointerException(PLAYER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    private void setNationality(String nationality) {
        if (isNullOrWhitespace(nationality)) {
            throw new NullPointerException(PLAYER_NATIONALITY_NULL_OR_EMPTY);

        }
        this.nationality = nationality;
    }

    protected void setStrength(int strength) {
        if (strength <= 0) {
            throw new IllegalArgumentException(PLAYER_STRENGTH_BELOW_OR_EQUAL_ZERO);
        }
        this.strength = strength;
    }

    private static boolean isNullOrWhitespace(String str) {
        return str == null || str.trim().isEmpty();
    }


    @Override
    public double getKg() {
        return this.kg;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getStrength() {
        return this.strength;
    }

    @Override
    public abstract void stimulation();
}
