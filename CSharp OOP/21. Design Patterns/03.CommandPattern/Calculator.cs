using System;
using System.Collections.Generic;
using System.Linq;
using _03.CommandPattern.Commands.Interfaces;

namespace _03.CommandPattern;

public class Calculator
{
    List<ICommand> commands = new();
    List<ICommand> redoCommands = new();

    public int Result { get; set; }

    public void Calculate(ICommand command)
    {
        Result = command.Execute(Result);
        commands.Add(command);
    }

    public void Undo()
    {
        ICommand command = commands.Last();
        Result = command.Undo(Result);
        commands.Remove(command);
        redoCommands.Add(command);
    }

    public void Redo()
    {
        ICommand command = redoCommands.Last();
        Result = command.Execute(Result);
        redoCommands.Remove(command);
        commands.Add(command);
    }

    public void PrintExpression()
    {
        Console.Clear();

        Console.Write("0");

        foreach (ICommand command in commands)
        {
            Console.Write($" {command.Symbol} {command.Value}");
        }

        Console.WriteLine($" = {Result}");
    }
}
