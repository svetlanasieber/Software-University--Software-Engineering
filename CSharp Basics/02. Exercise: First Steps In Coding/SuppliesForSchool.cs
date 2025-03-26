using System;

namespace SuppliesForSchool
{
    class Program
    {
        static void Main(string[] args)
        {
            int penPackCount = int.Parse(Console.ReadLine());
            int markerPackCount = int.Parse(Console.ReadLine());
            int detergentLiters = int.Parse(Console.ReadLine());
            int discountPercent = int.Parse(Console.ReadLine());

            double total = penPackCount * 5.80 + markerPackCount * 7.20 + detergentLiters * 1.20;
            double discount = ((double)discountPercent / 100) * total;
            double sumAfterDiscount = total - discount;

            Console.WriteLine(sumAfterDiscount);
        }
    }
}