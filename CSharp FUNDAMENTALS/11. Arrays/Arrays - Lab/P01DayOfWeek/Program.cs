int number = int.Parse(Console.ReadLine()); 

string[] daysOfWeek = new string[7] {
    "Monday",
    "Tuesday",
    "Wednesday",
    "Thursday",
    "Friday",
    "Saturday",
    "Sunday"
};


if (number >= 1 && number <= 7)
{
    Console.WriteLine(daysOfWeek[number - 1]);
}
else
{
    
    Console.WriteLine("Invalid day!");
}
