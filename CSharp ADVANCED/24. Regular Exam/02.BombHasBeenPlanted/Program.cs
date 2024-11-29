using System;
using System.Linq;

class Program
{
    static void Main()
    {
        int[] dimensions = Console.ReadLine()
            .Split(", ")
            .Select(int.Parse)
            .ToArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        char[,] map = new char[rows, cols];
        int ctRow = 0, ctCol = 0;
        int initialRow = 0, initialCol = 0;

        for (int i = 0; i < rows; i++)
        {
            string line = Console.ReadLine();
            for (int j = 0; j < cols; j++)
            {
                map[i, j] = line[j];
                if (line[j] == 'C')
                {
                    ctRow = i;
                    ctCol = j;
                    initialRow = i;
                    initialCol = j;
                }
            }
        }

        int timeRemaining = 16;

        string command;
        while ((command = Console.ReadLine()) != null)
        {
            if (timeRemaining <= 0)
            {
                Console.WriteLine("Terrorists win!");
                Console.WriteLine("Bomb was not defused successfully!");
              
                Console.WriteLine($"Time needed: 0 second/s.");
                PrintMap(map, initialRow, initialCol);
                return;
            }

            if (command == "defuse")
            {
                if (map[ctRow, ctCol] == 'B')
                {
                    if (timeRemaining >= 4)
                    {
                        map[ctRow, ctCol] = 'D';
                        timeRemaining -= 4;
                        Console.WriteLine("Counter-terrorist wins!");
                        Console.WriteLine($"Bomb has been defused: {timeRemaining} second/s remaining.");
                    }
                    else
                    {
                        map[ctRow, ctCol] = 'X';
                        Console.WriteLine("Terrorists win!");
                        Console.WriteLine("Bomb was not defused successfully!");
                        
                        Console.WriteLine($"Time needed: {4 - timeRemaining} second/s.");
                    }
                    PrintMap(map, initialRow, initialCol);
                    return;
                }
                else
                {
                    timeRemaining -= 2;
                }
            }
            else
            {
                int nextRow = ctRow, nextCol = ctCol;

                switch (command)
                {
                    case "up": nextRow--; break;
                    case "down": nextRow++; break;
                    case "left": nextCol--; break;
                    case "right": nextCol++; break;
                }

                if (IsInsideMap(nextRow, nextCol, rows, cols))
                {
                    if (map[nextRow, nextCol] == 'T')
                    {
                        map[nextRow, nextCol] = '*';
                        Console.WriteLine("Terrorists win!");
                        PrintMap(map, initialRow, initialCol);
                        return;
                    }
                    ctRow = nextRow;
                    ctCol = nextCol;
                }

                timeRemaining--;
            }
        }
    }

    static bool IsInsideMap(int row, int col, int rows, int cols)
    {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    static void PrintMap(char[,] map, int initialRow, int initialCol)
    {
        for (int i = 0; i < map.GetLength(0); i++)
        {
            for (int j = 0; j < map.GetLength(1); j++)
            {
                if (i == initialRow && j == initialCol && map[i, j] != 'D' && map[i, j] != 'X')
                {
                    Console.Write('C');
                }
                else
                {
                    Console.Write(map[i, j]);
                }
            }
            Console.WriteLine();
        }
    }
}
