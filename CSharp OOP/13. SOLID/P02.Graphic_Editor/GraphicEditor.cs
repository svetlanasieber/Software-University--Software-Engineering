using P02.Graphic_Editor.Models.Interfaces;

namespace P02.Graphic_Editor;

public class GraphicEditor
{
    public void DrawShape(IShape shape)
    {
        shape.Draw();
    }
}
