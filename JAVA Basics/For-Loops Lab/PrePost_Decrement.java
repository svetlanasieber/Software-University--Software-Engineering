package For_Loop;

import java.util.Scanner;

public class PrePost_Decrement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Pre-Decrement
        int a = 1;
        System.out.println(--a);
        System.out.println(a);

        System.out.println("-----------------------------------------");

        //Post-Decrement
        int b = 1;
        System.out.println(b--);
        System.out.println(b);
    }

}

