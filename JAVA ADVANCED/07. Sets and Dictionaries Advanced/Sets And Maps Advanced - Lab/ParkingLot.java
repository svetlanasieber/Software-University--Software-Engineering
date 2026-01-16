package sets_and_maps_advanced;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> parking = new LinkedHashSet<String>();


        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String direction = input.split(",")[0];
            String carNumber = input.split(", ")[1];

            if (direction.equals("IN")) {
                parking.add(carNumber);

            } else if (direction.equals("OUT")) {
                parking.remove(carNumber);
            }
            input = scanner.nextLine();
        }

        if (parking.isEmpty()) {
          
            System.out.println("Parking Lot is Empty");
        } else {
           

           
            for (String carNumber : parking) {
                System.out.println(carNumber);
            }

            // 2
            //parking.forEach(System.out::println);
        }
    }
}
