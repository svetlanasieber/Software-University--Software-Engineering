using System;
using System.Collections.Generic;

namespace CustomRandomList;

public class RandomList : List<string>
{
    public string RandomString()
    {
        Random random = new();

        int index = random.Next(this.Count);

        string element = this[index];

        RemoveAt(index);

        return element;
    }
}
