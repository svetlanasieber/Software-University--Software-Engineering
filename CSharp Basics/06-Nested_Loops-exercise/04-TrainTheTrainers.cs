using System;

namespace TrainTheTrainers
{
    class Program
    {
        static void Main(string[] args)
        {
            int judgesCount = int.Parse(Console.ReadLine());
            string input = Console.ReadLine();

            double totalGradesSum = 0.0;
            int gradesCount = 0;

            while (input != "Finish")
            {
                string presentationName = input;
                double gradesSum = 0.0;

                for (int curJudge = 1; curJudge <= judgesCount; curJudge++)
                {
                    double curGrade = double.Parse(Console.ReadLine());
                    gradesSum += curGrade;
                }

                double avgGrade = gradesSum / judgesCount;
                Console.WriteLine($"{presentationName} - {avgGrade:f2}.");

                totalGradesSum += avgGrade;
                gradesCount++;

                input = Console.ReadLine();
            }

            double totalAvgGrade = totalGradesSum / gradesCount;
            Console.WriteLine($"Student's final assessment is {totalAvgGrade:f2}.");
        }
    }
}