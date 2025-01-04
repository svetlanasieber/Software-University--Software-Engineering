double[] numbers = Console.ReadLine()    
                   .Split(" ")           
                   .Select(double.Parse) 
                   .ToArray();

SortedDictionary<double, int> countOccurences = new SortedDictionary<double, int>();


foreach(double number in numbers)
{

   if (countOccurences.ContainsKey(number))
    {
       
        countOccurences[number]++;
    }
    else
    {
        
        countOccurences.Add(number, 1);
    }
}


foreach(KeyValuePair<double, int> entry in countOccurences)
{
   
    Console.WriteLine(entry.Key + " -> " + entry.Value);
}
