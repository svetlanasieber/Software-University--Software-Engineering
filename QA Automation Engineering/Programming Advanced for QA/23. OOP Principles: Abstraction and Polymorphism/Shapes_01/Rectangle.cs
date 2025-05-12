using System;
namespace Shapes
{
    //описва всеки един правоъгълник (геометрична фигура)
    public class Rectangle : IDrawable
    {
        //характеристики
        private int height;
        private int width;

        public int Height { get; set;}
        public int Width { get; set; }

        //конструктор
        public Rectangle(int height, int width)
        {
            //нов празен обект
            this.Height = height;
            this.Width = width;
        }

        //действия
        public void Draw()
        {
            DrawLine(this.width, '*', '*');
            for (int i = 1; i < this.height - 1; i++)
            {
                DrawLine(this.width, '*', ' ');
            }
            DrawLine(this.width, '*', '*');
        }

        private void DrawLine(int width, char end, char mid)
        {
            Console.Write(end);
            for (int i = 1; i < width - 1; i++)
            {
                Console.Write(mid);
            }
            Console.WriteLine(end);
        }
    }
}

