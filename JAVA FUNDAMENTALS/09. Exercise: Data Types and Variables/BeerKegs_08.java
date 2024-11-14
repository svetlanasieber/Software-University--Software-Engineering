import java.util.Scanner;

public class BeerKegs_08 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int kegsCount = Integer.parseInt(scanner.nextLine());


        String maxModel = "";
        double maxVolume = 0;

        for (int keg = 1; keg <= kegsCount; keg++) {

            String model = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());

            // π * r^2 * h
            double volume = Math.PI * radius * radius * height;
            //double volume2 = Math.PI * Math.pow(radius, 2) * height;

          
            if (volume > maxVolume) {
                maxModel = model;
                maxVolume = volume;
            }
        }

        System.out.println(maxModel);
    }
}
