import java.util.Scanner;

public class Moon_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double speed = Double.parseDouble(scanner.nextLine());
        double needFuel = Double.parseDouble(scanner.nextLine());

        int distanceToMoon = 384400;
        int totalDistance = 2 * distanceToMoon; 
        double travelTime = totalDistance / speed; 
        int totalTime = (int) Math.ceil(travelTime + 3);
        int fuelNeeded = (int) ((needFuel * totalDistance) / 100); 
       
        System.out.println(totalTime);
        System.out.println(fuelNeeded);

        scanner.close();

    }
}
