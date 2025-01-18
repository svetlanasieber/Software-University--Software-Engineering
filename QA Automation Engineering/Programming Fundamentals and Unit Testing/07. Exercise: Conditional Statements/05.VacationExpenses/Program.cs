using System;

class Program
{
    static void Main()
    {
       
        string season = Console.ReadLine();
        string accommodationType = Console.ReadLine();
        int daysCount = int.Parse(Console.ReadLine());

      
        double pricePerNight = 0;
        double discount = 0;

        if (season == "Spring")
        {
            if (accommodationType == "Hotel") pricePerNight = 30;
            else if (accommodationType == "Camping") pricePerNight = 10;
            discount = 0.2; 
        }
        else if (season == "Summer")
        {
            if (accommodationType == "Hotel") pricePerNight = 50;
            else if (accommodationType == "Camping") pricePerNight = 30;
            discount = 0.0; 
        }
        else if (season == "Autumn")
        {
            if (accommodationType == "Hotel") pricePerNight = 20;
            else if (accommodationType == "Camping") pricePerNight = 15;
            discount = 0.3; 
        }
        else if (season == "Winter")
        {
            if (accommodationType == "Hotel") pricePerNight = 40;
            else if (accommodationType == "Camping") pricePerNight = 10;
            discount = 0.1; 
        }

     
        double totalPrice = daysCount * pricePerNight;
        totalPrice -= totalPrice * discount;

        Console.WriteLine($"{totalPrice:F2}");
    }
}
