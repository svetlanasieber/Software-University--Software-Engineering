using System;

namespace DepositCalculator
{
    class Program
    {
        static void Main(string[] args)
        {
            double sumDeposited = Double.Parse(Console.ReadLine());
            int depositDurationMonths = int.Parse(Console.ReadLine());
            double annualInterest = Double.Parse(Console.ReadLine());

            double annualInterestPercent = annualInterest / 100;

            double sum = sumDeposited + depositDurationMonths * ((sumDeposited * annualInterestPercent) / 12);

            Console.WriteLine(sum);
        }
    }
}