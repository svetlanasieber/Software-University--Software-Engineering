import java.util.Scanner;

public class CatLife_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String catName = scanner.nextLine();


        String gender = scanner.nextLine();

        int catMonths = 0;

        switch (catName) {
            case "British Shorthair":
                catMonths = (gender.equals("m")) ? (int) Math.round((13 * 12.0) / 6) : (int) Math.round((14 * 12.0) / 6);
                break;
            case "Siamese":
                catMonths = (gender.equals("m")) ? (int) Math.round((15 * 12.0) / 6) : (int) Math.round((16 * 12.0) / 6);
                break;
            case "Persian":
                catMonths = (gender.equals("m")) ? (int) Math.round((14 * 12.0) / 6) : (int) Math.round((15 * 12.0) / 6);
                break;
            case "Ragdoll":
                catMonths = (gender.equals("m")) ? (int) Math.round((16 * 12.0) / 6) : (int) Math.round((17 * 12.0) / 6);
                break;
            case "American Shorthair":
                catMonths = (gender.equals("m")) ? (int) Math.round((12 * 12.0) / 6) : (int) Math.round((13 * 12.0) / 6);
                break;
            case "Siberian":
                catMonths = (gender.equals("m")) ? (int) Math.round((11 * 12.0) / 6) : (int) Math.round((12 * 12.0) / 6);
                break;
            default:
                System.out.println(catName + " is invalid cat!");
                scanner.close();
                return;
        }

        System.out.println(catMonths + " cat months");

        scanner.close();
    }
}
