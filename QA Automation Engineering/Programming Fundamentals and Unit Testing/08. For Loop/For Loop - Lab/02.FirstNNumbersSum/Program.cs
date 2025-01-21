int number = int.Parse(Console.ReadLine());

int sum = 0;


for (int i = 1; i < number; i++)
{
    sum += i; //sum = sum + i;
    Console.Write($"{i}+");
}
sum += number;
Console.WriteLine($"{number}={sum}");

