using System;

class NutritionAnalysis
{
    static void Main()
    {
    
        int N = int.Parse(Console.ReadLine());

        if (N <= 0)
        {
            Console.WriteLine(0);
            return;
        }

      
        int cumulativeCaloricIntakeOfFood = 0;

        for (int i = 0; i < N; i++)
        {
            
            int caloricValue = int.Parse(Console.ReadLine());

        
            cumulativeCaloricIntakeOfFood += caloricValue;

            
            Console.WriteLine(cumulativeCaloricIntakeOfFood);
        }
    }
}
