Dictionary<string, double> productsPrice = new Dictionary<string, double>();

Dictionary<string, int> productsQuantity = new Dictionary<string, int>();

string input = Console.ReadLine();

while (input != "buy")
{
    string[] productData = input.Split(" ");
    string productName = productData[0]; /
    double price = double.Parse(productData[1]); 
    int quantity = int.Parse(productData[2]); 

   
    if (productsPrice.ContainsKey(productName) && productsQuantity.ContainsKey(productName))
    {
     
        productsPrice[productName] = price;

        productsQuantity[productName] += quantity;
    }

    else
    {
        productsPrice.Add(productName, price);
        productsQuantity.Add(productName, quantity);
    }

    input = Console.ReadLine();
}

foreach(KeyValuePair<string, double> entry in productsPrice)
{

    string productName = entry.Key;
    double productPrice = entry.Value;
    int quantity = productsQuantity[productName];
    double totalPrice = productPrice * quantity;

    Console.WriteLine($"{productName} -> {totalPrice:F2}");
}


