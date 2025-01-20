package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GarageTests {
    private Garage garage;
    private Car car;


    public GarageTests() {
        this.garage = new Garage();
    }

    @Before
    public void setUp() {
        Garage garage = new Garage();
        car = new Car("Opel", 180, 1500.0);

    }

    @Test
    public void testAddCar() {

        garage.addCar(car);
        int expected = 1;
        int actual = garage.getCount();
        assertEquals(expected, actual);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testTryAddNullParameterCar() {
        car = null;
        garage.addCar(null);


    }

    @Test
    public void testFindCarWhitMaxSpeed() {
        Car car1 = new Car("Trabant", 100, 12.0);
        Car car2 = new Car("VW", 220, 25000.0);

       garage.addCar(car);
       garage.addCar(car1);
       garage.addCar(car2);

        List<Car> expected = new ArrayList<>(Arrays.asList(car, car2));
        List<Car> actual = garage.findAllCarsWithMaxSpeedAbove(120);
        assertEquals(expected,actual);

    }
    @Test
    public void testGetMostExpensiveCar(){
        Car car1 = new Car("Trabant", 100, 12.0);
        Car car2 = new Car("VW", 220, 25000.0);

        garage.addCar(car);
        garage.addCar(car1);
        garage.addCar(car2);


        Car actualMostExpensiveCar = garage.getTheMostExpensiveCar();
        Car expected = car2;
        assertEquals(expected,actualMostExpensiveCar);

    }
    @Test
    public void testFindCarsByBrand(){
        Car car1 = new Car("VW",220,12220.0);
        Car car2 = new Car("VW",240,22220.0);
        garage.addCar(car);
        garage.addCar(car1);
        garage.addCar(car2);

        List<Car> expected = new ArrayList<>(Arrays.asList(car1,car2));
        List<Car> actual = garage.findAllCarsByBrand("VW");

        assertEquals(expected,actual);



    }


}