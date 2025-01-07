List<int> list;
Stack<int> stack = new Stack<int>();

stack.Push(1);
stack.Push(2);
stack.Push(3);
stack.Push(4);
stack.Push(5);

foreach (int item  in stack)
{
    Console.WriteLine(item);
}
