using System;

namespace BasketballEquipment
{
    class Program
    {
        static void Main(string[] args)
        {
            int annualTrainingFee = int.Parse(Console.ReadLine());

            double sneakersPrice = 0.60 * annualTrainingFee;
            double outfitPrice = 0.80 * sneakersPrice;
            double ballPrice = 0.25 * outfitPrice;
            double accessoriesPrice = 0.20 * ballPrice;
            double totalPrice = annualTrainingFee + sneakersPrice + outfitPrice + ballPrice + accessoriesPrice;

            Console.WriteLine(totalPrice);
        }
    }
}