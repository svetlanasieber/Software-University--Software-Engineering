int catFoodCount = int.Parse(Console.ReadLine());
int dogFoodCount = int.Parse(Console.ReadLine());

double catFoodPrice = 2.50;
double dogFoodPrice = 4.00;

double needSumForFood = (catFoodPrice * catFoodCount) + (dogFoodPrice * dogFoodCount);

Console.WriteLine($"{needSumForFood} lv.");
