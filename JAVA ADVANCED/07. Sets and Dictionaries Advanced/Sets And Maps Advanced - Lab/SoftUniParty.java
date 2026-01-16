package sets_and_maps_advanced;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);

        Set<String> vipReservations = new TreeSet<>();
        Set<String> regularReservations = new TreeSet<>();

        String reservationNumber = scanner.nextLine();
         while (!reservationNumber.equals("PARTY")) {
             char firstSymbol = reservationNumber.charAt(0);

             if (Character.isDigit(firstSymbol)) {
                 vipReservations.add(reservationNumber);
             } else {
                 regularReservations.add(reservationNumber);
             }
             reservationNumber = scanner.nextLine();
         }
         //Party

        String goneReservations = scanner.nextLine();
         while (!goneReservations.equals("END")) {
             vipReservations.remove(goneReservations);
             regularReservations.remove(goneReservations);

             goneReservations = scanner.nextLine();
         }

         //END

        System.out.println(vipReservations.size() + regularReservations.size());

         vipReservations.forEach(System.out::println);
         regularReservations.forEach(System.out::println);

        }


    }


