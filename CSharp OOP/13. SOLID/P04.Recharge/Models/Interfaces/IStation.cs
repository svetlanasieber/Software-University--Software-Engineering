namespace P04.Recharge.Models.Interfaces;

public interface IStation
{
    public int Capacity { get; }

    public int Current { get; }

    public void Dismount();
}
