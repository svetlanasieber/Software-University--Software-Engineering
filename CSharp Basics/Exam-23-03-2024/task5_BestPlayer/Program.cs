using System;

class MainClass
{
    public static void Main(string[] args)
    {
        int models_of_computers = int.Parse(Console.ReadLine());
        double reiting = 0;
        double sales = 0;

        for (int number = 1; number <= models_of_computers; number++)
        {
            int sales_plus_reiting = int.Parse(Console.ReadLine());
            int units = sales_plus_reiting % 10;
            int hundreds_plus_tens = sales_plus_reiting / 10;

            switch (units)
            {
                case 2:
                    sales += 0;
                    reiting += units;
                    break;
                case 3:
                    sales += hundreds_plus_tens * 0.50;
                    reiting += units;
                    break;
                case 4:
                    sales += hundreds_plus_tens * 0.70;
                    reiting += units;
                    break;
                case 5:
                    sales += hundreds_plus_tens * 0.85;
                    reiting += units;
                    break;
                case 6:
                    sales += hundreds_plus_tens * 1.0;
                    reiting += units;
                    break;
            }
        }

        double avg_reiting = reiting / models_of_computers;

        Console.WriteLine($"{sales:F2}");
        Console.WriteLine($"{avg_reiting:F2}");
 
