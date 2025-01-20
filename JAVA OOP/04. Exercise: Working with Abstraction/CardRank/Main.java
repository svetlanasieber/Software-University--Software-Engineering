import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        CardRank[] cardRanks = CardRank.values();


        System.out.println("Card Ranks:");
        for (CardRank cardRank : cardRanks) {
            int ordinal = cardRank.ordinal();
            System.out.printf("Ordinal value: %d; Name value: %s\n", ordinal, cardRank);
        }
    }
}
