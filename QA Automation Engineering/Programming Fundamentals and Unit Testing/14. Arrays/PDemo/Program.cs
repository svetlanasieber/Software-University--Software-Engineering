using System.Collections.Concurrent;

int[] integerArray = new int[10]; 


double[] doubleArray = new double[10];


string[] stringArray = new string[10];


integerArray[0] = 10;
doubleArray[0] = 10.5;
stringArray[0] = "Hello";


Console.WriteLine(integerArray[0]);
Console.WriteLine(doubleArray[0]);

double number = doubleArray[0];
Console.WriteLine(stringArray[0].Length);
