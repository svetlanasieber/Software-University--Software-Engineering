package wildCard;

import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Object> numbers = List.of(5, 10, 15, 20);
        List<String> names = List.of("Desi", "Gosho", "Ivan", "Vik");

//        print(names);
        print(numbers);
    }


    public static void print(List<?> list) {

        // Object
        for (Object object : list) {
            System.out.println(object);
        }
    }
}

