using System;
namespace Shapes
{
  
    public class Rectangle : IDrawable
    {
       
        private int height;
        private int width;

        public int Height { get; set;}
        public int Width { get; set; }

      
        public Rectangle(int height, int width)
        {
           
            this.Height = height;
            this.Width = width;
        }

      
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

