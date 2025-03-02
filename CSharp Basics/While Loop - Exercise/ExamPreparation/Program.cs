using System;

namespace ExamPreparation
{
    class Program
    {
        static void Main(string[] args)
        {
            int maxBadGrades = int.Parse(Console.ReadLine());
            string input = Console.ReadLine();

            int badGradesCount = 0;
            int gradesSum = 0;
            int gradesCount = 0;
            string problemName = "";

            while (input != "Enough")
            {
                problemName = input;
                int grade = int.Parse(Console.ReadLine());

                if (grade <= 4)
                {
                    badGradesCount++;
                }

                if (badGradesCount == maxBadGrades)
                {
                    Console.WriteLine($"You need a break, {badGradesCount} poor grades.");
                    return;
                }

                gradesCount++;
                gradesSum += grade;
                input = Console.ReadLine();
            }

            double avgScore = (double)gradesSum / gradesCount;
            Console.WriteLine($"Average score: {avgScore:f2}");
            Console.WriteLine($"Number of problems: {gradesCount}");
            Console.WriteLine($"Last problem: {problemName}");
        }
    }
}
