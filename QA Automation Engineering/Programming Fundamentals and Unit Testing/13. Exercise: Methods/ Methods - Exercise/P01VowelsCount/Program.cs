string input = Console.ReadLine();

PrintVowelsCount(input);

static void PrintVowelsCount(string text)
{
    int vowelsCount = 0;

    for (int i = 0; i < text.Length; i++)
    {
        char currentLetter = text[i];

        switch (currentLetter)
        {
            case 'a': vowelsCount++; break;
            case 'A': vowelsCount++; break;
            case 'e': vowelsCount++; break;
            case 'E': vowelsCount++; break;
            case 'o': vowelsCount++; break;
            case 'O': vowelsCount++; break;
            case 'i': vowelsCount++; break;
            case 'I': vowelsCount++; break;
            case 'u': vowelsCount++; break;
            case 'U': vowelsCount++; break;
        }
    }

    Console.WriteLine(vowelsCount);
}
