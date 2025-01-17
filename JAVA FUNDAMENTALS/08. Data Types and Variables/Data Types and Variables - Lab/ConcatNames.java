package Lab08_Data_Types_And_Variables;

import java.util.Scanner;

public class ConcatNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstName = scanner.nextLine();
        String lastName = scanner.nextLine();
        String delimiter = scanner.nextLine();


        String output = firstName + delimiter + lastName;
        System.out.println(output);
        //System.out.println(firstName + delimiter + lastName);
    }
}

