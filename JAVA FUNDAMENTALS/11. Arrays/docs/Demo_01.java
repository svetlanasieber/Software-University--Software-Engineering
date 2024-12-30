package Lab11_Arrays;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] days = new int[7];
        System.out.println(days.length);

        //Add Element Variant 1
        days[0] = 1;
        days[1] = 2;
        days[2] = 3;

        //Last element
        System.out.println(days[days.length - 1]);

        String[] months = new String[12];
        System.out.println(months.length);
        months[0] = "January";
        months[1] = "February";
        months[2] = "March";
        months[3] = "April";
        months[4] = "May";
        months[5] = "June";
        months[6] = "July";
        months[7] = "August";
        months[8] = "September";
        months[9] = "October";
        months[10] = "November";
        months[11] = "December";
        System.out.println(months[months.length - 1]);

    }
}
