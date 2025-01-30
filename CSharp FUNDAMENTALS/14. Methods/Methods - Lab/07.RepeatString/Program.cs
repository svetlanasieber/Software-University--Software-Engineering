string text = Console.ReadLine();
int count = int.Parse(Console.ReadLine());

Console.WriteLine(RepeatString(text, count));

static string RepeatString(string text, int count)
{

    string result = "";
    for (int i = 1; i <= count; i++)
    {
        result += text;
    }
  
    return result;
}
