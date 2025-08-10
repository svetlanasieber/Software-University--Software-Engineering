package agriculture;

import java.util.*;
import java.util.stream.Collectors;

public class Land {

    private static final String NOT_COMPATIBLE_SEED = "This seed is not compatible with this land soil!";
    private static final String INVALID_LAND_NAME = "Invalid land name!";
    private static final String SEED_EXIST = "This seed exists in the land!";

    private String name;
    private String soilType;
    private Collection<Seed> seeds;

    public Land(String name, String soilType) {
        this.setName(name);
        this.soilType = soilType;
        this.seeds = new ArrayList<>();
    }

    public void addSeed(Seed seed) {
        if (!seed.getSoil().equals(this.soilType)) {
            throw new IllegalArgumentException(NOT_COMPATIBLE_SEED);
        }
        boolean seedExist = this.seeds
                .stream()
                .anyMatch(c -> c.getName().equals(seed.getName()));

        if (seedExist) {
            throw new IllegalArgumentException(SEED_EXIST);
        }
        this.seeds.add(seed);
    }

    public boolean removeSeed(String name) {
        Seed seed = this.seeds
                .stream()
                .filter(m -> m.getName()
                        .equals(name))
                .findFirst()
                .orElse(null);

        return this.seeds.remove(seed);
    }

    public String getMostGerminatingSeed() {
        Seed mostGerminating = seeds.stream().max(Comparator.comparing(Seed::getGermination)).orElse(null);
        assert mostGerminating != null;
        return mostGerminating.getName();
    }

    public String getValuableSeeds() {
        List<Seed> valuableSeeds = seeds.stream().filter(Seed::hasEconomicalValue).toList();
        List<String> resultNames = valuableSeeds.stream().map(Seed::getName).toList();

        return String.join(", ", resultNames);
    }



    public List<Seed> getSeedBySoilType(String soilType) {
        return seeds.stream().filter(m -> m.getSoil().equals(Land.this.soilType)).collect(Collectors.toList());
    }

    public int getCount() {
        return seeds.size();
    }

    public Seed getSeed(String name) {
        return seeds.stream().filter(m -> m.getName().equals(name)).findFirst().orElse(null);
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(INVALID_LAND_NAME);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getSoilType() {
        return soilType;
    }

}
