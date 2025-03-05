import java.util.ArrayList;
import java.util.List;

public class Main_08 {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        List<String> texts = new ArrayList<>();
        texts.add("Vik");

        Display<String> stringDisplay = new Display<>();
        stringDisplay.display("Apple", "Orange", "Peach");

        Display<Double> doubleDisplay = new Display<>();
        doubleDisplay.display(5.50, 10.20, 35.14);

        Display<Integer> integerDisplay = new Display<>();
        integerDisplay.display(5, 10, 15);

        System.out.println("Ivan".compareTo("Ivan"));
    }
}
