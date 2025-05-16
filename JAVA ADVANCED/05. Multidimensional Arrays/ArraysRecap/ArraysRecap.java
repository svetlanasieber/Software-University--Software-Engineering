package Arrays

public class DemoArrays {
    public static void main(String[] args) {
        int percentSales = 45;
        int percentSalaries = 34;
        int percentExpenses = 70;
        int percentBonuses = 56;

        int [] percents = {45, 34, 70, 56};
        double [] prices = {45.7, 12.3, 98.7, 45};
        String [] names = {"Desi", "Ivan", "Georgi"}; 

        int [] numbers = new int[4];

      
        numbers[0] = 96;
        numbers[1] = 12;

        System.out.println(names.length);
        int length = percents.length;

        System.out.println(prices[0]);
        double price = prices[1];
        System.out.println(prices[prices.length - 1]);

        System.out.println(prices[5]);
        prices[10] = 89;
    }
}
