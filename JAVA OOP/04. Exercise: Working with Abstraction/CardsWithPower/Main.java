import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        CardRank rank = CardRank.valueOf(scanner.nextLine());
     
        CardSuit suit = CardSuit.valueOf(scanner.nextLine());

        int cardPower = rank.getPower() + suit.getPower();

        Card card = new Card(cardPower);

        System.out.printf("Card name: %s of %s; Card power: %d", rank, suit, card.getPower());
    }
}
