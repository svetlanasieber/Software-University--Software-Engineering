package shelf;

public class Main {

    public static void main(String[] args) {

   
        printName("Vik", "Ivan", "Tosho", "Gosho");
        printName("Vik");

        

    }


    private static void printName(String city, String... names) {
        for (String name : names) {
            System.out.println(name);
        }
    }
}
