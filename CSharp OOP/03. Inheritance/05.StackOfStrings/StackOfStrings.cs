using System.Collections.Generic;

namespace CustomStack;

public class StackOfStrings : Stack<string>
{
    public bool IsEmpty() => Count == 0;

    public void AddRange(IEnumerable<string> items)
    {
        foreach (string item in items)
        {
            Push(item);
        }
    }
}