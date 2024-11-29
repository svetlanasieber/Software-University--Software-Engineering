using System;
using System.Collections.Generic;
using System.Linq;

public class 03.SchoolLibrary
{
    public static void Main(string[] args)
    {
        List<string> books = new List<string>(Console.ReadLine().Split('&'));

        while (true)
        {
            string commandInput = Console.ReadLine();
            if (commandInput == "Done")
            {
                break;
            }

            string[] commandParts = commandInput.Split(" | ");
            string command = commandParts[0];

            if (command == "Swap Books")
            {
                string firstBook = commandParts[1];
                string secondBook = commandParts[2];

                if (books.Contains(firstBook) && books.Contains(secondBook))
                {
                    int firstBookIndex = books.IndexOf(firstBook);
                    int secondBookIndex = books.IndexOf(secondBook);
                   
                    books[firstBookIndex] = secondBook;
                    books[secondBookIndex] = firstBook;
                }
            }
            else
            {
                string bookName = commandParts[1];
                switch (command)
                {
                    case "Add Book":
                        if (!books.Contains(bookName))
                        {
                            books.Insert(0, bookName);
                        }
                        break;
                    case "Take Book":
                        books.Remove(bookName);
                        break;
                    case "Insert Book":
                        if (!books.Contains(bookName))
                        {
                            books.Add(bookName);
                        }
                        break;
                    case "Check Book":
                        if (int.TryParse(bookName, out int index) && index >= 0 && index < books.Count)
                        {
                            Console.WriteLine(books[index]);
                        }
                        break;
                    default:
                        break;
                }
            }
        }

        Console.WriteLine(string.Join(", ", books));
    }
}
