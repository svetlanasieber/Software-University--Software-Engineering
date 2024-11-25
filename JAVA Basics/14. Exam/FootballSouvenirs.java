package FirstStepsInCoding.Lab.Exam;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class FootballSouvenirs {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String team = scanner.nextLine();
        String souvenirs = scanner.nextLine();

        int boughtSouvenirs = Integer.parseInt(scanner.next());
        double price = 0;
        boolean isValid = false;

        switch (team){
            case("Argentina"):
                switch (souvenirs){
                    case("flags"):
                        price = 3.25 * boughtSouvenirs;
                        break;
                    case("caps"):
                        price = 7.20 * boughtSouvenirs;
                        break;
                    case("posters"):
                        price = 5.10 *boughtSouvenirs;
                        break;
                    case("stickers"):
                        price = 1.25 *boughtSouvenirs;
                        break;
                    default:
                        System.out.println("Invalid stock!");
                        isValid = true;
                }
                break;

            case("Brazil"):
                switch (souvenirs){
                    case("flags"):
                        price = 4.20 * boughtSouvenirs;
                        break;
                    case("caps"):
                        price = 8.50 * boughtSouvenirs;
                        break;
                    case("posters"):
                        price = 5.35 *boughtSouvenirs;
                        break;
                    case("stickers"):
                        price = 1.20 *boughtSouvenirs;
                        break;
                    default:
                        System.out.println("Invalid stock!");
                        isValid = true;
                }
                break;

            case("Croatia"):
                switch (souvenirs){
                    case("flags"):
                        price = 2.75 * boughtSouvenirs;
                        break;
                    case("caps"):
                        price = 6.90 * boughtSouvenirs;
                        break;
                    case("posters"):
                        price = 4.95 *boughtSouvenirs;
                        break;
                    case("stickers"):
                        price = 1.10 *boughtSouvenirs;
                        break;
                    default:
                        System.out.println("Invalid stock!");
                        isValid = true;
                }
                break;

            case ("Denmark"):
                switch (souvenirs){
                    case("flags"):
                        price = 3.10 * boughtSouvenirs;
                        break;
                    case("caps"):
                        price = 6.50 * boughtSouvenirs;
                        break;
                    case("posters"):
                        price = 4.80 *boughtSouvenirs;
                        break;
                    case("stickers"):
                        price = 0.90 *boughtSouvenirs;
                        break;
                    default:
                        System.out.println("Invalid stock!");
                        isValid = true;
                }
                break;
                default:
                System.out.println("Invalid country!");
                    isValid = true;

        }
        if (!isValid) {

            System.out.printf("Pepi bought %d %s of %s for %.2f lv.", boughtSouvenirs, souvenirs, team, price);
        }
    }
}
