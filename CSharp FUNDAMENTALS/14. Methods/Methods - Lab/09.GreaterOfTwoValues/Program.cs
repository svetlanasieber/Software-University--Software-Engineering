string type = Console.ReadLine();

PrintGreaterValue(type);


static void PrintGreaterValue (string type)
{
  
    switch (type)
    {
        case "int":
           
            int firstNumber = int.Parse(Console.ReadLine());
            int secondNumber = int.Parse(Console.ReadLine());
            if (firstNumber >= secondNumber)
            {
                Console.WriteLine(firstNumber);
            }
            else
            {
                Console.WriteLine(secondNumber);
            }
            break;
        case "string":
           
            string firstText = Console.ReadLine();
            string secondText = Console.ReadLine();

            if (String.Compare(firstText, secondText) >= 0)
            {
                Console.WriteLine(firstText);
            }
            else
            {
                
                Console.WriteLine(secondText);
            }
            break;
        case "char":
           
            char firstSymbol = char.Parse(Console.ReadLine());
            char secondSymbol = char.Parse(Console.ReadLine());

            if (firstSymbol <= secondSymbol)
            {
                Console.WriteLine(secondSymbol);
            }
            else
            {
                Console.WriteLine(firstSymbol);
            }
            break;
    }
}
