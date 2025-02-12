package List_Exercise;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());


        String command = scanner.nextLine();
        while (!command.equals("end")) {
            if (command.contains("Delete")) {
                int numberForDelete = Integer.parseInt(command.split(" ")[1]); 
                numbers.removeAll(List.of(numberForDelete));
                //numbers = {1, 2, 3, 4, 6}
            } else if (command.contains("Insert")) {
              
                int numberForInsertion = Integer.parseInt(command.split(" ")[1]); 
                int position = Integer.parseInt(command.split(" ")[2]); 
                numbers.add(position, numberForInsertion);
      
            }

            command = scanner.nextLine();
        }

        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}
