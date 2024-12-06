int countPages = int.Parse(Console.ReadLine());
int pagesPerHour = int.Parse(Console.ReadLine());
int needDays = int.Parse(Console.ReadLine());

int totalHours = countPages / pagesPerHour;
int hoursPerDay = totalHours / needDays;

Console.WriteLine(hoursPerDay);
