List<int> numbers = new List<int>(); 

while (numbers.Count < 10)
{
    try
    {
        int number = ReadNumber(start, end);

        numbers.Add(number);
        start = number; 
    }
    catch (ArgumentException argEx)
    {
        Console.WriteLine(argEx.Message);
    }
    catch (FormatException formatEx)
    {
        Console.WriteLine(formatEx.Message);
    }
}


Console.WriteLine(String.Join(", ", numbers));


static int ReadNumber (int start, int end)
{
  
    string input = Console.ReadLine();


    try
    {
        int number = int.Parse(input); 
       
        if (number > start && number < end)
        {
          
            return number;
        }
        else
        {
           
            throw new ArgumentException($"Your number is not in range {start} - {end}!"); 
        }
    }
    catch (FormatException)
    {
       
        throw new FormatException("Invalid Number!");
    }
    
}



