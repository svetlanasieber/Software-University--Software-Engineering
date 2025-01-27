int startNumber = int.Parse(Console.ReadLine());
int endNumber = int.Parse(Console.ReadLine());


for (int number = startNumber; number <= endNumber; number++)
{
  
    int count = 0; 
    for (int divisor = 1; divisor <= number; divisor++)
    {
        if (number % divisor == 0)
        {
           
            count++;
        }
    }
 
    if (count == 2)
    {
        
        Console.Write(number + " ");
    }
}


