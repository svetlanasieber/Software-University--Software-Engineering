using System;

namespace SpecialNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            string result = "";

            for (int curNum = 1111; curNum <= 9999; curNum++)
            {
                string curNumAsStr = curNum.ToString();
                bool isSpecial = true;

                for (int i = 0; i < curNumAsStr.Length; i++)
                {
                    double digit = Char.GetNumericValue(curNumAsStr[i]);

                    if (n % digit != 0)
                    {
                        isSpecial = false;
                        break;
                    }
                }

                if (isSpecial)
                {
                    result += $"{curNumAsStr} ";
                }
            }

            Console.WriteLine(result);
        }
    }
}