string articleData = Console.ReadLine();

string[] dataParts = articleData.Split(", ");


string title = dataParts[0]; 
string content = dataParts[1]; 
string author = dataParts[2];  

Article article = new Article(title, content, author);


int countCommands = int.Parse(Console.ReadLine());

for (int count = 1; count <= countCommands; count++)
{
    string command = Console.ReadLine();


    string[] commandParts = command.Split(": ");
    string commandName = commandParts[0]; 
    string commandParameter = commandParts[1];

    switch (commandName)
    {
        case "Edit":
            
            article.Edit(commandParameter);
            break;
        case "ChangeAuthor":
           
            article.ChangeAuthor(commandParameter);
            break;
        case "Rename":
       
            article.Rename(commandParameter);
            break;
    }

}

Console.WriteLine(article.ToString());







