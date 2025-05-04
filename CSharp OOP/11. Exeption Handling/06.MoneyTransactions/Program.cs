using System;
using System.Collections.Generic;

string[] input = Console.ReadLine().Split(",", StringSplitOptions.RemoveEmptyEntries);

Dictionary<string, decimal> bankAccounts = new();

foreach (string item in input)
{
    string[] accountTokens = item.Split("-", StringSplitOptions.RemoveEmptyEntries);
    bankAccounts.Add(accountTokens[0], decimal.Parse(accountTokens[1]));
}

string command;

while ((command = Console.ReadLine()) != "End")
{
    string[] tokens = command.Split(" ", StringSplitOptions.RemoveEmptyEntries);
    string action = tokens[0];

    try
    {
        decimal.TryParse(tokens[2], out decimal sum);
        if (action == "Withdraw" || action == "Deposit")
        {
            if (bankAccounts.ContainsKey(tokens[1]))
            {
                if (action == "Deposit")
                {
                    bankAccounts[tokens[1]] += sum;
                }
                else if (action == "Withdraw")
                {
                    if (bankAccounts[tokens[1]] >= sum)
                    {
                        bankAccounts[tokens[1]] -= sum;
                    }
                    else
                    {
                        throw new ArgumentException("Insufficient balance!");
                    }
                }
            }
            else
            {
                throw new ArgumentException("Invalid account!");
            }
        }
        else
        {
            throw new ArgumentException("Invalid command!");
        }
        Console.WriteLine($"Account {tokens[1]} has new balance: {bankAccounts[tokens[1]]:f2}");
    }
    catch (ArgumentException ex)
    {
        Console.WriteLine(ex.Message);
    }
    finally
    {
        Console.WriteLine("Enter another command");
    }
}

