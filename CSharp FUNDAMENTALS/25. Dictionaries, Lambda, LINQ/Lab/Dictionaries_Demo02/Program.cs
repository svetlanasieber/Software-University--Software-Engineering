// words count

Dictionary<string, int> wordsCount = new Dictionary<string, int>();

wordsCount["hello"] = 55;
wordsCount["hello"] = 45;
wordsCount["hello"]++;

Console.WriteLine(wordsCount["hello"]);
