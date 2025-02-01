List<string> names = new List<string>(); // Create an empty list of strings
names.Add("Peter");
names.Add("Maria"); // Add elements
foreach (var name in names)
    Console.WriteLine(name);
Console.WriteLine(string.Join(", ", names)); // Print elements
