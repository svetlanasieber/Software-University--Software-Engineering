int number = Math.Abs(int.Parse(Console.ReadLine()));

Console.WriteLine(GetMultipleOfEvenAndOdds(number));

static int GetSumOfDigits(int num, string evenOrOdd)
{
	int sum = 0;

	while (num > 0)
	{
		int lastDigit = num % 10;

		if (lastDigit % 2 == 0)
		{
			if (evenOrOdd == "even")
				sum += lastDigit;
		}
        else
        {
			if (evenOrOdd == "odd")
				sum += lastDigit;
        }

        num /= 10;
	}

	return sum;
}

static int GetSumOfEvenDigits(int num)
{
	return GetSumOfDigits(num, "even");
}

static int GetSumOfOddDigits(int num)
{
	return GetSumOfDigits(num, "odd");
}

static int GetMultipleOfEvenAndOdds(int num)
{
	return GetSumOfEvenDigits(num) * GetSumOfOddDigits(num);
}

