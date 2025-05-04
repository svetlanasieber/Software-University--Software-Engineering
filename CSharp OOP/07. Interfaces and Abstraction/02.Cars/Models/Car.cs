using Cars.Models.Interfaces;

namespace Cars.Models;

public abstract class Car : ICar
{
    public Car(string model, string color)
    {
        Model = model;
        Color = color;
    }

    public string Model { get; private set; }

    public string Color { get; private set; }

    public string Start()
    {
        return "Engine start";
    }

    public string Stop()
    {
        return "Breaaak!";
    }

    public override string ToString()
    {
        return $"{Color} {Model}";
    }
}
