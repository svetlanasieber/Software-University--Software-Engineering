package christmasPastryShop.entities.booths;

import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import java.util.ArrayList;
import java.util.Collection;

import static christmasPastryShop.common.ExceptionMessages.INVALID_NUMBER_OF_PEOPLE;
import static christmasPastryShop.common.ExceptionMessages.INVALID_TABLE_CAPACITY;

public abstract class BaseBooth implements Booth {
    private Collection<Delicacy> delicacyOrders;
    private Collection<Cocktail> cocktailOrders;
    private int boothNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;


    protected BaseBooth(int boothNumber, int capacity, double pricePerPerson) {


        this.boothNumber = boothNumber;
        setCapacity(capacity);
        this.pricePerPerson = pricePerPerson;
        this.isReserved = false;
        this.delicacyOrders = new ArrayList<>();
        this.cocktailOrders = new ArrayList<>();
        this.price = 0;

    }

    private void setCapacity(int capacity) {
        if (isInvalidNumber(capacity)) {
            throw new IllegalArgumentException(INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    private void setNumberOfPeople(int numberOfPeople) {
        if (isInvalidNumber(numberOfPeople)) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    private boolean isInvalidNumber(int number) {
        return number <= 0;
    }


    @Override
    public int getBoothNumber() {
        return this.boothNumber;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public boolean isReserved() {
        return this.isReserved;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void reserve(int numberOfPeople) {
        this.setNumberOfPeople(numberOfPeople);
        isReserved = true;
        this.price = this.pricePerPerson * numberOfPeople;
    }

    @Override
    public double getBill() {
        double cocktailPrice = this.cocktailOrders.stream().mapToDouble(Cocktail::getPrice).sum();
        double delicacies = this.delicacyOrders.stream().mapToDouble(Delicacy::getPrice).sum();
        return (cocktailPrice + delicacies) +this.price;
    }

    @Override
    public void clear() {
        this.delicacyOrders.clear();
        this.cocktailOrders.clear();
        this.isReserved = false;
        this.numberOfPeople = 0;
        this.price = 0;

    }
}
