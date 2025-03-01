using System.Text;

StringBuilder sb = new StringBuilder(); 


sb.Append("Marina ").Append(" Sieber").Append(" is 26 years old.");

Console.WriteLine(sb.ToString());
string text = sb.ToString(); 


Console.WriteLine(sb.Length);

sb.Clear();

Console.WriteLine(sb[0]);

sb.Insert(0, "Peter Scholz");

sb.Replace("Ivan", "Peter");


sb.Remove(0, 5);
