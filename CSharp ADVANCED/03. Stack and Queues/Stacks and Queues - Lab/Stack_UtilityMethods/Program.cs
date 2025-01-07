//Utility Methods

Stack<int> stack = new Stack<int>();
stack.Push(0);
stack.Push(1);
stack.Push(2);
stack.Push(3);

Console.WriteLine(stack.Contains(2));

int[] array = stack.ToArray();

Console.WriteLine(string.Join(",", array));

stack.Clear(); //delete all elements in Stack
Console.WriteLine(stack.Count); 
