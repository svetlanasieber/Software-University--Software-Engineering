string number = Console.ReadLine(); 

int sumFactorials = 0;

foreach (var digit in number)
{
   
    int currentDigit = int.Parse(digit.ToString());

    if (currentDigit % 2 == 0)
    {
        sumFactorials += Factorial(currentDigit);
    }
}

Console.WriteLine(sumFactorials);


static int Factorial(int n)
{
    if (n == 0 || n == 1)
        return 1;

    int factorial = 1;

    for (int i = 2; i <= n; i++)
    {
        factorial *= i;
    }

    return factorial;
}
