using Cars.Models.Interfaces;

namespace Cars.Models;

public class Tesla : Car, IElectricCar
{
    public Tesla(string model, string color, int battery)
        : base(model, color)
    {
        Battery = battery;
    }

    public int Battery { get; private set; }

    public override string ToString()
    {
        return $"{base.ToString()} with {Battery} Batteries";
    }
}
