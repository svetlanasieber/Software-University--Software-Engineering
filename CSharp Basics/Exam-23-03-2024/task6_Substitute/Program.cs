using System;
namespace Substitute
{
    class Program
    {
        static void Main(string[] args)
        {
            int firstNumFirstDigit = int.Parse(Console.ReadLine());
            int firstNumSecondDigit = int.Parse(Console.ReadLine());
            int secondNumFirstDigit = int.Parse(Console.ReadLine());
            int secondNumSecondDigit = int.Parse(Console.ReadLine());
            int counter = 0;
            bool hasEnded = false;

            for (int firstNumFirstD = firstNumFirstDigit; firstNumFirstD <= 8; firstNumFirstD++)
            {
                for (int firstNumSecondDig = 9; firstNumSecondDig >= firstNumSecondDigit; firstNumSecondDig--)
                {
                    for (int secondNumFirstDig = secondNumFirstDigit; secondNumFirstDig <= 8; secondNumFirstDig++)
                    {
                        for (int secondNumSecondDig = 9; secondNumSecondDig >= secondNumSecondDigit; secondNumSecondDig--)
                        {
                            bool isValid = firstNumFirstD % 2 == 0 &&
                                secondNumFirstDig % 2 == 0 &&
                                firstNumSecondDig % 2 != 0 &&
                                secondNumSecondDig % 2 != 0;

                            int firstNum = firstNumFirstD * 10 + firstNumSecondDig;
                            int secondNum = secondNumFirstDig * 10 + secondNumSecondDig;

                            if (isValid && firstNum == secondNum)
                            {
                                Console.WriteLine($"Cannot change the same player.");
                            }
                            else if (isValid && firstNum != secondNum)
                            {
                                Console.WriteLine($"{firstNumFirstD}{firstNumSecondDig} - {secondNumFirstDig}{secondNumSecondDig}");
                                counter++; 
                            }
                            if (counter >= 6)
                            {
                                hasEnded = true;
                            }
                            if (hasEnded)
                            {
                                break;
                            }
                        }
                        if (hasEnded)
                        {
                            break;
                        }
                    }
                    if (hasEnded)
                    {
                        break;
                    }
                }
                if (hasEnded)
                {
                    break;
                }
            }

        }
    }
}
