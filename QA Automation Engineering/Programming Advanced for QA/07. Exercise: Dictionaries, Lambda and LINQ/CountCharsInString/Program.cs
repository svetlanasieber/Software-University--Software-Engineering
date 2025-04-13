string text = Console.ReadLine(); //"carrot"

Dictionary<char, int> symbolsCount = new Dictionary<char, int>();

foreach (char symbol  in text)
{
   
    if (symbol == ' ')
    {
        continue;
    }
    if (symbolsCount.ContainsKey(symbol))
    {

        symbolsCount[symbol]++;
    }
    else
    {
     
      symbolsCount.Add(symbol, 1);

    }
}


foreach(KeyValuePair<char, int> entry in symbolsCount)
{

    Console.WriteLine(entry.Key + " -> " + entry.Value);
}
