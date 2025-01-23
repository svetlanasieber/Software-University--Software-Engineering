int num = int.Parse(Console.ReadLine()!);

int temp = num;
bool isSpecial = true;

while (temp > 0)
{
    int lastDigit = temp % 10;
    temp = temp / 10;

    if (num % lastDigit != 0)
    {
        isSpecial = false;
        break;
    }
}

if (isSpecial)
{
    Console.WriteLine($"{num} is special");
}
else
{
    Console.WriteLine($"{num} is not special");
}
