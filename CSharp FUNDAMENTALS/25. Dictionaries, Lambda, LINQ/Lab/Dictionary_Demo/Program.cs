// student ages
Dictionary<string, int> studentAges = new Dictionary<string, int>();

studentAges.Add("Peter", 20);
studentAges.Add("George", 30);
studentAges.Add("Maria", 40);

Console.WriteLine(studentAges["Peter"]);
Console.WriteLine(studentAges["George"]);

foreach (var student in studentAges)
{
    Console.WriteLine($"{student.Key} -> {student.Value}");
}
