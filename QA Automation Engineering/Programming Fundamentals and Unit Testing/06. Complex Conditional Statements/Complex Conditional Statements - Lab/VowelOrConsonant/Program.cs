char letter = char.Parse(Console.ReadLine());

switch (letter)
{
    case 'A':
    case 'a':
    case 'E':
    case 'e':
    case 'I':
    case 'i':
    case 'U':
    case 'u':
    case 'O':
    case 'o':
        Console.WriteLine("Vowel");
        break;
    default:
        Console.WriteLine("Consonant");
        break;
}
