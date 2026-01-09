string text = Console.ReadLine();

//Stack<string> stack = new Stack<string>();
Stack<char> stack = new Stack<char>();

foreach (char symbol in text)
{
    stack.Push(symbol);
}

while (stack.Count > 0)
{
    var symbol = stack.Pop();
    Console.Write(symbol);
}
