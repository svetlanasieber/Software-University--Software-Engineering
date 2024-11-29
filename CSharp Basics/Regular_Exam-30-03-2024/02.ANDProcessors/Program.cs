
        int plannedProcessors = int.Parse(Console.ReadLine());
        int numberOfEmployees = int.Parse(Console.ReadLine());
        int workingDays = int.Parse(Console.ReadLine());

        const int hoursPerDay = 8;
        const int hoursPerProcessor = 3;
        const double costPerProcessor = 110.10;

        int totalHours = numberOfEmployees * workingDays * hoursPerDay;
        int actualProcessors = totalHours / hoursPerProcessor;

        double profitOrLoss = (actualProcessors - plannedProcessors) * costPerProcessor;

        if (profitOrLoss >= 0)
        {
            Console.WriteLine($"Profit: -> {profitOrLoss:F2} BGN");
        }
        else
        {
            Console.WriteLine($"Losses: -> {Math.Abs(profitOrLoss):F2} BGN");
        }


