// See https://aka.ms/new-console-template for more information
using _11.DesignPatterns;
using System.Threading;

//CEOSingleton cEOSingleton = CEOSingleton.Instance;

//cEOSingleton.Name = "Satya Nadella";
//cEOSingleton.Age = 56;

//CEOSingleton cEOSingletonEx = CEOSingleton.Instance;
//cEOSingletonEx.Name = "Bill Gates";
//cEOSingletonEx.Age = 1000;

//Console.WriteLine(cEOSingleton.Name);
//Console.WriteLine(cEOSingleton.Age);

for (int i = 0; i < 10; i++)
{
    new Thread(() =>
    {
        CEOSingleton cEOSingleton = CEOSingleton.Instance;
    }).Start();
}
