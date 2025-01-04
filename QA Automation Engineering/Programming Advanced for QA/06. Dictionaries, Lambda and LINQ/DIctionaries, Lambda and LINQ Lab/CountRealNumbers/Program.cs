double [] numbers = Console.ReadLine().Split(" ").Select(double.Parse).ToArray();


SortedDictionary<double, int> countNumbers = new SortedDictionary<double, int>();

foreach(double number in numbers)
{
   
    if (countNumbers.ContainsKey(number))
    {
        countNumbers[number]++;
    }
    else
    {
        countNumbers.Add(number, 1);
    }
}

foreach (KeyValuePair<double, int> entry in countNumbers)
{
  
    Console.WriteLine(entry.Key + " -> " + entry.Value);
}
