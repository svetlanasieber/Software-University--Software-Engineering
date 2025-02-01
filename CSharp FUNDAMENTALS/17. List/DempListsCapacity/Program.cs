List<int> numbers = new List<int>();
numbers.Add(76);
numbers.Add(34);
numbers.Add(22);
numbers.Add(27);

Console.WriteLine($"Capacity: {numbers.Capacity}, Count: {numbers.Count}");

numbers.Add(21);

Console.WriteLine($"Capacity: {numbers.Capacity}, Count: {numbers.Count}");
