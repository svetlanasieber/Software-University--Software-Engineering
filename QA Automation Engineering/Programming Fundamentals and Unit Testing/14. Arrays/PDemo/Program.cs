using System.Collections.Concurrent;

int[] integerArray = new int[10]; 


double[] doubleArray = new double[10];


string[] stringArray = new string[10];


char[] charArray = new char[20];


integerArray[0] = 10;
integerArray[1] = 34;
integerArray[2] = 56;
integerArray[3] = 78;
doubleArray[0] = 10.5;
stringArray[0] = "Hello";


Console.WriteLine(integerArray[0]);
Console.WriteLine(doubleArray[0]);

double number = doubleArray[0];

Console.WriteLine(integerArray.Length);
Console.WriteLine(doubleArray.Length);

Console.WriteLine(stringArray[0].Length);
