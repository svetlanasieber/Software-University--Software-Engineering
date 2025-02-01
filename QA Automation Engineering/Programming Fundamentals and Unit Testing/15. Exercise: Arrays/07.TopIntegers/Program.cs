int[] numbersArray = Console.ReadLine()
    .Split(" ")
    .Select(int.Parse)
    .ToArray();


for (int i = 0; i < numbersArray.Length - 1; i++)  
{

    bool isGreater = true;

    int currentElement = numbersArray[i]; 

    for (int j = i + 1; j < numbersArray.Length; j++)
    {
    
        int nextRightElement = numbersArray[j]; 

        if (nextRightElement >= currentElement)
        {
            isGreater = false;
            break;
        }
    }

    if (isGreater)
    {
        Console.Write(currentElement + " ");
    }
}

Console.Write(numbersArray[numbersArray.Length - 1]);
