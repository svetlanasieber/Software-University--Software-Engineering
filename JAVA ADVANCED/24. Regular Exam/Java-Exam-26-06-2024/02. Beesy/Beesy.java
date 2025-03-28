import java.util.Scanner;

public class Beesy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[n][n];
        int beeRow = -1, beeCol = -1;

       
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            field[i] = line.toCharArray();
            for (int j = 0; j < n; j++) {
                if (field[i][j] == 'B') {
                    beeRow = i;
                    beeCol = j;
                }
            }
        }
        
        int energy = 15;
        int collectedNectar = 0;
        boolean restored = false;  
        boolean gameEnded = false;
        boolean reachedHive = false;
        
    
        while (!gameEnded && scanner.hasNextLine()) {
            String command = scanner.nextLine().trim();
            if (command.isEmpty()) {
                continue; 
            }
            
           
            field[beeRow][beeCol] = '-';
            
            
            energy--;
            
           
            int newRow = beeRow;
            int newCol = beeCol;
            switch (command) {
                case "up":
                    newRow = beeRow - 1;
                    break;
                case "down":
                    newRow = beeRow + 1;
                    break;
                case "left":
                    newCol = beeCol - 1;
                    break;
                case "right":
                    newCol = beeCol + 1;
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
            
            
            beeRow = newRow;
            beeCol = newCol;
            
            
            char cell = field[beeRow][beeCol];
            if (Character.isDigit(cell)) {
                int nectar = cell - '0';
                collectedNectar += nectar;
                field[beeRow][beeCol] = '-';
            } else if (cell == 'H') {
                reachedHive = true;
                gameEnded = true;
                break;
            }
            
            
            if (energy <= 0) {

                if (!restored && collectedNectar >= 30) {
                    int restoreAmount = collectedNectar - 30;
                    energy += restoreAmount;
                    collectedNectar = 30;
                    restored = true;

                    if (energy <= 0) {
                        gameEnded = true;
                        break;
                    }
                } else {
                    gameEnded = true;
                    break;
                }
            }
        }
        
       
        if (reachedHive) {
            if (collectedNectar >= 30) {
                System.out.println("Great job, Beesy! The hive is full. Energy left: " + energy);
            } else {
                System.out.println("Beesy did not manage to collect enough nectar.");
            }
        } else {
            System.out.println("This is the end! Beesy ran out of energy.");
        }
        
        
        field[beeRow][beeCol] = 'B';
       
        for (int i = 0; i < n; i++) {
            System.out.println(new String(field[i]));
        }
        
        scanner.close();
    }
}
