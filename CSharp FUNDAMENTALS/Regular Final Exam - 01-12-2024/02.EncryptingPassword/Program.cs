using System;
using System.Text.RegularExpressions;

class Program
{
    static void Main()
    {
        int n = int.Parse(Console.ReadLine()); 

        for (int i = 0; i < n; i++)
        {
            string input = Console.ReadLine();

            
            string pattern = @"^(?<startSymbols>.+)>(?<group1>\d{3})\|(?<group2>[a-z]{3})\|(?<group3>[A-Z]{3})\|(?<group4>[^<>]{3})<\k<startSymbols>$";
            Match match = Regex.Match(input, pattern);

            if (match.Success)
            {
                
                string group1 = match.Groups["group1"].Value;
                string group2 = match.Groups["group2"].Value;
                string group3 = match.Groups["group3"].Value;
                string group4 = match.Groups["group4"].Value;

                string encryptedPassword = group1 + group2 + group3 + group4;

                Console.WriteLine($"Password: {encryptedPassword}");
            }
            else
            {
                Console.WriteLine("Try another password!");
            }
        }
    }
}
