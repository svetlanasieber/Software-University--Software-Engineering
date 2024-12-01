using System;
using System.Collections.Generic;
using System.Linq;

class Program
{
    static void Main(string[] args)
    {
        // Step 1: Read the initial list of products and split by '|'
        List<string> products = Console.ReadLine().Split('|').ToList();
        string command;

        // Step 2: Process commands until "Shop!"
        while ((command = Console.ReadLine()) != "Shop!")
        {
            string[] commandParts = command.Split('%');
            string action = commandParts[0];
            string product = commandParts.Length > 1 ? commandParts[1] : null;

            switch (action)
            {
                case "Important":
                    Important(products, product);
                    break;
                case "Add":
                    Add(products, product);
                    break;
                case "Swap":
                    string secondProduct = commandParts[2];
                    Swap(products, product, secondProduct);
                    break;
                case "Remove":
                    Remove(products, product);
                    break;
                case "Reversed":
                    products.Reverse();
                    break;
            }
        }

        // Step 3: Print the final list of products
        for (int i = 0; i < products.Count; i++)
        {
            Console.WriteLine($"{i + 1}. {products[i]}");
        }
    }

    // Move the product to the beginning or add it if it doesn't exist
    static void Important(List<string> products, string product)
    {
        if (products.Contains(product))
        {
            products.Remove(product);
        }
        products.Insert(0, product);
    }

    // Add product if it does not already exist
    static void Add(List<string> products, string product)
    {
        if (products.Contains(product))
        {
            Console.WriteLine("The product is already in the list.");
        }
        else
        {
            products.Add(product);
        }
    }

    // Swap two products if both exist
    static void Swap(List<string> products, string product1, string product2)
    {
        if (products.Contains(product1) && products.Contains(product2))
        {
            int index1 = products.IndexOf(product1);
            int index2 = products.IndexOf(product2);
            products[index1] = product2;
            products[index2] = product1;
        }
        else
        {
            Console.WriteLine($"Product {(!products.Contains(product1) ? product1 : product2)} missing!");
        }
    }

    // Remove product if it exists
    static void Remove(List<string> products, string product)
    {
        if (products.Contains(product))
        {
            products.Remove(product);
        }
        else
        {
            Console.WriteLine($"Product {product} isn't in the list.");
        }
    }
}
