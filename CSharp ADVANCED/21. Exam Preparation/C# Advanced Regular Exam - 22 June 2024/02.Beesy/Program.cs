// 100 ot 100 => https://alpha.judge.softuni.org/contests/csharp-advanced-regular-exam-22-june-2024/5015/practice#2

using System;

public class P02_Beesy
{
    private static int energy = 15;
    private static int nectarCollected = 0;
    private static bool energyRestored = false;
    private static int startRow, startCol;
    private static char[,] field;

    public static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        field = new char[n, n];

        for (int row = 0; row < n; row++)
        {
            string line = Console.ReadLine();
            for (int col = 0; col < n; col++)
            {
                field[row, col] = line[col];
                if (field[row, col] == 'B')
                {
                    startRow = row;
                    startCol = col;
                }
            }
        }

        while (energy > 0)
        {
            string command = Console.ReadLine();
            if (command == "End")
            {
                break;
            }
            moveBee(command);
        }

        printResult();
        printField();
    }

    private static void moveBee(string direction)
    {
        int newRow = startRow, newCol = startCol;

        switch (direction)
        {
            case "up":
                newRow = (startRow - 1 + field.GetLength(0)) % field.GetLength(0);
                break;
            case "down":
                newRow = (startRow + 1) % field.GetLength(0);
                break;
            case "left":
                newCol = (startCol - 1 + field.GetLength(1)) % field.GetLength(1);
                break;
            case "right":
                newCol = (startCol + 1) % field.GetLength(1);
                break;
        }

        energy--;

        if (field[newRow, newCol] == 'H')
        {
            field[startRow, startCol] = '-';
            startRow = newRow;
            startCol = newCol;
            if (nectarCollected >= 30)
            {
                Console.WriteLine($"Great job, Beesy! The hive is full. Energy left: {energy}");
                field[startRow, startCol] = 'B';
            }
            else
            {
                Console.WriteLine("Beesy did not manage to collect enough nectar.");
                field[startRow, startCol] = 'B';
            }
            printField();
            Environment.Exit(0);
        }
        else if (char.IsDigit(field[newRow, newCol]))
        {
            nectarCollected += field[newRow, newCol] - '0';
            field[newRow, newCol] = '-';
        }

        field[startRow, startCol] = '-';
        startRow = newRow;
        startCol = newCol;
        field[startRow, startCol] = 'B';

        if (energy <= 0)
        {
            if (nectarCollected >= 30 && !energyRestored)
            {
                int extraNectar = nectarCollected - 30;
                energy += extraNectar;
                nectarCollected = 30;
                energyRestored = true;
            }

            if (energy <= 0)
            {
                if (nectarCollected < 30)
                {
                    Console.WriteLine("This is the end! Beesy ran out of energy.");
                }
                else
                {
                    Console.WriteLine("This is the end! Beesy ran out of energy.");
                }
                printField();
                Environment.Exit(0);
            }
        }
    }

    private static void printResult()
    {
        // Test
    }

    private static void printField()
    {
        for (int row = 0; row < field.GetLength(0); row++)
        {
            for (int col = 0; col < field.GetLength(1); col++)
            {
                Console.Write(field[row, col]);
            }
            Console.WriteLine();
        }
    }
}
