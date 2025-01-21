int number = int.Parse(Console.ReadLine()!);

int sum = 0;
while (number > 0) {
    int lastDigit = number % 10;
    sum += lastDigit; //sum = sum + lastDigit;
    number /= 10; //number = number / 10;
}
Console.WriteLine(sum);
