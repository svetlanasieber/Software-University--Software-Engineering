using System;

int studentsCount = int.Parse(Console.ReadLine()!);

int topStudents = 0;
int betweenFourAndFive = 0;
int betweenThreeAndFour = 0;
int failedStudents = 0;
double totalGrades = 0.0;

for (int i = 0; i < studentsCount; i++)
{
    double grade = double.Parse(Console.ReadLine()!);
    totalGrades += grade;

    if (grade >= 5.00)
    {
        topStudents++;
    }
    else if (grade >= 4.00)
    {
        betweenFourAndFive++;
    }
    else if (grade >= 3.00)
    {
        betweenThreeAndFour++;
    }
    else
    {
        failedStudents++;
    }
}

double topStudentsPercent = (double)topStudents / studentsCount * 100;
double betweenFourAndFivePercent = (double)betweenFourAndFive / studentsCount * 100;
double betweenThreeAndFourPercent = (double)betweenThreeAndFour / studentsCount * 100;
double failedStudentsPercent = (double)failedStudents / studentsCount * 100;
double averageGrade = totalGrades / studentsCount;

Console.WriteLine($"Top students: {topStudentsPercent:F2}%");
Console.WriteLine($"Between 4.00 and 4.99: {betweenFourAndFivePercent:F2}%");
Console.WriteLine($"Between 3.00 and 3.99: {betweenThreeAndFourPercent:F2}%");
Console.WriteLine($"Fail: {failedStudentsPercent:F2}%");
Console.WriteLine($"Average: {averageGrade:F2}");
