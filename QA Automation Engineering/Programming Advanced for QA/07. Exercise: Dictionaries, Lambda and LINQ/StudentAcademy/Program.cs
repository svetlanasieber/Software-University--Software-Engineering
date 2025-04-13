Dictionary<string, List<double>> studentsGrade = new Dictionary<string, List<double>>();

int countStudents = int.Parse(Console.ReadLine());

for (int student = 1; student <= countStudents; student++)
{
    string studentName = Console.ReadLine(); 
    double grade = double.Parse(Console.ReadLine()); 

    if (studentsGrade.ContainsKey(studentName))
    {
        studentsGrade[studentName].Add(grade);
    }
   
    else
    {
        studentsGrade.Add(studentName, new List<double>() { grade });
    }

}

foreach(KeyValuePair<string, List<double>> entry in studentsGrade)
{

    string studentName = entry.Key;
    double averageGrade = entry.Value.Average();

    if (averageGrade >= 4.50)
    {
        Console.WriteLine($"{studentName} -> {averageGrade:F2}");
    }
}

