int width = int.Parse(Console.ReadLine());
int length = int.Parse(Console.ReadLine());

Console.WriteLine(CalculateRectangleArea(width, length));

//-----------------------------------------------------
//Method
static int CalculateRectangleArea(int width, int length)
{
    int area = width * length;
    return area;
}
