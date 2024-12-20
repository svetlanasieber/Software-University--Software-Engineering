PrintText();
for (int i = 0; i < 5; i++)
{
    Console.WriteLine(i);
}

PrintText();
int numberInRange = 5;
if (numberInRange > 2)
{
    Console.WriteLine(numberInRange);
}

PrintText();
while (numberInRange < 10)
{
    numberInRange--;
    PrintText();
}
PrintText();


static void PrintText()
{
    Console.WriteLine("Hello, Softuni");
    Console.WriteLine("Hello, Sofia!");
    Console.WriteLine("Hello, Desi!");
}


