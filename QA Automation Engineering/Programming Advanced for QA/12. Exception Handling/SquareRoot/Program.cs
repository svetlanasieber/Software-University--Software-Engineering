try
{

    int number = int.Parse(Console.ReadLine());

    if (number < 0)
    {
        throw new ArgumentException("Invalid number."); 
    }
    else
    {
        Console.WriteLine(Math.Sqrt(number));
    }
}
catch (ArgumentException argEx)
{
    Console.WriteLine(argEx.Message);
}
finally
{
    Console.WriteLine("Goodbye.");
}

