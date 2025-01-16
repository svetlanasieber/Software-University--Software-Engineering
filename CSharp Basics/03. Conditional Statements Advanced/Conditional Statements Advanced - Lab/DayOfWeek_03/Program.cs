int dayOfWeek = int.Parse(Console.ReadLine());

string output = "";
if (dayOfWeek == 1) { output = "Monday"; }
else if (dayOfWeek == 2)
{
    output = "Tuesday";
}
else if (dayOfWeek == 3){ output = "Wednesday"; }
else if (dayOfWeek == 4) { output = "Thursday"; }
else if (dayOfWeek == 5) { output = "Friday"; }
else if (dayOfWeek == 6) { output = "Saturday"; }
else if (dayOfWeek == 7)
{
    output = "Sunday";
}
else { output = "Error"; }
Console.WriteLine(output);
