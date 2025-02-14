List <int> numbers = Console.ReadLine().Split(" ").Select(int.Parse).ToList();

string command = Console.ReadLine();

while (command != "end")
{
    List<string> commandParts = command.Split(" ").ToList();
    int element = int.Parse(commandParts[1]);

    if (command.StartsWith("Delete"))
    {
        numbers.RemoveAll(number => number == element);
    }
    else if (command.StartsWith("Insert"))
    {
        int index = int.Parse(commandParts[2]);
        numbers.Insert(index, element);
    }

    command = Console.ReadLine();
}

Console.WriteLine(string.Join(" ", numbers));
