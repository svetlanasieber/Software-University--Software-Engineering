using System;
using System.Globalization;

class Program
{
    static void Main(string[] args)
    {
        // Define constant costs
        const double NightCost = 20.0; 
        const double TransportCost = 1.60;
        const double MuseumCost = 6.0;

        
        int groupSize = int.Parse(Console.ReadLine());

        
        int nights = int.Parse(Console.ReadLine());

       
        int transportCards = int.Parse(Console.ReadLine());

        
        int museumTickets = int.Parse(Console.ReadLine());

        
        double totalCostPerPerson = (nights * NightCost) + (transportCards * TransportCost) + (museumTickets * MuseumCost);
        double totalCostForGroup = totalCostPerPerson * groupSize;
        double total = totalCostForGroup * 1.25;

        // Output the result, formatted to 2 decimal places
        Console.WriteLine($"{total.ToString("F2", CultureInfo.InvariantCulture)}");
    }
}}
