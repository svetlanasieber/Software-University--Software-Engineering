package Exercise09_Data_Types_And_Variables;

import java.util.Scanner;

public class P01_IntegerOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());
        int fourthNumber = Integer.parseInt(scanner.nextLine());

        // ((n1 + n2) / n3) x n4
        int result = ((firstNumber + secondNumber) / thirdNumber * fourthNumber);
        System.out.println(result);

    }
}

/*

package DataTypesAndVariables_Vik_Exercise;

import java.util.Scanner;

public class V01_IntegerOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());
        int fourthNumber = Integer.parseInt(scanner.nextLine());

        //((firstNumber + secondNumber) / thirdNumber) * fourthNumber)
        System.out.println(((firstNumber + secondNumber) / thirdNumber) * fourthNumber);
    }
}



*/
