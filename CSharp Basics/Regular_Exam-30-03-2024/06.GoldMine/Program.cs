        int locations = int.Parse(Console.ReadLine());

        for (int i = 0; i < locations; i++)
        {
            double goldPerDayExpected = double.Parse(Console.ReadLine());
            int workdays = int.Parse(Console.ReadLine());
            double totalGold = 0;

            for (int j = 0; j < workdays; j++)
            {
                double goldPerDay = double.Parse(Console.ReadLine());
                totalGold += goldPerDay;
            }

            double average = totalGold / workdays;

            if (average >= goldPerDayExpected)
            {
                Console.WriteLine($"Good job! Average gold per day: {average:f2}.");
            }
            else
            {
                Console.WriteLine($"You need {(goldPerDayExpected - average):f2} gold.");
            }
        }
