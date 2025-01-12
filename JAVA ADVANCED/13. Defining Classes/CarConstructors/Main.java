package _06_DefiningClasses._01_Lab._02_CarConstructors;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Car currentCar;

        for (int i = 0; i < n; i++) {
            String[] inputArr = scanner.nextLine().split(" ");

            if (inputArr.length == 3) {
                currentCar = new Car(inputArr[0], inputArr[1], Integer.parseInt(inputArr[2]));
            } else {
                currentCar = new Car(inputArr[0]);
            }

            System.out.println(currentCar);
        }
    }
}
