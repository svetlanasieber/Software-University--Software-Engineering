package P06_SumAndProduct;

import java.util.Scanner;

public class P06_SumAndProduct {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        boolean found = false;

        outer:
        for (int a = 1; a <= 9; a++) {
            for (int b = 9; b >= a; b--) {
                for (int c = 0; c <= 9; c++) {
                    for (int d = 9; d >= c; d--) {
                        int sum = a + b + c + d;
                        int product = a * b * c * d;

                        if (sum == product && n % 10 == 5) {
                            int abcd = a * 1000 + b * 100 + c * 10 + d;
                            System.out.println(abcd);
                            found = true;
                            break outer;
                        }

                        if (sum != 0 && product / sum == 3 && n % 3 == 0) {
                            int dcba = d * 1000 + c * 100 + b * 10 + a;
                            System.out.println(dcba);
                            found = true;
                            break outer;
                        }
                    }
                }
            }
        }

        if (!found) {
            System.out.println("Nothing found");
        }
    }
}

