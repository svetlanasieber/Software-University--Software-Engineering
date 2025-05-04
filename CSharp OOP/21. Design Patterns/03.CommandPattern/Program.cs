// See https://aka.ms/new-console-template for more information
using _03.CommandPattern;
using _03.CommandPattern.Commands;
using _03.CommandPattern.Commands.Interfaces;
using System;

Calculator calc = new();
ICommand command = null;

while (true)
{
    calc.PrintExpression();

    string symbol = Console.ReadLine();
    int value = 0;

    if (symbol != "u" && symbol != "r")
    {
        value = int.Parse(Console.ReadLine());
    }

    switch (symbol)
    {
        case "+": command = new AddCommand(value); break;
        case "-": command = new SubtractCommand(value); break;
        case "*": command = new MultiplyCommand(value); break;
        case "u": calc.Undo(); break;
        case "r": calc.Redo(); break;
        default: continue;
    }

    if (symbol != "u" && symbol != "r")
    {
        calc.Calculate(command);
    }
}
