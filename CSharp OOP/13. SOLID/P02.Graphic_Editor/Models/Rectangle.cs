using P02.Graphic_Editor.Models.Interfaces;
using System;

namespace P02.Graphic_Editor.Models;

public class Rectangle : IShape
{
    public void Draw()
    {
        Console.WriteLine("I'm rectangle");
    }
}
