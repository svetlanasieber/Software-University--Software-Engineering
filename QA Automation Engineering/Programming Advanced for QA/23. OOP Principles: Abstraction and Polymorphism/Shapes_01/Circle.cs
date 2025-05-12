using System;
namespace Shapes
{
    //наследяване на клас - достъп до всички полета и методи
    //имплементиране на interface - възможност да изпълним всички методи в interface
    //описва всеки един кръг (геометрична фигура)


    //клас Circle импелементира интерфейса IDrawable
    //-> кръгът ще има възможността да се чертае
    //-> кръгът да изпълни всички методи свързани с чертаенето
    public class Circle : IDrawable
    {
        //характерстики -> радиус
        private int radius;
        public int Radius { get; set; }

        //конструктор
        public Circle (int radius)
        {
            this.Radius = radius;
        }

        //действия
        public void Draw()
        {
            //дваме детайли как точно се чертае кръг
            double rIn = this.radius - 0.4;
            double rOut = this.radius + 0.4;
            for (double y = this.radius; y >= -this.radius; --y)
            {
                for (double x = -this.radius; x < rOut; x += 0.5)
                {
                    double value = x * x + y * y;

                    if (value >= rIn * rIn && value <= rOut * rOut)
                    {
                        Console.Write("*");
                    }
                    else
                    {
                        Console.Write(" ");
                    }
                }
                Console.WriteLine();
            }
        }
    }
}

