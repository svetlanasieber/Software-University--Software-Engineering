List<int> list;
Stack<int> stack = new Stack<int>();

stack.Push(1);
stack.Push(2);
stack.Push(3);


//foreach (int item  in stack)
//{
//    Console.WriteLine(item);
//}

Console.WriteLine(stack.Pop());
Console.WriteLine(stack.Pop());
Console.WriteLine(stack.Pop());
Console.WriteLine($"Count: {stack.Count}");
