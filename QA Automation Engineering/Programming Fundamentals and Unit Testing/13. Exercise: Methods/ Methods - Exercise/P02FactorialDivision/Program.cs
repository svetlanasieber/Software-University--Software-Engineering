int firstNumber = int.Parse(Console.ReadLine());
int secondNumber = int.Parse(Console.ReadLine());

int firstFactorial = FindFactorial(firstNumber);
int secondFactorial = FindFactorial(secondNumber);

int result = firstFactorial / secondFactorial;

Console.WriteLine(result);

static int FindFactorial(int number)
{
	int factorial = 1;

	for (int i = number; i >= 1; i--)
	{
		factorial = factorial * i;
	}

	return factorial;
}




