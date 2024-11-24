package List;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());// {4, 19, 2, 53, 6, 43}

        List<String> command = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        while (!command.get(0).equals("end")){


            String firstElement = command.get(0);
            int secondElement = Integer.parseInt(command.get(1));

            switch (firstElement){
                case "Add" -> numbers.add(secondElement); 
                case "Remove" -> numbers.remove(Integer.valueOf(secondElement));
                case "RemoveAt" -> numbers.remove(secondElement);
                case "Insert" -> {
                    int index = Integer.parseInt(command.get(2));
                    numbers.add(index, secondElement); 

                }
            }



            command = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        }

        for (Integer number : numbers){
            System.out.print(number + " ");
        }
    }
}
