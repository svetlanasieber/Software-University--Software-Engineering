using System.Diagnostics;
using System.Text;

Stopwatch sw = new Stopwatch();
sw.Start();
string text = "";
for (int i = 0; i < 200000; i++)
{
    text += i; //text = text + i;
}
sw.Stop();
Console.WriteLine(sw.ElapsedMilliseconds); 


/*Stopwatch sw = new Stopwatch();
sw.Start();
StringBuilder text = new StringBuilder();
for (int i = 0; i < 200000; i++)
{
    text.Append(i);
}
sw.Stop();
Console.WriteLine(sw.ElapsedMilliseconds); // 2
*/


