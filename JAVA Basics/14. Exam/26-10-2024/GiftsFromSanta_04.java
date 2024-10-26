import java.util.Scanner;

public class GiftsFromSanta_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


      
        int N = Integer.parseInt(scanner.nextLine());
        int M = Integer.parseInt(scanner.nextLine());
        int S = Integer.parseInt(scanner.nextLine());

       
        for (int i = M; i >= N; i--) {
            if (i % 2 == 0 && i % 3 == 0) {
                if (i == S) {
                    break;
                }
                System.out.print(i + " ");
            }
        }

        scanner.close();
    }
}

