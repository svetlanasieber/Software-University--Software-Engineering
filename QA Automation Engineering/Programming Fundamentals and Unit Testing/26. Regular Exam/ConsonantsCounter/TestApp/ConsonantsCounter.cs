using System.Collections.Generic;

namespace TestApp;

public static class ConsonantsCounter
{
    public static int CountTotalConsonants(List<string> words)
    {
        int totalConsonants = 0;

        string allChars = string.Join(string.Empty, words);

        foreach (char singleChar in allChars.ToLower())
        {
            if ("bcdfghjklmnpqrstvwxyz".Contains(singleChar))
            {
                totalConsonants += 1;
            }
        }

        return totalConsonants;
    }
}

