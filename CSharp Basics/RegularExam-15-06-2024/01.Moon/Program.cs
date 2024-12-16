        double averageSpeed = double.Parse(Console.ReadLine());
        double fuelConsumptionPer100Km = double.Parse(Console.ReadLine());

        const double distanceToMoon = 384400;
        const int timeOnMoon = 3;

        double totalDistance = distanceToMoon * 2;
        double travelTime = totalDistance / averageSpeed; 
        int totalTime = (int)Math.Ceiling(travelTime) + timeOnMoon; 
        double totalFuel = (fuelConsumptionPer100Km * totalDistance) / 100; 

        Console.WriteLine(totalTime);
        Console.WriteLine(totalFuel);
