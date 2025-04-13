Dictionary<string, List<string>> companyEmployees = new Dictionary<string, List<string>>();

string input = Console.ReadLine();


while (input != "End")
{

    string companyName = input.Split(" -> ")[0]; //"SoftUni"
    string employeeId = input.Split(" -> ")[1]; //"AA12345"



    if (companyEmployees.ContainsKey(companyName))
    {
        List<string> currentEmployees = companyEmployees[companyName];
        if (!currentEmployees.Contains(employeeId))
        {
            currentEmployees.Add(employeeId);
        }
    }
  
    else
    {
        companyEmployees.Add(companyName, new List<string>() { employeeId });
    }

    input = Console.ReadLine();
}


foreach(KeyValuePair<string, List<string>> entry in companyEmployees)
{

    Console.WriteLine(entry.Key);


    foreach(string employee in entry.Value)
    {
        Console.WriteLine("-- " + employee);
    }

}

