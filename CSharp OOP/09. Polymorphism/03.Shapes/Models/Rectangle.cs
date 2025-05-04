namespace Shapes.Models;

public class Rectangle : Shape
{
    private double width;
    private double height;

    public Rectangle(double width, double height)
    {
        this.width = width;
        this.height = height;
    }

    public override double CalculateArea() => width * height;

    public override double CalculatePerimeter() => width * 2 + height * 2;
}
