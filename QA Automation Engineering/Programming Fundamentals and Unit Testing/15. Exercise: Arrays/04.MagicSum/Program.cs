int[] numbers = Console.ReadLine()
    .Split(" ")
    .Select(int.Parse)
    .ToArray();

int controlNumber = int.Parse(Console.ReadLine());

for (int i = 0; i < numbers.Length - 1; i++)
{
    int currentElement = numbers[i];

    if (currentElement > controlNumber)
        continue;

    for (int j = i + 1; j < numbers.Length; j++)
    {
        int nextRightElement = numbers[j];

        if (currentElement + nextRightElement == controlNumber)
        {
            Console.WriteLine(currentElement + " " + nextRightElement);
            break;
        }
    }
}
