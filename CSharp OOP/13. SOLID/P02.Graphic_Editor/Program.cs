using P02.Graphic_Editor.Models;

namespace P02.Graphic_Editor;

class Program
{
    static void Main()
    {
        GraphicEditor graphicEditor = new();

        Circle circle = new();
        Rectangle rectangle = new();
        Square square = new();

        graphicEditor.DrawShape(circle);
        graphicEditor.DrawShape(rectangle);
        graphicEditor.DrawShape(square);
    }
}
