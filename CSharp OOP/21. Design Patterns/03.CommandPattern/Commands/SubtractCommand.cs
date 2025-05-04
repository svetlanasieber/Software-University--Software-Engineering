using _03.CommandPattern.Commands.Interfaces;

namespace _03.CommandPattern.Commands;

public class SubtractCommand : ICommand
{
    public SubtractCommand(int value)
    {
        Value = value;
    }

    public int Value { get; init; }

    public char Symbol => '-';

    public int Execute(int result)
    {
        return result - Value;
    }

    public int Undo(int result)
    {
        return result + Value;
    }
}
