package multidimensional_arrays_Lab;

import java.util.Scanner;

public class DemoMatrix {
    public static void main(String[] args) {


        int [][] intMatrix = new int[4][3]; 
        double [][] doubleMatrix = new double[5][5]; 
        String [][] stringMatrix = new String[4][4]; 

        intMatrix[0][0] = 5;
        intMatrix[0][1] = 10;
        intMatrix[0][2] = 15;
  
        int number = intMatrix[0][1];
        System.out.println(intMatrix[0][0]);
   
        int rows = intMatrix.length;
        System.out.println(intMatrix.length);// 4
      
        int cols = intMatrix[0].length;
        System.out.println(intMatrix[0].length); // 3

        int[][] numbers = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };


        for (int row = 0; row <= numbers.length - 1; row++) {
          
            for (int col = 0; col <= numbers[0].length - 1; col++) {
                int element = numbers[row][col];
                System.out.println(element);
            }
        }

       
        for (int col = 0; col <= numbers[0].length - 1; col++) {
            for (int row = 0; row <= numbers.length - 1; row++) {
                int element = numbers[row][col];
                System.out.println(element);
            }
        }





    }
}

