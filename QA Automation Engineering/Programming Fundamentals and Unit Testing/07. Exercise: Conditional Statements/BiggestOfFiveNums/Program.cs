int num1 = int.Parse(Console.ReadLine());
int num2 = int.Parse(Console.ReadLine());
int num3 = int.Parse(Console.ReadLine());
int num4 = int.Parse(Console.ReadLine());
int num5 = int.Parse(Console.ReadLine());

//Print the biggest number from the given five
if (num1 > num2 && num1 > num3 && num1 > num4 && num1 > num5)
{
    Console.WriteLine(num1);
}
else if (num2 > num1 && num2 > num3 && num2 > num4 && num2 > num5)
{
    Console.WriteLine(num2);
}
else if (num3 > num1 && num3 > num2 && num3 > num4 && num3 > num5)
{
    Console.WriteLine(num3);
}
else if (num4 > num1 & num4 > num2 && num4 > num3 && num4 > num5)
{
    Console.WriteLine(num4);
}
else if (num5 > num1 && num5 > num2 && num5 > num3 && num5 > num4)
{
    Console.WriteLine(num5);
}
