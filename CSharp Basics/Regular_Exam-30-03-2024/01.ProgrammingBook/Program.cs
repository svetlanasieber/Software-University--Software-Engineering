
        double costPerPage = double.Parse(Console.ReadLine());
        double coverCost = double.Parse(Console.ReadLine());
        double paperDiscountPercent = double.Parse(Console.ReadLine());
        double designerFee = double.Parse(Console.ReadLine());
        double teamPaymentPercent = double.Parse(Console.ReadLine());

        
        double totalPrintingCost = costPerPage * 899 + coverCost * 2; 

        totalPrintingCost -= totalPrintingCost * (paperDiscountPercent / 100);
        double totalCost = totalPrintingCost + designerFee;
        double finalAmount = totalCost - totalCost * (teamPaymentPercent / 100);

        Console.WriteLine($"Avtonom should pay {finalAmount:F2} BGN.");

