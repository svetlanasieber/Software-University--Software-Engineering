package ObjectAndClasses;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Car car1 = new Car("Skoda", 190, "Black");
        Car car2 = new Car("VW", 150, "Red");
        Car car3 = new Car("Honda", 200, "Green");

        List<Car> garage = new ArrayList<>();

        garage.add(car1);

        System.out.println(car1.getBrand());

        car1.setColor("Blue");

  

        car1.startEngine();







    }
}
