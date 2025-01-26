package Demo_Arrays;

public class DemoArrayIteration {
    public static void main(String[] args) {
        int[] numbers = {45, 67, 87, 23, 13, 46};

        //1. for-loop 
        for (int position = 0; position <= numbers.length - 1; position++) {
          
            int number = numbers[position];
            if (position == 0) {
                System.out.println("This is the first element in the array");
            } else if (position == numbers.length - 1) {
                System.out.println("This is the last element in the array");
            }
            System.out.println(number);
        }

        //2. foreach loop -
        for (int number : numbers) {
          
           System.out.println(number);

        }


    }
}
