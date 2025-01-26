package Arrays_Exercise;

import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstArray = scanner.nextLine().split(" ");
        String[] secondArray = scanner.nextLine().split(" ");

        for (int position = 0; position < secondArray.length; position++) {
            String currentText = secondArray[position];

            for (int index = 0; index < firstArray.length; index++) {
                if (currentText.equals(firstArray[index])) {
                    System.out.print(currentText + " ");
                }
            }

        }



    }
}
