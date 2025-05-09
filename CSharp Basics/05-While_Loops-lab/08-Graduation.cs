using System;

namespace Graduation
{
    class Program
    {
        static void Main(string[] args)
        {
            string name = Console.ReadLine();

            int badGradesCount = 0;
            int year = 1;
            double gradesSum = 0.0;

            while (year <= 12)
            {
                double curGrade = double.Parse(Console.ReadLine());
                gradesSum += curGrade;

                if (curGrade < 4)
                {
                    badGradesCount++;
                }
                else
                {
                    year++;
                }

                if (badGradesCount > 1)
                {
                    Console.WriteLine($"{name} has been excluded at {year} grade");
                    return;
                }

            }

            Console.WriteLine($"{name} graduated. Average grade: {(gradesSum / 12):f2}");
        }
    }
}