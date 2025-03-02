using System;

namespace OldLibrary
{
    class Program
    {
        static void Main(string[] args)
        {
            string searchedBook = Console.ReadLine();
            string input = Console.ReadLine();
            int booksChecked = 0;

            while (input != "No More Books")
            {
                if (input == searchedBook)
                {
                    Console.WriteLine($"You checked {booksChecked} books and found it.");
                    return;
                }

                booksChecked++;
                input = Console.ReadLine();
            }

            Console.WriteLine("The book you search is not here!");
            Console.WriteLine($"You checked {booksChecked} books.");
        }
    }
}
