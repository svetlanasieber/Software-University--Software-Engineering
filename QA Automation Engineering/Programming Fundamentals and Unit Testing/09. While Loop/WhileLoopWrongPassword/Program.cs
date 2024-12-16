string password = Console.ReadLine();
while (password != "12345")
{
    Console.WriteLine($"Wrong password!---> {password}");
        password = Console.ReadLine();
}

Console.WriteLine("You are logged in!");
