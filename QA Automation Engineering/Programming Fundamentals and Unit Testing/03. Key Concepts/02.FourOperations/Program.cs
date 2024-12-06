double firstNumber = double.Parse(Console.ReadLine());
double secondNumber = double.Parse(Console.ReadLine());


double sum = firstNumber + secondNumber;


double diff = firstNumber - secondNumber;


double product = firstNumber * secondNumber;

double division = firstNumber / secondNumber;


Console.WriteLine($"{firstNumber:F2} + {secondNumber:F2} = {sum:F2}");
Console.WriteLine($"{firstNumber:F2} - {secondNumber:F2} = {diff:F2}");
Console.WriteLine($"{firstNumber:F2} * {secondNumber:F2} = {product:F2}");
Console.WriteLine($"{firstNumber:F2} / {secondNumber:F2} = {division:F2}");
