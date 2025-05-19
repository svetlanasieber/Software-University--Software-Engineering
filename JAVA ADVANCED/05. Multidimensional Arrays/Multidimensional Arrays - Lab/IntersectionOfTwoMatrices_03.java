import java.util.Scanner;

public class IntersectionOfTwoMatrices_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        String[][] matrixA = new String[rows][cols];
        String[][] matrixB = new String[rows][cols];

        fillMatrix(matrixA, scanner);
        fillMatrix(matrixB, scanner);

        for (int row = 0; row <= rows - 1; row++) {
            for (int col = 0; col <= cols - 1; col++) {
                String elementA = matrixA[row][col];
                String elementB = matrixB[row][col];

                if (elementA.equals(elementB)) {
                    System.out.print(elementA + " ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();

        }


    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row <= matrix.length - 1; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }
}

