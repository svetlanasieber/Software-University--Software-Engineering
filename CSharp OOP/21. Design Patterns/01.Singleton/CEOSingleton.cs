using System;

namespace _11.DesignPatterns;

public class CEOSingleton
{
    private static CEOSingleton instance;
    private static object padlock = new object();

    private CEOSingleton()
    {
        Console.WriteLine("Created new instance");
    }

    public static CEOSingleton Instance
    {
        get
        {
            if (instance is null)
            {
                lock (padlock)
                {
                    if (instance is null)
                    {
                        instance = new CEOSingleton();
                    }
                }
            }

            return instance;
        }
    }

    public string Name { get; set; }

    public int Age { get; set; }
}
