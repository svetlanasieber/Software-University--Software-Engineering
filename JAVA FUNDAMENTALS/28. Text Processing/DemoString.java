package TextProcessing_Lab;

import java.util.ArrayList;
import java.util.List;

public class DemoString {
    public static void main(String[] args) {

        //Immutable - String, double, int
        String word = "table";
        word = word.replace("ta", "er");
        int number = 5;
        number = number + 6;

        //Mutable - map, list, array
        List<Integer> list = new ArrayList<>();
        list.add(4);
    }
}
