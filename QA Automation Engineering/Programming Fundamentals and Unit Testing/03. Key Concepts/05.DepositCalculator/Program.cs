double deposit = double.Parse(Console.ReadLine());
int months = int.Parse(Console.ReadLine());
double interest = double.Parse(Console.ReadLine());

double monthlyInterestAmount = deposit * interest / 100 / 12;
double totalAmount = deposit + monthlyInterestAmount * months;

Console.WriteLine(totalAmount);
