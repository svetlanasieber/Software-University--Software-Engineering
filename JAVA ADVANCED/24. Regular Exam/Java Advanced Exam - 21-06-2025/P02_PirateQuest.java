import java.util.Scanner;

public class P02_PirateQuest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] map = new char[n][n];

        int shipRow = -1, shipCol = -1;
        int totalTreasures = 0;


        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < line.length(); j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'S') {
                    shipRow = i;
                    shipCol = j;
                } else if (map[i][j] == '*') {
                    totalTreasures++;
                }
            }
        }

        int durability = 100;

        int treasuresCollected = 0;

        boolean charmUsed = false;

        boolean gameOver = false;

        String endMessage = "";


        while (!gameOver) {
            String command = scanner.nextLine();

            if (command.equals("stop")) {
                if (treasuresCollected == totalTreasures) {
                    endMessage = "Yo-ho-ho! All treasure chests collected!";
                } else {
                    endMessage = "Retreat! Some treasures remain unclaimed.";
                }
                gameOver = true;
                break;
            }


            if (map[shipRow][shipCol] == 'S') {
                map[shipRow][shipCol] = '.';
            }


            int newRow = shipRow;
            int newCol = shipCol;

            switch (command) {
                case "up":
                    newRow = shipRow - 1;
                    break;
                case "down":
                    newRow = shipRow + 1;
                    break;
                case "left":
                    newCol = shipCol - 1;
                    break;
                case "right":
                    newCol = shipCol + 1;
                    break;
            }


            if (newRow < 0) {
                newRow = n - 1;
            } else if (newRow >= n) {
                newRow = 0;
            }

            if (newCol < 0) {
                newCol = n - 1;
            } else if (newCol >= n) {
                newCol = 0;
            }

            shipRow = newRow;
            shipCol = newCol;


            char currentCell = map[shipRow][shipCol];

            switch (currentCell) {
                case '*':
                    treasuresCollected++;
                    map[shipRow][shipCol] = '.';
                    if (treasuresCollected == totalTreasures) {
                        endMessage = "Yo-ho-ho! All treasure chests collected!";
                        gameOver = true;
                    }
                    break;

                case 'C':
                    if (!charmUsed) {
                        durability = Math.min(100, durability + 25);
                        charmUsed = true;
                    }
                    map[shipRow][shipCol] = '.';
                    break;

                case 'M':
                    durability -= 25;
                    map[shipRow][shipCol] = '.';
                    if (durability <= 0) {
                        endMessage = "Shipwreck! Last known coordinates (" + shipRow + ", " + shipCol + ")";
                        gameOver = true;
                    }
                    break;

                case '.':
                    break;
            }
        }


        map[shipRow][shipCol] = 'S';


        System.out.println(endMessage);
        System.out.println("Ship Durability: " + Math.max(0, durability));

        if (treasuresCollected < totalTreasures) {
            System.out.println("Unclaimed chests: " + (totalTreasures - treasuresCollected));
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

        scanner.close();
    }
}
