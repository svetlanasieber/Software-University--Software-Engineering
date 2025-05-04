namespace _03.CommandPattern.Commands.Interfaces;

public interface ICommand
{
    int Value { get; }

    char Symbol { get; }

    int Execute(int result);

    int Undo(int result);
}
