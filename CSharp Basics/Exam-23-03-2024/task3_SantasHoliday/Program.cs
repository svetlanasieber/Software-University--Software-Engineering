using System;

class MainClass
{
    public static void Main(string[] args)
    {
        double ONE_PERSON_PRICE = 18.00;
        double APARTMENT_PRICE = 25.00;
        double PRESIDENT_PRICE = 35.00;

        int days_of_stay = int.Parse(Console.ReadLine());
        string room_type = Console.ReadLine();
        string evaluation = Console.ReadLine();

        double room_price = 0;

        if (days_of_stay < 10)
        {
            if (room_type == "room for one person")
            {
                room_price = ONE_PERSON_PRICE;
            }
            else if (room_type == "apartment")
            {
                room_price = APARTMENT_PRICE * (1 - 0.30);
            }
            else if (room_type == "president apartment")
            {
                room_price = PRESIDENT_PRICE * (1 - 0.10);
            }
        }
        else if (days_of_stay >= 10 && days_of_stay <= 15)
        {
            if (room_type == "room for one person")
            {
                room_price = ONE_PERSON_PRICE;
            }
            else if (room_type == "apartment")
            {
                room_price = APARTMENT_PRICE * (1 - 0.35);
            }
            else if (room_type == "president apartment")
            {
                room_price = PRESIDENT_PRICE * (1 - 0.15);
            }
        }
        else
        {
            if (room_type == "room for one person")
            {
                room_price = ONE_PERSON_PRICE;
            }
            else if (room_type == "apartment")
            {
                room_price = APARTMENT_PRICE * (1 - 0.50);
            }
            else if (room_type == "president apartment")
            {
                room_price = PRESIDENT_PRICE * (1 - 0.20);
            }
        }

        double total_price = room_price * (days_of_stay - 1);

        if (evaluation == "positive")
        {
            total_price += 0.25 * total_price;
        }
        else if (evaluation == "negative")
        {
            total_price -= 0.10 * total_price;
        }

        Console.WriteLine($"{total_price:F2}");
    }
}
