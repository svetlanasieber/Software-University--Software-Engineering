using System;

namespace ProjectsCreation
{
    class Program
    {
        static void Main(string[] args)
        {
            string architectName = Console.ReadLine();
            int projectsCount = int.Parse(Console.ReadLine());

            int hoursNeeded = projectsCount * 3;

            Console.WriteLine($"The architect {architectName} will need {hoursNeeded} hours to complete {projectsCount} project/s.");
        }
    }
}
