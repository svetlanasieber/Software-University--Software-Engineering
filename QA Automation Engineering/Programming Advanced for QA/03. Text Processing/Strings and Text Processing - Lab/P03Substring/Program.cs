string wordToRemove = Console.ReadLine();
string sentence = Console.ReadLine(); 

while (sentence.Contains(wordToRemove))
{
    int positionWord = sentence.IndexOf(wordToRemove);
    sentence = sentence.Remove(positionWord, wordToRemove.Length);
}

Console.WriteLine(sentence);





