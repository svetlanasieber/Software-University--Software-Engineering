int number = int.Parse(Console.ReadLine());

//--> number == 0 -> zero
//--> number > 0 -> positive
//--> number < 0 -> negative

if (number == 0)
{
    Console.WriteLine("zero");
}
else if (number > 0)
{
    Console.WriteLine("positive");
}
else
{
    Console.WriteLine("negative");
}
