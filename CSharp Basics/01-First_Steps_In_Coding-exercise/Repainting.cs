using System;

namespace Repainting
{
    class Program
    {
        static void Main(string[] args)
        {
            int naylonQuantity = int.Parse(Console.ReadLine());
            int paintQuantity = int.Parse(Console.ReadLine());
            int separatorQuantity = int.Parse(Console.ReadLine());
            int workHours = int.Parse(Console.ReadLine());

            double finalPaintQuantity = paintQuantity * 1.1;
            int finalNaylonQuantity = naylonQuantity + 2;

            double totalMaterialsPrice = finalNaylonQuantity * 1.50 + finalPaintQuantity * 14.50 + separatorQuantity * 5 + 0.40;
            double workersPrice = (totalMaterialsPrice * 0.30) * workHours;

            Console.WriteLine(totalMaterialsPrice + workersPrice);
        }
    }
}