using System;
using System.Collections.Generic;

class Program
{
    static void Main()
    {
        
        Dictionary<string, (int Likes, int Comments)> followers = new Dictionary<string, (int Likes, int Comments)>();

        string input;
        while ((input = Console.ReadLine()) != "Log out")
        {
            
            string[] commandParts = input.Split(": ", StringSplitOptions.RemoveEmptyEntries);
            string command = commandParts[0];

            switch (command)
            {
                case "New follower":
                    string username = commandParts[1];
                    if (!followers.ContainsKey(username))
                    {
                        followers[username] = (0, 0); 
                    }
                    break;

                case "Like":
                    username = commandParts[1];
                    int count = int.Parse(commandParts[2]);
                    if (!followers.ContainsKey(username))
                    {
                        followers[username] = (count, 0); 
                    }
                    else
                    {
                        followers[username] = (followers[username].Likes + count, followers[username].Comments);
                    }
                    break;

                case "Comment":
                    username = commandParts[1];
                    if (!followers.ContainsKey(username))
                    {
                        followers[username] = (0, 1); 
                    }
                    else
                    {
                        followers[username] = (followers[username].Likes, followers[username].Comments + 1); 
                    }
                    break;

                case "Blocked":
                    username = commandParts[1];
                    if (followers.ContainsKey(username))
                    {
                        followers.Remove(username); 
                    }
                    else
                    {
                        Console.WriteLine($"{username} doesn't exist."); 
                    }
                    break;

                default:
                    Console.WriteLine("Invalid command.");
                    break;
            }
        }

        
        Console.WriteLine($"{followers.Count} followers");
        foreach (var follower in followers)
        {
            string name = follower.Key;
            int totalActivity = follower.Value.Likes + follower.Value.Comments;
            Console.WriteLine($"{name}: {totalActivity}");
        }
    }
}
