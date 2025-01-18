using System.Runtime.CompilerServices;
using System.Xml;

string dayOfWeek = Console.ReadLine();

string output = "";
switch (dayOfWeek)
{
    case "Monday":
    case "Tuesday":
    case "Wednesday":
    case "Thursday":
    case "Friday":
        output = "Working day";
        break;
    case "Saturday":
    case "Sunday":
        output = "Weekend";
        break;
    default:
        output = "Error";
        break;
        
}
Console.WriteLine(output);
