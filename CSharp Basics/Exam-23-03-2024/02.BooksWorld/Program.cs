using System;
using System.Collections.Generic;
using System.Linq;

namespace BookGenres
{
    class Program
    {
        static void Main(string[] args)
        {
            // Четем началните жанрове и ги разделяме по " | "
            List<string> genres = Console.ReadLine().Split(" | ").ToList();

            // Четем командите докато не срещнем "Stop!"
            string command;
            while ((command = Console.ReadLine()) != "Stop!")
            {
                string[] parts = command.Split(' ');
                string action = parts[0];

                switch (action)
                {
                    case "Join":
                        {
                            string genre = parts[1];
                            if (!genres.Contains(genre))
                            {
                                genres.Add(genre);
                            }
                            break;
                        }
                    case "Drop":
                        {
                            string genre = parts[1];
                            genres.Remove(genre); // Remove игнорира, ако елементът не съществува
                            break;
                        }
                    case "Replace":
                        {
                            string oldGenre = parts[1];
                            string newGenre = parts[2];
                            int index = genres.IndexOf(oldGenre);
                            if (index != -1 && !genres.Contains(newGenre))
                            {
                                genres[index] = newGenre;
                            }
                            break;
                        }
                    case "Prefer":
                        {
                            int index1 = int.Parse(parts[1]);
                            int index2 = int.Parse(parts[2]);
                            if (index1 >= 0 && index1 < genres.Count && index2 >= 0 && index2 < genres.Count)
                            {
                                // Разменяме двата жанра
                                (genres[index1], genres[index2]) = (genres[index2], genres[index1]);
                            }
                            break;
                        }
                }
            }

            // Печатаме финалната колекция от жанрове
            Console.WriteLine(string.Join(" ", genres));
        }
    }
}
