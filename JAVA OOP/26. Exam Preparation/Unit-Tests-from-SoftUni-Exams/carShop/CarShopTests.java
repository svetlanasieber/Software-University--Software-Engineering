package carShop;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CarShopTests {
    private static final String CAR_MODEL = "Opel";
    private static final int HORSE_POWER = 150;
    private static final double PRICE = 15000.0;


    private CarShop carShop;
    private Car car;


    @Before
    public void setUp() {
        carShop = new CarShop();
        car = new Car(CAR_MODEL, HORSE_POWER, PRICE);
        //  Car car1 = new Car("Ferrari", 350, 1200000);

        carShop.add(car);
        //  carShop.add(car1);

    }

    @Test
    public void testGetCarShopCount() {

        assertEquals(1, carShop.getCount());

    }

    @Test(expected = NullPointerException.class)
    public void testAddNullCarShouldThrow() {
        Car carNull = null;
        carShop.add(carNull);

    }

    @Test
    public void getCarsShouldReturnCorrectList() { //Not
        List<Car> expected = new ArrayList<>();

        expected.add(car);

        List<Car> actualCars = carShop.getCars();

        assertEquals(expected, actualCars);
    }

    @Test
    public void testFindCarWhitMaxHorsePower() {
        Car car1 = new Car("Car 1", 1, 1.1);
        Car car2 = new Car("Car 2", 2, 2.1);
        Car car3 = new Car("Car 3", 150, 3.1);

        carShop.add(car1);
        carShop.add(car2);
        carShop.add(car3);

        List<Car> expected = new ArrayList<>(Arrays.asList(car, car3));

        List<Car> actualCar = carShop.findAllCarsWithMaxHorsePower(2);
        assertEquals(expected, actualCar);

    }

    @Test
    public void testRemoveCar() {
        assertTrue(carShop.remove(car));

    }

    @Test
    public void testGetMOstLuxuryCar() {
        Car car1 = new Car("Car 1", 1, 1.1);
        Car car2 = new Car("Car 2", 2, 2.1);
        Car car3 = new Car("Car 3", 150, 3.1);

        carShop.add(car1);
        carShop.add(car2);
        carShop.add(car3);

        Car actual = carShop.getTheMostLuxuryCar();
        assertEquals(car, actual);


    }

    @Test
    public void testFindCarByModel() {
        Car car1 = new Car("Opel", 1, 1.1);
        Car car2 = new Car("Car 2", 2, 2.1);
        Car car3 = new Car("Car 3", 150, 3.1);

        carShop.add(car1);
        carShop.add(car2);
        carShop.add(car3);

        List<Car> expected = new ArrayList<>(Arrays.asList(car, car1));


        List<Car> actual = carShop.findAllCarByModel("Opel");
        assertEquals(expected, actual);


    }


}

