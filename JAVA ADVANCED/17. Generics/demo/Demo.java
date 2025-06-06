package demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        String e1 = list.get(0);
        String e2 =  list.get(1);
        String e3 = list.get(2);
         List<Integer> numbers = new ArrayList<>();
        List<SkodaCar> skodaCars = new ArrayList<>();
        printList(skodaCars);
        printList(numbers);

        SkodaCar car = new SkodaCar();
        car.getBrand();
    }

    public static void printList (List<?> list) {
        for (Object element : list) {
            System.out.println(element);
        }
    }
}
