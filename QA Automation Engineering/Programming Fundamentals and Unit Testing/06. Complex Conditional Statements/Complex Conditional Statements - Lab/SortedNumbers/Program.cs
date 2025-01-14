int firstNum = int.Parse(Console.ReadLine());
int secondNum = int.Parse(Console.ReadLine());
int thirdNum = int.Parse(Console.ReadLine());

bool ascending = firstNum < secondNum && secondNum < thirdNum;
bool descending = firstNum > secondNum && secondNum > thirdNum;

if (ascending)
{
    Console.WriteLine("Ascending");
}
else if (descending)
{
    Console.WriteLine("Descending");
}
else
{
    Console.WriteLine("Not sorted");
}
