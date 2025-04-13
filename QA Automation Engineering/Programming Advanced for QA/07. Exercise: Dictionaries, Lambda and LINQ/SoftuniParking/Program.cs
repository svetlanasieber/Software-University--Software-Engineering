Dictionary<string, string> parking = new Dictionary<string, string>();

int countCommands = int.Parse(Console.ReadLine()); 


for (int count = 1; count <= countCommands; count++)
{
    string command = Console.ReadLine(); 

  
    if (command.Contains("unregister"))
    {

        string ownerOut = command.Split(" ")[1]; 
    
        if (!parking.ContainsKey(ownerOut))
        {
          
            Console.WriteLine($"ERROR: user {ownerOut} not found");
        }
        else
        {
           
            parking.Remove(ownerOut);
            Console.WriteLine($"{ownerOut} unregistered successfully");
        }

    }
    else if (command.Contains("register"))
    {
        string owner = command.Split()[1];
        string carNumber = command.Split()[2];

     
        if (!parking.ContainsKey(owner))
        {
           
            parking.Add(owner, carNumber);
            Console.WriteLine($"{owner} registered {carNumber} successfully");
        }
        else
        {
           
            Console.WriteLine($"ERROR: already registered with plate number {parking[owner]}");
        }    

    }
}

foreach(KeyValuePair< string, string> entry in parking)
{

    Console.WriteLine(entry.Key + " => " + entry.Value);
}




