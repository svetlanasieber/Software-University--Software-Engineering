//Dictionary phoneBook
Dictionary<string, string> phoneBook = new Dictionary<string, string>(); 

//Add elements
// variant 1: Add
phoneBook.Add("Ivan", "+41793095669");
phoneBook.Add("Petar", "+41793095459");
phoneBook.Add("Georgi", "+41793093369");
phoneBook.Add("Ivan", "+417930345675"); //Argument exception

// variant 2
phoneBook["Ivan"] = "+417930956459";
phoneBook["Misho"] = "+417930333675";

