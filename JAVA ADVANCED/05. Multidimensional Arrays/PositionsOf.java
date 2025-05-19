import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PositionOf {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner);

        int number = Integer.parseInt(scanner.nextLine());

        printPositions(matrix, number);
    }

    private static void printPositions(int[][] matrix, int number) {
        ArrayList<int[]> positions = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int current = matrix[row][col];
                if (current == number) {
                    positions.add(new int[]{row, col});
                }
            }
        }

        if (positions.isEmpty()) {
            System.out.println("not found");
        } else {
            for (int[] indexes : positions) {
                System.out.println(indexes[0] + " " + indexes[1]);
            }
        }
    }

    public static int[][] readMatrix(Scanner scanner) {
        int[] rowsAndCols = readArray(scanner.nextLine());
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = readArray(scanner.nextLine());
        }
        return matrix;
    }

    public static int[] readArray(String line) {
        return Arrays.stream(line.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}

