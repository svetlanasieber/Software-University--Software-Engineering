package catHouse.core;

import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;

import static catHouse.common.ConstantMessages.*;
import static catHouse.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private ToyRepository toys;
    private Collection<House> houses;
    private double houseValue;

    public ControllerImpl() {
        this.toys = new ToyRepository();
        this.houses = new ArrayList<>();
        this.houseValue = 0;
    }

    @Override
    public String addHouse(String type, String name) {
        House house;
        switch (type) {
            case "ShortHouse":
                house = new ShortHouse(name);
                break;
            case "LongHouse":
                house = new LongHouse(name);
                break;
            default:
                throw new NullPointerException(INVALID_HOUSE_TYPE);
        }
        this.houses.add(house);
        return String.format(SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
    }


    @Override
    public String buyToy(String type) {
        Toy toy;
        switch (type) {
            case "Ball":
                toy = new Ball();
                break;
            case "Mouse":
                toy = new Mouse();
                break;
            default:
                throw new IllegalArgumentException(INVALID_TOY_TYPE);

        }
        this.toys.buyToy(toy);

        return String.format(SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        Toy toy = this.toys.findFirst(toyType);
        if (toy == null) {
            throw new IllegalArgumentException(String.format(NO_TOY_FOUND, toyType));
        }

        this.houses.forEach(house -> {
            if (house.getName().equals(houseName)) {
                house.buyToy(toy);
            }
        });

        this.toys.removeToy(toy);

        return String.format(SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        Cat cat;

        switch (catType) {
            case "ShorthairCat":
                cat = new ShorthairCat(catName, catBreed, price);
                break;
            case "LonghairCat":
                cat = new LonghairCat(catName, catBreed, price);
                break;
            default:
                throw new IllegalArgumentException(INVALID_CAT_TYPE);
        }
        String output;

        House house = findHouse(houseName);
        boolean validHouseLongHare = house.getClass().getSimpleName().equals("ShortHouse") && cat.getClass().getSimpleName().equals("ShorthairCat");
        boolean validHouseShortHair = house.getClass().getSimpleName().equals("LongHouse") && cat.getClass().getSimpleName().equals("LonghairCat");


        if (validHouseLongHare) {
            house.addCat(cat);
            output = String.format("Successfully added %s to %s.", catType, houseName);

        } else if (validHouseShortHair) {
            house.addCat(cat);
            output = String.format("Successfully added %s to %s.", catType, houseName);

        } else {


            output = UNSUITABLE_HOUSE;

        }

        return output;
    }

    @Override
    public String feedingCat(String houseName) {

        House house = findHouse(houseName);
        house.feeding();
        Collection<Cat> cats = house.getCats();
        int size = cats.size();

        return String.format(FEEDING_CAT, size);
    }

    @Override
    public String sumOfAll(String houseName) {
        House house = findHouse(houseName);
        double sumCats = house.getCats().stream().mapToDouble(Cat::getPrice).sum();
        double sumToys = house.getToys().stream().mapToDouble(Toy::getPrice).sum();
        this.houseValue = sumCats + sumToys;


        return String.format(VALUE_HOUSE, houseName, houseValue);
    }

    private House findHouse(String houseName) {
        return this.houses.stream().filter(house1 -> house1.getName().equals(houseName)).findFirst().orElse(null);
    }

    @Override
    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        this.houses.forEach(house -> {
            builder.append(house.getStatistics());
            builder.append(System.lineSeparator());
        });
        return builder.toString().trim();
    }
}
