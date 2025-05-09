using System;

namespace Password
{
    class Program
    {
        static void Main(string[] args)
        {
            string username = Console.ReadLine();
            string pass = Console.ReadLine();

            string passGuess = Console.ReadLine();

            while (passGuess != pass)
            {
                passGuess = Console.ReadLine();
            }

            Console.WriteLine($"Welcome {username}!");
        }
    }
}