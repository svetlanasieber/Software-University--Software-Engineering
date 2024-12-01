using System;

class Program
{
    static void Main()
    {
        // Четем входните данни
        int people = int.Parse(Console.ReadLine());
        int nights = int.Parse(Console.ReadLine());
        int transportCards = int.Parse(Console.ReadLine());
        int museumTickets = int.Parse(Console.ReadLine());

        // Цени
        double nightPrice = 20.00;
        double transportCardPrice = 1.60;
        double museumTicketPrice = 6.00;

        // Изчисляваме сумата за един човек
        double totalPerPerson = (nights * nightPrice) +
                                (transportCards * transportCardPrice) +
                                (museumTickets * museumTicketPrice);

        // Изчисляваме общата сума за цялата група
        double totalGroup = totalPerPerson * people;

        // Добавяме 25% за непредвидени разходи
        totalGroup += totalGroup * 0.25;

        // Отпечатваме резултата, форматиран до втората цифра след десетичната точка
        Console.WriteLine($"{totalGroup:F2}");
    }
}
