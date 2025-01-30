string password = Console.ReadLine();

if (ChechPassContainsBetweenSixAndTenCharacters(password) 
    && CheckPassConsistOnlyOfLettersAndDigits(password)
    && CheckPassHaveAtLeastTwoDigits(password))
{
    Console.WriteLine("Password is valid");
}

if (!ChechPassContainsBetweenSixAndTenCharacters(password))
{
    Console.WriteLine("Password must be between 6 and 10 characters");
}

if (!CheckPassConsistOnlyOfLettersAndDigits(password))
{
    Console.WriteLine("Password must consist only of letters and digits");
}

if (!CheckPassHaveAtLeastTwoDigits(password))
{
    Console.WriteLine("Password must have at least 2 digits");
}



static bool ChechPassContainsBetweenSixAndTenCharacters(string pass)
{
    if (pass.Length >= 6 && pass.Length <= 10)
        return true;
    else
        return false;
}

static bool CheckPassConsistOnlyOfLettersAndDigits(string pass)
{
    for (int i = 0; i < pass.Length; i++)
    {
        char currentLetter = pass[i];

        if (!char.IsLetterOrDigit(currentLetter))
            return false;	
    }

    return true;
}

static bool CheckPassHaveAtLeastTwoDigits(string pass)
{
    int countDigits = 0;

    for (int i = 0; i < pass.Length ; i++)
    {
        char currentLetter = pass[i];

        if (char.IsDigit(currentLetter))
        {
            countDigits++;

            if (countDigits == 2)
            {
                return true;
            }
        }
    }
	
    return false;
}
