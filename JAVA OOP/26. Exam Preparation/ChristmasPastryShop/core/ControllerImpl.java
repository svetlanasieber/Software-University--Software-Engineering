package christmasPastryShop.core;

import christmasPastryShop.core.interfaces.Controller;
import christmasPastryShop.entities.booths.OpenBooth;
import christmasPastryShop.entities.booths.PrivateBooth;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.cocktails.Hibernation;
import christmasPastryShop.entities.cocktails.MulledWine;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.delicacies.Gingerbread;
import christmasPastryShop.entities.delicacies.Stolen;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.repositories.interfaces.BoothRepository;
import christmasPastryShop.repositories.interfaces.CocktailRepository;
import christmasPastryShop.repositories.interfaces.DelicacyRepository;

import static christmasPastryShop.common.ExceptionMessages.BOOTH_EXIST;
import static christmasPastryShop.common.ExceptionMessages.FOOD_OR_DRINK_EXIST;
import static christmasPastryShop.common.OutputMessages.*;

public class ControllerImpl implements Controller {

    private DelicacyRepository<Delicacy> delicacyRepository;
    private CocktailRepository<Cocktail> cocktailRepository;
    private BoothRepository<Booth> boothRepository;
    private double totalPrice;


    public ControllerImpl(DelicacyRepository<Delicacy> delicacyRepository, CocktailRepository<Cocktail> cocktailRepository, BoothRepository<Booth> boothRepository) {
        this.delicacyRepository = delicacyRepository;
        this.cocktailRepository = cocktailRepository;
        this.boothRepository = boothRepository;
        this.totalPrice = 0;

    }

    @Override
    public String addDelicacy(String type, String name, double price) {
        Delicacy delicacy = this.delicacyRepository.getByName(name);
        if (delicacy != null) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }
        switch (type) {
            case "Gingerbread":
                delicacy = new Gingerbread(name, price);
                break;
            case "Stolen":
                delicacy = new Stolen(name, price);
                break;
        }

        this.delicacyRepository.add(delicacy);


        return String.format(DELICACY_ADDED, name, type);
    }

    @Override
    public String addCocktail(String type, String name, int size, String brand) {
        Cocktail cocktail = this.cocktailRepository.getByName(name);
        if (cocktail != null) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }
        switch (type) {
            case "Hibernation":
                cocktail = new Hibernation(name, size, brand);
                break;
            case "MulledWine":
                cocktail = new MulledWine(name, size, brand);
                break;
        }
        this.cocktailRepository.add(cocktail);
        return String.format(COCKTAIL_ADDED, name, brand);
    }


    @Override
    public String addBooth(String type, int boothNumber, int capacity) {
        Booth booth = this.boothRepository.getByNumber(boothNumber);
        if (booth != null) {
            throw new IllegalArgumentException(String.format(BOOTH_EXIST, boothNumber));

        }
        switch (type) {
            case "OpenBooth":
                booth = new OpenBooth(boothNumber, capacity);
                break;
            case "PrivateBooth":
                booth = new PrivateBooth(boothNumber, capacity);
                break;
        }

        this.boothRepository.add(booth);

        return String.format(BOOTH_ADDED, boothNumber);
    }

    @Override
    public String reserveBooth(int numberOfPeople) {
        for (Booth booth : this.boothRepository.getAll()) {
            if (!booth.isReserved() && booth.getCapacity() >= numberOfPeople) {
                booth.reserve(numberOfPeople);
                return String.format(BOOTH_RESERVED, booth.getBoothNumber(), numberOfPeople);

            }
        }
        return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
    }


    @Override
    public String leaveBooth(int boothNumber) {
        Booth booth = boothRepository.getByNumber(boothNumber);
        double bill = booth.getBill();
        this.totalPrice += bill;

        booth.clear();
        return String.format(BILL, boothNumber, bill);
    }

    @Override
    public String getIncome() {
        return String.format(TOTAL_INCOME, this.totalPrice);
    }

}
