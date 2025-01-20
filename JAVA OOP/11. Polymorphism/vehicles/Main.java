package vehicles;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(tokens[1]),
                Double.parseDouble(tokens[2]));

        tokens = scanner.nextLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(tokens[1]),
                Double.parseDouble(tokens[2]));

        Map<String, Vehicle> vehicleMap = new LinkedHashMap<>();
        vehicleMap.put("Car", car);
        vehicleMap.put("Truck", truck);


        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            tokens = scanner.nextLine().split("\\s+");
            Vehicle vehicle = vehicleMap.get(tokens[1]);
            switch (tokens[0]) {
                case "Drive":
                    System.out.println(vehicle.drive(Double.parseDouble(tokens[2])));
                    break;
                case "Refuel":
                    vehicle.refuel(Double.parseDouble(tokens[2]));
                    break;
            }
        }
        vehicleMap.values().forEach(v -> System.out.println(v));
    }
}
