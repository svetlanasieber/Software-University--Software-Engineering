int n = int.Parse(Console.ReadLine());

List<string> products = new List<string>();

for (int i = 0; i < n; i++)
{
    string currenProduct = Console.ReadLine();
    products.Add(currenProduct);
}

products.Sort();

int counter = 1;

foreach (string product in products)
{
    Console.WriteLine($"{counter}.{product}");
    counter++;
}
