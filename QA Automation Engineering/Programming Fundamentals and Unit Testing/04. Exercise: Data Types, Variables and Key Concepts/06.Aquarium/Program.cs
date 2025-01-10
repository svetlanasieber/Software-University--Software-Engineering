int length = int.Parse(Console.ReadLine());
int width = int.Parse(Console.ReadLine());
int height = int.Parse(Console.ReadLine());
double percentFillWithSandPlantAndPump = double.Parse(Console.ReadLine());


double aquariumAmountOfWater = length * width * height / 1000.0;

double finalLitters = aquariumAmountOfWater * (1 - percentFillWithSandPlantAndPump / 100);


Console.WriteLine($"{finalLitters:F2}");
