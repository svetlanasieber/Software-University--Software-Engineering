double grade = double.Parse(Console.ReadLine());

PrintGradeAsText(grade);

//o	"Fail" - If the grade is in range 2.00 – 2.99 (inclusively)
//o	"Average" - If the grade is in range 3.00 – 3.49 (inclusively)
//o	"Good" - If the grade is in range 3.50 – 4.49 (inclusively)
//o	"Very good" - If the grade is in range 4.50 – 5.49 (inclusively)
//o	"Excellent" - If the grade is in range 5.50 – 6.00 (inclusively)

if (grade >= 2.00 && grade <= 2.99)
{
    Console.WriteLine("Fail");
}
else if (grade >= 3.00 && grade <= 3.49)
{
    Console.WriteLine("Average");
}
else if (grade >= 3.50 && grade <= 4.49)
{
    Console.WriteLine("Good");
}
else if (grade >= 4.50 && grade <= 5.49)
{
    Console.WriteLine("Very good");
}
else if (grade >= 5.50 && grade <= 6.00)
{
    Console.WriteLine("Excellent");
}

//--------------------------------------------------------

//method
static void PrintGradeAsText(double grade)
{
    if (grade >= 2.00 && grade <= 2.99)
    {
        Console.WriteLine("Fail");
    }
    else if (grade >= 3.00 && grade <= 3.49)
    {
        Console.WriteLine("Average");
    }
    else if (grade >= 3.50 && grade <= 4.49)
    {
        Console.WriteLine("Good");
    }
    else if (grade >= 4.50 && grade <= 5.49)
    {
        Console.WriteLine("Very good");
    }
    else if (grade >= 5.50 && grade <= 6.00)
    {
        Console.WriteLine("Excellent");
    }
}
