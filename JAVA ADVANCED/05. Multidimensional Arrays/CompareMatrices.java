import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstMatrixDimensions = scanner.nextLine(); 

        int rowsFirstMatrix = Integer.parseInt(firstMatrixDimensions.split(" ")[0]);
        int colsFirstMatrix = Integer.parseInt(firstMatrixDimensions.split(" ")[1]);
      
        int [][] firstMatrix = new int[rowsFirstMatrix][colsFirstMatrix];
        fillMatrix(firstMatrix, scanner);

      
        String secondMatrixDimensions = scanner.nextLine();
      
        int rowsSecondMatrix = Integer.parseInt(secondMatrixDimensions.split(" ")[0]);
        int colsSecondMatrix = Integer.parseInt(secondMatrixDimensions.split(" ")[1]);
     
        int[][] secondMatrix = new int[rowsSecondMatrix][colsSecondMatrix];
        fillMatrix(secondMatrix, scanner);

      
        if (isEqual(firstMatrix, secondMatrix)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }

    }

    private static boolean isEqual (int[][] firstMatrix, int [][] secondMatrix) {
    
      if (firstMatrix.length != secondMatrix.length) {

            return false;
        }

        if (firstMatrix[0].length != secondMatrix[0].length) {
       
            return false;
        }


        for (int row = 0; row <= firstMatrix.length - 1; row++) {
            for (int col = 0; col <= secondMatrix[0].length - 1; col++) {
                if (firstMatrix[row][col] != secondMatrix[row][col]) {
                 
                    return false;
                }
            }
        }
        return true;
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row <= matrix.length - 1; row++) {
                matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                                .mapToInt(Integer::parseInt).toArray();
        }
    }

}

