double[]  numbers = Console.ReadLine().Split(" ").Select(double.Parse).ToArray();


SortedDictionary<double, int> countOccurrences = new SortedDictionary<double, int>();

foreach (double number in numbers)
{
    if (countOccurrences.ContainsKey(number))
    {
        countOccurrences[number]++;
    }
    else
    {
        countOccurrences.Add(number, 1);
    }
}

foreach (KeyValuePair<double, int> entry in countOccurrences)
{
    Console.WriteLine(entry.Key + " -> " + entry.Value);
}

