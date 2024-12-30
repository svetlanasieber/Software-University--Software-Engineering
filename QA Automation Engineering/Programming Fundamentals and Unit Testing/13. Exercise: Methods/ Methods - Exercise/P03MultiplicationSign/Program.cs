int num1 = int.Parse(Console.ReadLine());
int num2 = int.Parse(Console.ReadLine());
int num3 = int.Parse(Console.ReadLine());

ResultSign(num1,num2, num3);

static void ResultSign(int x, int y, int z)
{
	string result = "";

	if (x == 0 || y == 0 || z == 0)
	{
		result = "zero";
	}
	else if ((x > 0 && y > 0 && z > 0) 
		  || (x < 0 && y < 0 && z > 0) 
		  || (x > 0 && y < 0 && z < 0)
		  || (x < 0 && y > 0 && z < 0))
	{
		result = "positive";
	}
	else
	{
		result = "negative";
	}

    Console.WriteLine(result);
}

