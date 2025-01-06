int n = int.Parse(Console.ReadLine());

//Edge case
char[] str = new char[n];
str[0] = 'H';
str[1] = 'e';
str[2] = 'l';
str[3] = 'l';
str[4] = 'o';

Console.WriteLine(str);

int[] numbers = new int[n];
numbers[0] = 1;
numbers[1] = 2;
numbers[2] = 3;

//Printing array direkt -> Print type of the variable
Console.WriteLine(string.Join(" ", numbers));
