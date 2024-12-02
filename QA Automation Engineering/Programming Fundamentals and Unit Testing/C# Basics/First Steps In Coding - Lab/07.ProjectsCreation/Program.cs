string architectName = Console.ReadLine();
int projectsCount = int.Parse(Console.ReadLine());

int needHoursToCreateOneProject = projectsCount * 3;


Console.WriteLine($"The architect {architectName} will need {needHoursToCreateOneProject} hours to complete {projectsCount} project/s.");
