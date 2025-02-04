int[] array1 = Console.ReadLine()
    .Split(' ')
    .Select(int.Parse)
    .ToArray();


int[] array2 = Console.ReadLine()
    .Split(' ')
    .Select(int.Parse)
    .ToArray();


if (array1.Length != array2.Length)
{
    Console.WriteLine("Arrays are not identical.");
    return;
}

bool areIdentical = true;
for (int i = 0; i < array1.Length; i++)
{
    if (array1[i] != array2[i])
    {
        areIdentical = false;
        break;
    }
}


if (areIdentical)
{
    Console.WriteLine("Arrays are identical.");
}
else
{
    Console.WriteLine("Arrays are not identical.");
}
