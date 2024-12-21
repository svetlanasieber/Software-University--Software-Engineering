
int width = int.Parse(Console.ReadLine());
int length = int.Parse(Console.ReadLine());

PrintRectangleArea(width, length);

static void PrintRectangleArea(int width, int length)
{
    int area = width * length;
    Console.WriteLine(area);
}
