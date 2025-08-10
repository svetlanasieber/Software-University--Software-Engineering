package agriculture;

public class Seed {

    private String name;
    private String soil;
    private int germination;
    private boolean economicalValue;

    public Seed(String name, String soil, int germination, boolean economicalValue) {
        this.name = name;
        this.soil = soil;
        this.germination = germination;
        this.economicalValue = economicalValue;
    }


    public String getName() {
        return name;
    }

    public String getSoil() {
        return soil;
    }


    public boolean hasEconomicalValue() {
        return economicalValue;
    }

    public int getGermination() {
        return germination;
    }

}

