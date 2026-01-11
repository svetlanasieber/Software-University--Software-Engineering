string word = Console.ReadLine();

Stack<char> stack = new Stack<char>();

foreach (var symbol in word)
{
    stack.Push(symbol);
}

while (stack.Count > 0)
{
    Console.Write(stack.Pop());
}
