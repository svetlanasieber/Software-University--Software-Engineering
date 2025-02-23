using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestApp;

public class EvenLengthWordsFilter
{
    public static string GetEvenWords(string[] words)
    {
        StringBuilder result = new StringBuilder();

        foreach (string word in words)
        {
            if (word.Length % 2 == 0)
            {
                result.Append(word + " ");
            }
        }

        return result.ToString().TrimEnd();
    }
}

