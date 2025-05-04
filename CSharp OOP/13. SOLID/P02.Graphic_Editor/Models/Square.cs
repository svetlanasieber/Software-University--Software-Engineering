using P02.Graphic_Editor.Models.Interfaces;
using System;

namespace P02.Graphic_Editor.Models;

public class Square : IShape
{
    public void Draw()
    {
        Console.WriteLine("I'm square");
    }
}
