        int food = int.Parse(Console.ReadLine());
        food *= 1000;

        string input = Console.ReadLine();
        int eatenFood = 0;

        while (input != "Adopted")
        {
            int eaten = int.Parse(input);
            eatenFood += eaten;
            input = Console.ReadLine();
        }

        if (food >= eatenFood)
        {
            Console.WriteLine($"Food is enough! Leftovers: {food - eatenFood} grams.");
        }
        else
        {
            Console.WriteLine($"Food is not enough. You need {eatenFood - food} grams more.");
        }

