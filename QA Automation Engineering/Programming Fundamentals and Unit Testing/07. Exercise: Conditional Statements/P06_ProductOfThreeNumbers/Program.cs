using System;

class Program
{
    static void Main()
    {
       
        double num1 = double.Parse(Console.ReadLine());
        double num2 = double.Parse(Console.ReadLine());
        double num3 = double.Parse(Console.ReadLine());

    
        if (num1 == 0 || num2 == 0 || num3 == 0)
        {
            Console.WriteLine("zero");
        }
        else
        {
          
            int negativeCount = 0;

            if (num1 < 0) negativeCount++;
            if (num2 < 0) negativeCount++;
            if (num3 < 0) negativeCount++;

            if (negativeCount % 2 == 0)
            {
                Console.WriteLine("positive");
            }
            else
            {
                Console.WriteLine("negative");
            }
        }
    }
}


/*
double firstNumber = double.Parse(Console.ReadLine());
double secondNumber = double.Parse(Console.ReadLine());
double thirdNumber = double.Parse(Console.ReadLine());

if (firstNumber == 0 || secondNumber == 0 || thirdNumber == 0)
{
    Console.WriteLine("zero");
}
else if (firstNumber < 0 && secondNumber < 0 && thirdNumber < 0)
{
    Console.WriteLine("negative");
}
else if (firstNumber > 0 && secondNumber > 0 && thirdNumber < 0)
{
    Console.WriteLine("negative");
}
else if (firstNumber > 0 && secondNumber < 0 && thirdNumber > 0)
{
    Console.WriteLine("negative");
}
else if (firstNumber < 0 && secondNumber > 0 && thirdNumber > 0)
{
    Console.WriteLine("negative");
}
else
{
    Console.WriteLine("positive");
}
*/
