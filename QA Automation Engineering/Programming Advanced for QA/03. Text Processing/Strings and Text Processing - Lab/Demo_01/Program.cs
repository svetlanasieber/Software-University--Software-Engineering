string name = "Desislava";


Console.WriteLine(name.Length);
int length = name.Length;


char firstSymbol = name[0];
Console.WriteLine(name[0]);


Console.WriteLine(name[name.Length - 1]);


char letter = 'A';
char symbol = char.Parse(Console.ReadLine());

//string = array of chars
char[] array = name.ToCharArray();
//"Desislava" -> ['D', 'e', 's', 'i', 's', 'l', 'a', 'v', 'a']
foreach (char s in array)
{
    Console.WriteLine(s);
}

//IMMUTABLE = READ ONLY
Console.WriteLine(name[2]);
//name[3] = 'U'; //ERROR

string newName = name.Replace("Desislava", "Desislava123"); //name = name.Remove(4);
Console.WriteLine(newName);


//1. foreach 
foreach (char sym in name)
{
    
    Console.WriteLine(sym);
}

//2. for-loop -
for (int index = 0; index <= name.Length - 1; index++)
{
    if (index % 2 == 0)
        Console.WriteLine(name[index]);
}


string firstName = "Desislava";
string lastName = "Topuzakova";
int age = 20;
double grade = 5.5;
string fullName = firstName + " " + lastName;

string sentence = "I am " + firstName + " " + lastName + " and I am " + age + " years old.";

Console.WriteLine(fullName);
Console.WriteLine(firstName + lastName); //string + string = string
Console.WriteLine(firstName + age); //string + int = string
Console.WriteLine(lastName + grade); //string + double = string;
