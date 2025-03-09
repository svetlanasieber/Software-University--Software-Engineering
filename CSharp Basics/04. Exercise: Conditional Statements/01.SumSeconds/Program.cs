int firstTime = int.Parse(Console.ReadLine());
int second = int.Parse(Console.ReadLine());
int third = int.Parse(Console.ReadLine());

int totalTime = firstTime + second + third;

int minutes = totalTime / 60;
int seconds = totalTime % 60;

Console.WriteLine($"{minutes}:{seconds:D2}");
