//Java Advanced Retake Exam - 15 December 2021
//https://alpha.judge.softuni.org/contests/java-advanced-retake-exam-15-december-2021/3251/practice#2

import java.util.Scanner;
 
public class ThroneConquering_v1 {
 
    static char[][] area;
    static int playerRow;
    static int playerCol;
    static int energy;
 
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
 
            energy = Integer.parseInt(scanner.nextLine());
            int N = Integer.parseInt(scanner.nextLine());
            area = new char[N][];
 
            for (int row = 0; row < N; row++) {
                area[row] = scanner.nextLine().toCharArray();
 
                for (int col = 0; col < area[row].length; col++) {
 
                    if (area[row][col] == 'P') {
                        playerRow = row;
                        playerCol = col;
                    }
                }
            }
 
            boolean bFirst = false;
 
            while (!bFirst) {
                String[] data = scanner.nextLine().split("\\s+");
 
                String dir = data[0];
                int throwRow = Integer.parseInt(data[1]);
                int throwCol = Integer.parseInt(data[2]);
 
                area[throwRow][throwCol] = 'S';
                area[playerRow][playerCol] = '-';
 
                int[] newPos = moved(dir, playerRow, playerCol);
 
                playerRow = newPos[0];
                playerCol = newPos[1];
                energy--;
 
                if (bLimit(playerRow, playerCol)) {
                    char cell = area[playerRow][playerCol];
 
                    if (cell == 'S') {
                        energy -= 2;
                    }
 
                    if (energy <= 0) {
 
                        if (cell == 'H') {
                            area[playerRow][playerCol] = '-';
 
                            System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", energy);
                        }
                        else {
                            area[playerRow][playerCol] = 'X';
 
                            System.out.printf("Paris died at %d;%d.%n", playerRow, playerCol);
                        }
                        bFirst = true;
                    }
                    else {
 
                        if (cell == 'H') {
                            area[playerRow][playerCol] = '-';
 
                            System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", energy);
                            bFirst = true;
                        }
                        else {
                            area[playerRow][playerCol] = 'P';
                        }
                    }
                }
                else {
                    playerRow = newPos[2];
                    playerCol = newPos[3];
 
                    if (energy <= 0) {
                        area[playerRow][playerCol] = 'X';
 
                        System.out.printf("Paris died at %d;%d.%n", playerRow, playerCol);
                        bFirst = true;
                    }
                    else {
                        area[playerRow][playerCol] = 'P';
                    }
                }
            }
 
            for (char[] row : area) {
                System.out.println(String.valueOf(row));
            }
        }
 
    private static int[] moved(String dir, int row, int col) {
 
        int newRow = row;
        int newCol = col;
 
        if (dir.equals("up"))         newRow--;
        else if (dir.equals("down"))  newRow++;
        else if (dir.equals("left"))  newCol--;
        else if (dir.equals("right")) newCol++;
 
        if (bLimit(newRow, newCol)) {
            return new int[]{newRow, newCol, row, col};
        }
        else {
            return new int[]{row, col, row, col};
        }
    }
 
    private static boolean bLimit(int row, int col) {
        return row >= 0 && row < area.length && col >= 0 && col < area[0].length;
 
    }
}
