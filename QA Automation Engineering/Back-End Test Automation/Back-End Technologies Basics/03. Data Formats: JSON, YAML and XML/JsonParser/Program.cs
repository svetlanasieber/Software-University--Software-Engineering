using System.Text.Json;
using JsonParser.Models;

namespace JsonParser
{
    class Program
    {
        static void Main(string[] args)
        {
            bool validChoice = false;

            while (!validChoice)
            {
                Console.WriteLine("Which JSON file would you like to parse? (books/students)");
                string? choice = Console.ReadLine();

                if (string.IsNullOrWhiteSpace(choice))
                {
                    Console.WriteLine("No input provided. Please enter 'books' or 'students'.");
                    continue;
                }

                choice = choice.ToLower();
                switch (choice)
                {
                    case "books":
                        ParseBooks();
                        validChoice = true;
                        break;
                    case "students":
                        ParseStudents();
                        validChoice = true;
                        break;
                    default:
                        Console.WriteLine("Invalid choice. Please enter 'books' or 'students'.");
                        break;
                }
            }
        }

      
        private static void ParseBooks()
        {
            string jsonFilePath = Path.Combine("Datasets", "books.json");
            try
            {
                string json = File.ReadAllText(jsonFilePath);
                List<Book>? books = JsonSerializer.Deserialize<List<Book>>(json);
                DisplayBooks(books);
            }
            catch (Exception e)
            {
                HandleError(e);
            }
        }

      
        private static void ParseStudents()
        {
            string jsonFilePath = Path.Combine("Datasets", "students.json");
            try
            {
                string json = File.ReadAllText(jsonFilePath);
                List<Student>? students = JsonSerializer.Deserialize<List<Student>>(json);
                DisplayStudents(students);
            }
            catch (Exception e)
            {
                HandleError(e);
            }
        }

       
        private static void DisplayBooks(List<Book>? books)
        {
            if (books == null)
            {
                Console.WriteLine("No books data found or data is not in the expected format.");
                return;
            }

            int bookNumber = 1;
            foreach (var book in books)
            {
                Console.WriteLine($"Book #{bookNumber}");
                Console.WriteLine($"Title: {book.Title}, Author: {book.Author}, Released: {book.Released}, Pages: {book.Pages}, ISBN: {book.ISBN}");
                bookNumber++;
            }
        }

     
        private static void DisplayStudents(List<Student>? students)
        {
            if (students == null)
            {
                Console.WriteLine("No students data found or data is not in the expected format.");
                return;
            }

            int studentNumber = 1;
            foreach (var student in students)
            {
                Console.WriteLine($"Student #{studentNumber}");
                Console.WriteLine($"Name: {student.Name}, Age: {student.Age}");
                foreach (var course in student.Courses)
                {
                    Console.WriteLine($"  Course: {course.Name}");
                }
                studentNumber++;
            }
        }

       
        private static void HandleError(Exception e)
        {
            if (e is JsonException)
            {
                Console.WriteLine($"JSON Parsing Error: {e.Message}");
            }
            else
            {
                Console.WriteLine($"An unexpected error occurred: {e.Message}");
            }
        }
    }
}
