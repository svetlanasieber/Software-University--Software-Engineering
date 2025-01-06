package Lab11_Arrays;

import java.util.Scanner;

public class String_join {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String names = "Desi Ivan Georgi Tanya";
        String[] namesArray = names.split(" "); //["Desi", "Ivan", "Georgi", "Tanya"]
        System.out.println(String.join("-", namesArray)); //"Desi-Ivan-Georgi-Tanya// "
    }
}
