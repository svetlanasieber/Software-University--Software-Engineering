import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Car> cars = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        Car currentCar;

        while (n-- > 0) {
            String[] inputArr = scanner.nextLine().split(" ");
            String brand = inputArr[0];

            if (inputArr.length == 1) {
                currentCar = new Car(brand);
            } else {
                String model = inputArr[1];
                int horsePower = Integer.parseInt(inputArr[2]);
                currentCar = new Car(brand, model, horsePower);
            }
            cars.add(currentCar);
        }
        cars.forEach(System.out::println);
    }
}
