using System;
using System.Collections.Generic;
using System.Linq;

namespace HouseParty
{
    internal class Program
    {
        static void Main(string[] args)
        {
            List<string> guestList = new List<string>();

            int n = int.Parse(Console.ReadLine());
            for (int i = 0; i < n; i++)
            {
                string[] cmdArgs = Console.ReadLine()
                    .Split(' ', StringSplitOptions.RemoveEmptyEntries);
                string name = cmdArgs[0];

                if (cmdArgs.Length == 3)
                {
                    
                    if (guestList.Contains(name))
                    {
                        Console.WriteLine($"{name} is already in the list!");
                        continue;
                    }

                    guestList.Add(name);
                }
                else if (cmdArgs.Length == 4)
                {
                    
                    if (!guestList.Contains(name))
                    {
                        Console.WriteLine($"{name} is not in the list!");
                        continue;
                    }

                    guestList.Remove(name);
                }
            }

            PrintGuestList(guestList);
        }

        static void PrintGuestList(List<string> guestList)
        {
            
            foreach (string name in guestList)
            {
                Console.WriteLine(name);
            }
        }

        static void PrintGuestListAlphabetically(List<string> guestList)
        {
            
            List<string> orderedList = guestList
                .OrderBy(e => e) //Will learn it later in the course!
                .ToList();
            foreach (string name in orderedList)
            {
                Console.WriteLine(name);
            }
        }
    }
}



//
// List<string> guestList = new List<string>(); 
//
//
// int n = int.Parse(Console.ReadLine());
//
//
// for (int i = 0; i < n; i++)
// {
//     string[] currentCommand = Console.ReadLine().Split(' ', StringSplitOptions.RemoveEmptyEntries);
//
//     string name = currentCommand[0]; 
//
//     if (currentCommand.Length == 3)
//     {
//         
//       
//         if (guestList.Contains(name))
//         {
//             
//             Console.WriteLine($"{name} is already in the list!");
//             continue; 
//         }
//         guestList.Add(name);
//     }
//     else if (currentCommand.Length == 4)
//     {
//         
//         if (!guestList.Contains(name))
//         {
//            
//             Console.WriteLine($"{name} is not in the list!");
//             continue; 
//         }
//         guestList.Remove(name);
//     }
// }
//
//
// foreach (string name in guestList)
// {
//     Console.WriteLine(name);
// }
