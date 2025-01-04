string[] words = Console.ReadLine().Split(" ");    


Dictionary<string, int> wordsCount = new Dictionary<string, int>();


foreach(string word in words)
{
    
    string wordWithLowerCase = word.ToLower();

    if (!wordsCount.ContainsKey(wordWithLowerCase))
    {
      
        wordsCount.Add(wordWithLowerCase, 1);
    }
    else
    {
        wordsCount[wordWithLowerCase]++;
    }
}

foreach(KeyValuePair<string, int> entry in wordsCount)
{
 
    int countOccurences = entry.Value;
    if (countOccurences % 2 != 0)
    {
        Console.Write(entry.Key + " ");
    }
}

