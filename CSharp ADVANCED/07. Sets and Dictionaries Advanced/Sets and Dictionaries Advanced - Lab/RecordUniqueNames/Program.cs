using System;
using System.Collections.Generic;

namespace RecordUniqueNames
{
    internal class P06RecordUniqueNames
    {
        static void Main(string[] args)
        {
            int number = int.Parse(Console.ReadLine());
            HashSet<string> set = new HashSet<string>();
            for (int i = 0; i < number; i++)
            {
                string input = Console.ReadLine();
                set.Add(input);
            }
            foreach (var item in set)
            {
                Console.WriteLine(item);
            }
        }
    }
}
