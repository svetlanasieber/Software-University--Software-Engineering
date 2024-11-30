import java.util.Scanner;

public class Moon_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double speed = Double.parseDouble(scanner.nextLine());
        double needFuel = Double.parseDouble(scanner.nextLine());

        int distanceToMoon = 384400;
        int totalDistance = 2 * distanceToMoon; // Отиване и връщане
        double travelTime = totalDistance / speed; // Време за пътуване до Луната и обратно
        int totalTime = (int) Math.ceil(travelTime + 3); // Закръгляме времето и добавяме 3 часа престой на Луната
        int fuelNeeded = (int) ((needFuel * totalDistance) / 100); // Общо гориво за изминатото разстояние

        // Отпечатване на резултатите
        System.out.println(totalTime);
        System.out.println(fuelNeeded);

        scanner.close();

    }
}
