using System;

namespace CinemaTickets
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();

            int studentTickets = 0;
            int standardTickets = 0;
            int kidTickets = 0;

            while (input != "Finish")
            {
                string movieName = input;
                int freeSpaces = int.Parse(Console.ReadLine());
                string command = Console.ReadLine();

                int spacesTaken = 0;

                while (command != "End")
                {
                    string ticketType = command;

                    if (ticketType == "student")
                    {
                        studentTickets++;
                    }
                    else if (ticketType == "standard")
                    {
                        standardTickets++;
                    }
                    else
                    {
                        kidTickets++;
                    }

                    spacesTaken++;

                    if (spacesTaken == freeSpaces)
                    {
                        break;
                    }

                    command = Console.ReadLine();
                }

                double percentTaken = ((double) spacesTaken / freeSpaces) * 100;
                Console.WriteLine($"{movieName} - {percentTaken:f2}% full."); ;

                input = Console.ReadLine();
            }

            int totalTickets = studentTickets + standardTickets + kidTickets;
            double studentPercent = ((double) studentTickets / totalTickets) * 100;
            double standardPercent = ((double) standardTickets / totalTickets) * 100;
            double kidPercent = ((double) kidTickets / totalTickets) * 100;

            Console.WriteLine($"Total tickets: {totalTickets}");
            Console.WriteLine($"{studentPercent:f2}% student tickets.");
            Console.WriteLine($"{standardPercent:f2}% standard tickets.");
            Console.WriteLine($"{kidPercent:f2}% kids tickets.");
        }
    }
}