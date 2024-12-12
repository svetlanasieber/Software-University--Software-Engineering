package For_Loop;

import java.util.Scanner;

public class Demo_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 6;
        int b = 4;
        System.out.println(n++ + --b - b-- + ++n);
    }
}
