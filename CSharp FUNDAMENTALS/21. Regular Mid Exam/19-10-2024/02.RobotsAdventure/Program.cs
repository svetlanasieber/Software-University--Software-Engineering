using System;
using System.Linq;

class 02.RoboAdventure
{
    static void Main()
    {
        
        int[] grid = Console.ReadLine().Split('|', StringSplitOptions.RemoveEmptyEntries)
                                       .Select(int.Parse)
                                       .ToArray();
        int totalItemsCollected = 0;

        while (true)
        {
            string command = Console.ReadLine();

            if (command == "Adventure over")
                break;

            
            if (command.StartsWith("Step Backward"))
            {
                string[] parts = command.Split('$');
                int startIndex = int.Parse(parts[1]);
                int steps = int.Parse(parts[2]);

                if (IsValidIndex(startIndex, grid.Length))
                {
                    
                    int newIndex = (startIndex - steps) % grid.Length;
                    if (newIndex < 0) newIndex += grid.Length;

                    
                    totalItemsCollected += grid[newIndex];
                    grid[newIndex] = 0;
                }
            }
            else if (command.StartsWith("Step Forward"))
            {
                string[] parts = command.Split('$');
                int startIndex = int.Parse(parts[1]);
                int steps = int.Parse(parts[2]);

                if (IsValidIndex(startIndex, grid.Length))
                {
                    
                    int newIndex = (startIndex + steps) % grid.Length;

                    
                    totalItemsCollected += grid[newIndex];
                    grid[newIndex] = 0;
                }
            }
            else if (command.StartsWith("Double"))
            {
                int index = int.Parse(command.Split()[1]);

                if (IsValidIndex(index, grid.Length))
                {
                    
                    grid[index] *= 2;
                }
            }
            else if (command == "Switch")
            {
                
                Array.Reverse(grid);
            }
        }

        
        Console.WriteLine(string.Join(" - ", grid));
        Console.WriteLine($"Robo finished the adventure with {totalItemsCollected} items!");
    }

   
    static bool IsValidIndex(int index, int length)
    {
        return index >= 0 && index < length;
    }
}
