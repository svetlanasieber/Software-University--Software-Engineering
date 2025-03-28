package JavaAdvRegular_20oct_2024;

import java.util.Scanner;
import java.util.Arrays;

class BombHasBeenPlanted {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] dimensions = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];


        char[][] map = new char[rows][cols];
        int ctRow = 0, ctCol = 0;
        int initialRow = 0, initialCol = 0;

        for (int i = 0; i < rows; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < cols; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'C') {
                    ctRow = i;
                    ctCol = j;
                    initialRow = i;
                    initialCol = j;
                }
            }
        }

        int timeRemaining = 16;
        String command;

        while (scanner.hasNextLine()) {
            command = scanner.nextLine();

            if (timeRemaining <= 0) {
                System.out.println("Terrorists win!");
                System.out.println("Bomb was not defused successfully!");
                System.out.println("Time needed: 0 second/s.");
                printMap(map, initialRow, initialCol);
                return;
            }

            if (command.equals("defuse")) {
                if (map[ctRow][ctCol] == 'B') {
                    if (timeRemaining >= 4) {
                        map[ctRow][ctCol] = 'D';
                        timeRemaining -= 4;
                        System.out.println("Counter-terrorist wins!");
                        System.out.println("Bomb has been defused: " + timeRemaining + " second/s remaining.");
                    } else {
                        map[ctRow][ctCol] = 'X';
                        System.out.println("Terrorists win!");
                        System.out.println("Bomb was not defused successfully!");
                        System.out.println("Time needed: " + (4 - timeRemaining) + " second/s.");
                    }
                    printMap(map, initialRow, initialCol);
                    return;
                } else {
                    timeRemaining -= 2;
                }
            } else {
                int nextRow = ctRow, nextCol = ctCol;

                switch (command) {
                    case "up":
                        nextRow--;
                        break;
                    case "down":
                        nextRow++;
                        break;
                    case "left":
                        nextCol--;
                        break;
                    case "right":
                        nextCol++;
                        break;
                }

                if (isInsideMap(nextRow, nextCol, rows, cols)) {
                    if (map[nextRow][nextCol] == 'T') {
                        map[nextRow][nextCol] = '*';
                        System.out.println("Terrorists win!");
                        printMap(map, initialRow, initialCol);
                        return;
                    }
                    ctRow = nextRow;
                    ctCol = nextCol;
                }
                timeRemaining--;
            }
        }
    }

    static boolean isInsideMap(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    static void printMap(char[][] map, int initialRow, int initialCol) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (i == initialRow && j == initialCol && map[i][j] != 'D' && map[i][j] != 'X') {
                    System.out.print('C');
                } else {
                    System.out.print(map[i][j]);
                }
            }
            System.out.println();
        }
    }
}
