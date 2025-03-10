using System.Text;

string text = Console.ReadLine(); 

StringBuilder sbDigits = new StringBuilder();

StringBuilder sbLetters = new StringBuilder();

StringBuilder sbOthers = new StringBuilder();

foreach(char symbol in text)
{
  
    if (char.IsLetter(symbol))
    {
        sbLetters.Append(symbol);
    }
    else if (char.IsDigit(symbol))
    {
        sbDigits.Append(symbol);
    }
    else
    {
        sbOthers.Append(symbol);
    }
}


Console.WriteLine(sbDigits);
Console.WriteLine(sbLetters);
Console.WriteLine(sbOthers);

