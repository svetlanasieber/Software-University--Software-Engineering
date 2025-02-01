import java.util.Scanner;

public class ArrayRotation_04 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split(" ");
        int rotations = Integer.parseInt(scanner.nextLine());

        for (int rotation = 1; rotation <= rotations; rotation++) {

            String firstElement = array[0];


            for (int position = 0; position < array.length - 1; position++) {
                array[position] = array[position + 1];
            }

            array[array.length - 1] = firstElement;
        }

        for (String element : array) {
            System.out.print(element + " ");
        }
    }
}
