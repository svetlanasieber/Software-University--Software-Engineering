int[] firstArray = Console.ReadLine()
    .Split(' ')
    .Select(int.Parse)
    .ToArray();


int[] secondArray = Console.ReadLine()
    .Split(' ')
    .Select(int.Parse)
    .ToArray();


int[] commonElements = firstArray.Intersect(secondArray).ToArray();
Console.WriteLine(string.Join(" ", commonElements));
