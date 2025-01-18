using System;

class Program
{
    static void Main()
    {
       
        string[] fruits = { "banana", "apple", "kiwi", "cherry", "lemon", "grapes" };
        string[] vegetables = { "tomato", "cucumber", "pepper", "carrot" };


        string product = Console.ReadLine();

        string result = "unknown";

        for (int i = 0; i < fruits.Length; i++)
        {
            if (fruits[i] == product)
            {
                result = "fruit";
                break; 
            }
        }


        if (result == "unknown")
        {
            for (int i = 0; i < vegetables.Length; i++)
            {
                if (vegetables[i] == product)
                {
                    result = "vegetable";
                    break; 
                }
            }
        }

        Console.WriteLine(result);
    }
}
