package Lab08_Data_Types_And_Variables;

import java.util.Scanner;

public class DemoIntegerDataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Integer Data Types
        //1. byte
        byte number = Byte.parseByte(scanner.nextLine());
        //2. short
        short price = Short.parseShort(scanner.nextLine());
        //3. int
        int count = Integer.parseInt(scanner.nextLine());
        //4. long
        long population = Long.parseLong(scanner.nextLine());

        //Max / Min Values
        System.out.println(Byte.MIN_VALUE);
        System.out.println(Short.MIN_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Long.MAX_VALUE);

        //Overflow
        byte maxValue = Byte.MAX_VALUE;
        System.out.println(maxValue++);

    }
}
