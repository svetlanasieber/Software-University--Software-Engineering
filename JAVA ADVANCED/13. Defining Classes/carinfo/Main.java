package carinfo;

import carinfo.Car;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countCars = Integer.parseInt(scanner.nextLine());

        for (int count = 1; count <= countCars; count++) {
            String data = scanner.nextLine(); 
            
            String brand = data.split(" ")[0]; 
            String model = data.split(" ")[1]; 
            int hp = Integer.parseInt(data.split(" ")[2]); 
           
            Car car = new Car(); 
            car.setBrand(brand);
            car.setModel(model);
            car.setHp(hp);

            car.printCarInfo();

        }

    }
}
