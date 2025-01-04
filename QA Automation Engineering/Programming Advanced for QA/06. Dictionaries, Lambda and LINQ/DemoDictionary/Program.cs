//Dictionary 
Dictionary<string, string> phonebook = new Dictionary<string, string>(); 


//var 1: Add
phonebook.Add("Ivan", "+359886543782");
phonebook.Add("Georgi", "+359887654325");

//var 2
phonebook["Peter"] = "+359882345123";
phonebook["Misho"] = "+359889237612";


Dictionary<string, int> fruits = new()
{
    { "Kiwi", 3 },
    { "Apple", 5 }
};


phonebook.Remove("Peter");

//ContainsKey и ContainsValue -> връщат true или false
bool containsCheck = phonebook.ContainsKey("Ivan");

Console.WriteLine(phonebook.ContainsKey("Ivan"));
Console.WriteLine(phonebook.ContainsKey("Boris"));

if (phonebook.ContainsKey("Georgi"))
{
    Console.WriteLine("Hello, Georgi");
}


int count = phonebook.Count;
Console.WriteLine(phonebook.Count);


//SortedDictionary  
SortedDictionary<string, double> students = new SortedDictionary<string, double>();
students.Add("Ivan", 5.60);
students.Add("Alex", 4.50);
students.Add("Georgi", 5.90);
students.Add("Martin", 5.35);



//ver 1
foreach (KeyValuePair<string, double> entry in students)
{
    //запис -> entry
    //entry.Key -> students name
    //entry.Value -> grade
    Console.WriteLine(entry.Key + " " + entry.Value);
}

//ver 2
//students.Keys 
//students.Values 
foreach(string key in students.Keys)
{
    Console.WriteLine(key + " " + students[key]);
}




Console.WriteLine(phonebook["Ivan"]);
