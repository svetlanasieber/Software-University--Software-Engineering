
namespace TestApp;

public class YellingChecker
{
    public static Dictionary<string, int> AnalyzeSentence(string sentence)
    {
        Dictionary<string, int> result = new();

        if (string.IsNullOrEmpty(sentence))
        {
            return result;
        }

        string[] words = sentence.Split(' ', StringSplitOptions.RemoveEmptyEntries);

        foreach (string word in words)
        {
            if (word == word.ToUpper())
            {
                if (!result.ContainsKey("yelling"))
                {
                    result.Add("yelling", 0);
                }

                result["yelling"]++;
            }
            else if (word == word.ToLower())
            {
                if (!result.ContainsKey("speaking lower"))
                {
                    result.Add("speaking lower", 0);
                }

                result["speaking lower"]++;
            }
            else
            {
                if (!result.ContainsKey("speaking normal"))
                {
                    result.Add("speaking normal", 0);
                }

                result["speaking normal"]++;
            }
        }

        return result;
    }
}

