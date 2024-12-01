using System;

class Program
{
    static void Main()
    {
        string inputString = Console.ReadLine();

        string command;
        while (!string.IsNullOrEmpty(command = Console.ReadLine()))
        {
            string[] commandParts = command.Split(" ", StringSplitOptions.RemoveEmptyEntries);

           
            if (commandParts.Length == 0)
            {
                continue;
            }

            string mainCommand = commandParts[0];

            switch (mainCommand)
            {
                case "Replace":
                    if (commandParts.Length >= 3)
                    {
                        char currentChar = commandParts[1][0];
                        char newChar = commandParts[2][0];
                        inputString = inputString.Replace(currentChar, newChar);
                        Console.WriteLine(inputString);
                    }
                    break;

                case "Cut":
                    if (commandParts.Length >= 3 &&
                        int.TryParse(commandParts[1], out int startIndex) &&
                        int.TryParse(commandParts[2], out int endIndex))
                    {
                        if (IsValidIndex(startIndex, inputString.Length) && IsValidIndex(endIndex, inputString.Length))
                        {
                            inputString = inputString.Remove(startIndex, endIndex - startIndex + 1);
                            Console.WriteLine(inputString);
                        }
                        else
                        {
                            Console.WriteLine("Invalid indices!");
                        }
                    }
                    break;

                case "Make":
                    if (commandParts.Length >= 2)
                    {
                        string caseType = commandParts[1];
                        inputString = caseType == "Upper"
                            ? inputString.ToUpper()
                            : inputString.ToLower();
                        Console.WriteLine(inputString);
                    }
                    break;

                case "Check":
                    if (commandParts.Length >= 2)
                    {
                        string substring = commandParts[1];
                        if (inputString.Contains(substring))
                        {
                            Console.WriteLine($"Message contains {substring}");
                        }
                        else
                        {
                            Console.WriteLine($"Message doesn't contain {substring}");
                        }
                    }
                    break;

                case "Sum":
                    if (commandParts.Length >= 3 &&
                        int.TryParse(commandParts[1], out startIndex) &&
                        int.TryParse(commandParts[2], out endIndex))
                    {
                        if (IsValidIndex(startIndex, inputString.Length) && IsValidIndex(endIndex, inputString.Length))
                        {
                            int asciiSum = 0;
                            for (int i = startIndex; i <= endIndex; i++)
                            {
                                asciiSum += inputString[i];
                            }
                            Console.WriteLine(asciiSum);
                        }
                        else
                        {
                            Console.WriteLine("Invalid indices!");
                        }
                    }
                    break;

                default:
                    Console.WriteLine("Invalid command!");
                    break;
            }
        }
    }

    static bool IsValidIndex(int index, int length)
    {
        return index >= 0 && index < length;
    }
}
