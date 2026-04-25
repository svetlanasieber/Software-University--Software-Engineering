using System;
using System.Collections.Generic;

namespace P04_MonthlyReport
{
    internal class P04_MonthlyReport
    {
        static void Main(string[] args)
        {
            Dictionary<string, double> distributors = new Dictionary<string, double>();
            Dictionary<string, double> clients = new Dictionary<string, double>();
            double totalIncome = 0;

            string command;
            while ((command = Console.ReadLine()) != "End")
            {
                string[] tokens = command.Split(' ', StringSplitOptions.RemoveEmptyEntries);
                string action = tokens[0];
                string name = tokens[1];
                double amount = double.Parse(tokens[2]);

                if (action == "Deliver")
                {
                    if (!distributors.ContainsKey(name))
                    {
                        distributors[name] = 0;
                    }
                    distributors[name] += amount;
                }
                else if (action == "Return")
                {
                    if (!distributors.ContainsKey(name))
                    {
                        continue;
                    }
                    if (distributors[name] < amount)
                    {
                        continue;
                    }

                    distributors[name] -= amount;
                    if (distributors[name] == 0)
                    {
                        distributors.Remove(name);
                    }
                }
                else if (action == "Sell")
                {
                    if (!clients.ContainsKey(name))
                    {
                        clients[name] = 0;
                    }
                    clients[name] += amount;
                    totalIncome += amount;
                }
            }

            foreach (var client in clients)
            {
                Console.WriteLine($"{client.Key}: {client.Value:F2}");
            }
            Console.WriteLine("-----------");
            foreach (var distributor in distributors)
            {
                Console.WriteLine($"{distributor.Key}: {distributor.Value:F2}");
            }
            Console.WriteLine("-----------");
            Console.WriteLine($"Total Income: {totalIncome:F2}");
        }
    }
}

