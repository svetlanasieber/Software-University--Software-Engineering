string[] wordsWithEvenLength = Console.ReadLine()                     
                  .Split(" ")                          
                  .Where(text => text.Length % 2 == 0)  
                  .ToArray();



foreach(string word in wordsWithEvenLength)
{
    Console.WriteLine(word);
}
