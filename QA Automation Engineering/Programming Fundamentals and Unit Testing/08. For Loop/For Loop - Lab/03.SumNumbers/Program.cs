using System.Diagnostics.CodeAnalysis;

int count = int.Parse(Console.ReadLine()); 

double sum = 0; 

for (int number = 1; number <= count; number++)
{
    
    double value = double.Parse(Console.ReadLine());
   
    sum = sum + value; 
}

Console.WriteLine(sum);
