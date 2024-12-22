int number = int.Parse(Console.ReadLine()); 
int power = int.Parse(Console.ReadLine()); 

PrintPower(number, power);


static void PrintPower(int number, int power)
{
    Console.WriteLine(Math.Pow(number, power));
}

