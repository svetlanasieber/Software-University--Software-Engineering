using System.Text;

string result = "";
for (int i = 0; i < 1000; i++)
{
    result += i.ToString();
}

StringBuilder sb = new StringBuilder();
for (int i = 0; i < 1000; i++)
{
    sb.Append(i.ToString());
}
string finalResult = sb.ToString();

//--------------------------------------------------------

StringBuilder sBuilder = new StringBuilder("Hello");
sb.Append(" World");
sb.Insert(5, ",");
sb.Replace("World", "C#");
sb.Remove(0, 1);
Console.WriteLine(sBuilder.ToString()); // Output: ello,C# 

//------------------------------------------------------------
