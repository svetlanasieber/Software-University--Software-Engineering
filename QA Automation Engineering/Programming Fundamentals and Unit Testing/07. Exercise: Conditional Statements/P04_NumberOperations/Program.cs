double firstNumber = double.Parse(Console.ReadLine());
double secondNumber = double.Parse(Console.ReadLine());
string mathOperator = Console.ReadLine();

double result = 0;
if (mathOperator == "+")
{
    result = firstNumber + secondNumber;
}
else if (mathOperator == "-")
{
    result = firstNumber - secondNumber;
}
else if (mathOperator == "*")
{
    result = firstNumber * secondNumber;
}
else if (mathOperator == "/")
{
    result = firstNumber / secondNumber;
}


Console.WriteLine($"{firstNumber} {mathOperator} {secondNumber} = {result:F2}");


