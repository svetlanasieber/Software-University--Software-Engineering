string studentName = Console.ReadLine();
int age = int.Parse(Console.ReadLine());
double averageGrade = double.Parse(Console.ReadLine());

Console.WriteLine($"Name: {studentName}, Age: {age}, Grade: {averageGrade:F2}");
