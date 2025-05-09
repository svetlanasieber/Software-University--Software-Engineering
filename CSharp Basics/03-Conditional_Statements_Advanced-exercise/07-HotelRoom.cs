using System;

namespace HotelRoom
{
    class Program
    {
        static void Main(string[] args)
        {
            string month = Console.ReadLine();
            int nights = int.Parse(Console.ReadLine());

            double studioPrice = 0.0;
            double apartmentPrice = 0.0;

            switch (month)
            {
                case "May":
                case "October":
                    studioPrice = nights * 50;
                    apartmentPrice = nights * 65;

                    if (nights > 14)
                    {
                        studioPrice *= 0.7;
                    }
                    else if (nights > 7)
                    {
                        studioPrice *= 0.95;
                    }
                    break;

                case "June":
                case "September":
                    studioPrice = nights * 75.20;
                    apartmentPrice = nights * 68.70;

                    if (nights > 14)
                    {
                        studioPrice *= 0.80;
                    }
                    break;

                case "July":
                case "August":
                    studioPrice = nights * 76;
                    apartmentPrice = nights * 77;
                    break;
            }

            if (nights > 14)
            {
                apartmentPrice *= 0.9;
            }

            Console.WriteLine($"Apartment: {apartmentPrice:f2} lv.");
            Console.WriteLine($"Studio: {studioPrice:f2} lv.");
        }
    }
}