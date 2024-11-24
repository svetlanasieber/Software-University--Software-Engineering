package MidExamPrep1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTarget_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

     
        List<Integer> targets = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

       
        List<String> command = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

     
        while (!command.get(0).equals("End")){

          
            String currentCommand = command.get(0);
       
            int index = Integer.parseInt(command.get(1));

          
            switch (currentCommand){

          

                case "Shoot" ->{
                 
                    if(index < targets.size() && index >=0){
                        int power = Integer.parseInt(command.get(2));//10
                        int currentTargetValue = targets.get(index); // 100 
                        int newValue = currentTargetValue - power;
                        targets.set(index, newValue);

                    
                        if(newValue <= 0){
                            targets.remove(index);
                        }
                    }
                }

               
                case "Add" -> {

                    if(index < targets.size() && index >=0){
                 
                        int value = Integer.parseInt(command.get(2));//10
                        targets.add(index, value); //{10, 52, 74, 23, 44, 96, 100}

                    }else {
                        System.out.println("Invalid placement!");
                    }
                }

                case "Strike" -> {
                  
                    int radius = Integer.parseInt(command.get(2));

              
                    if(index - radius >= 0 && index + radius < targets.size()){

                        targets.subList(index - radius, index + radius + 1).clear();// {10, 52, 74, 23, 44, 96, 100} -> index 2, radius 2 ->{96, 100}

                    }else {
                        System.out.println("Strike missed!");
                    }

                }
            }





            command = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        }


        System.out.println(targets.toString().replace("[", "").replace("]", "").replaceAll(", ", "|"));




    }
}
