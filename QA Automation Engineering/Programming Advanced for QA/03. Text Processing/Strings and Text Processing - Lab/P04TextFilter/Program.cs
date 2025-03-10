string[] badWords = Console.ReadLine().Split(", ");
string text = Console.ReadLine();


foreach (string badWord in badWords)
{
    string replacement = new string('*', badWord.Length);
    text = text.Replace(badWord, replacement);
}

Console.WriteLine(text);



