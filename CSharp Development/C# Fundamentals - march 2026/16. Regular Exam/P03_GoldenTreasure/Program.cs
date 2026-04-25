using System;
using System.Text;

namespace P03_GoldenTreasure
{
    internal class P03_GoldenTreasure
    {
        static void Main(string[] args)
        {
            string password = Console.ReadLine();
            StringBuilder sb = new StringBuilder();
            int freezeSkip = 0;

            string command;
            while ((command = Console.ReadLine()) != "Error")
            {
                if (freezeSkip > 0)
                {
                    freezeSkip--;
                    continue;
                }

                string[] tokens = command.Split(' ', StringSplitOptions.RemoveEmptyEntries);
                string action = tokens[0];

                if (action == "Infuse")
                {
                    sb.Append(tokens[1]);
                    Console.WriteLine(sb.ToString());
                }
                else if (action == "Transpose")
                {
                    int idx1 = int.Parse(tokens[1]);
                    int idx2 = int.Parse(tokens[2]);

                    if (idx1 < 0 || idx1 >= sb.Length || idx2 < 0 || idx2 >= sb.Length)
                    {
                        Console.WriteLine("Failed attempt to unlock the treasure");
                    }
                    else
                    {
                        char tmp = sb[idx1];
                        sb[idx1] = sb[idx2];
                        sb[idx2] = tmp;
                        Console.WriteLine(sb.ToString());
                    }
                }
                else if (action == "Retrace")
                {
                    int idx = int.Parse(tokens[1]);
                    string current = sb.ToString();
                    char[] toReverse = current.Substring(0, idx + 1).ToCharArray();
                    Array.Reverse(toReverse);

                    sb.Clear();
                    sb.Append(toReverse);
                    sb.Append(current.Substring(idx + 1));

                    Console.WriteLine(sb.ToString());
                }
                else if (action == "Destroy")
                {
                    string ch = tokens[1];
                    string current = sb.ToString();

                    if (!current.Contains(ch))
                    {
                        Console.WriteLine($"Character {ch} is invalid");
                    }
                    else
                    {
                        sb.Clear();
                        sb.Append(current.Replace(ch, ""));
                        Console.WriteLine(sb.ToString());
                    }
                }
                else if (action == "Freeze")
                {
                    freezeSkip = 2;
                }

                if (sb.ToString() == password)
                {
                    Console.WriteLine("The Golden Treasure has been unlocked!");
                    return;
                }
            }

            Console.WriteLine($"The string {sb.ToString()} does not match the password {password}!");
        }
    }
}
