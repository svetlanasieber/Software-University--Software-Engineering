using System;

namespace NumbersPyramid
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            int row = 1;
            int curNum = 1;
            string curRow = "";

            while (curNum <= n)
            {
                for (int i = 1; i <= row; i++)
                {
                    if (curNum == n)
                    {
                        curRow += $"{curNum} ";
                        Console.WriteLine(curRow);
                        return;
                    }
                    curRow += $"{curNum} ";
                    curNum++;
                }

                Console.WriteLine($"{curRow}");
                row++;
                curRow = "";
            }
        }
    }
}