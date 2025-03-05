package shelf;

public class Main {

    public static void main(String[] args) {

   
        printName("Lana", "Peter", "Bili", "Bubu");
        printName("Lana");
    }


    private static void printName(String city, String... names) {
        for (String name : names) {
            System.out.println(name);
        }
    }
}
