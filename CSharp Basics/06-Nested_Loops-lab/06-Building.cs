using System;

namespace Building
{
    class Program
    {
        static void Main(string[] args)
        {
            int floorsCount = int.Parse(Console.ReadLine());
            int roomsCount = int.Parse(Console.ReadLine());

            for (int curFloor = floorsCount; curFloor >= 1; curFloor--)
            {
                string result = "";

                for (int curRoom = 0; curRoom < roomsCount; curRoom++)
                {
                    if (curFloor == floorsCount)
                    {
                        result += $"L{curFloor}{curRoom} ";
                    }
                    else if (curFloor % 2 == 0)
                    {
                        result += $"O{curFloor}{curRoom} ";
                    }
                    else
                    {
                        result += $"A{curFloor}{curRoom} ";
                    }

                }

                Console.WriteLine(result);
            }

        }
    }
}