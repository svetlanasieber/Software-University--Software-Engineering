using System.Collections.Concurrent;
using System.ComponentModel;

Stack<int> stack = new Stack<int>();

//push - add na element
stack.Push(2);
stack.Push(5);
stack.Push(100);

//pop
int element = stack.Pop();
Console.WriteLine(element);
Console.WriteLine(stack.Pop());

//peak
Console.WriteLine(stack.Peek());

Console.WriteLine(stack.Count);
