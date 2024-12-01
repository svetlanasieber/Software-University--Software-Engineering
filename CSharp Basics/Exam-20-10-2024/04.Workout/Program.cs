using System;

class Program
{
    static void Main()
    {
       
        int n = int.Parse(Console.ReadLine()); 
        double m = double.Parse(Console.ReadLine()); 

        double totalKilometers = m;

       
        for (int i = 0; i < n; i++)
        {
            int percentIncreaseMem = int.Parse(Console.ReadLine());
            m += m * percentIncreaseMem / 100;
            totalKilometers += m;
        }

        
        if (totalKilometers >= 1000)
        {
            Console.WriteLine($"You've done a great job running {Math.Ceiling(totalKilometers - 1000)} more kilometers!");
        }
        else
        {
            Console.WriteLine($"Sorry Mrs. Ivanova, you need to run {Math.Ceiling(1000 - totalKilometers)} more kilometers");
        }
    }
}

