namespace FakeAxeAndDummy.Tests;

public class FakeAxe : IWeapon
{
    public FakeAxe()
    {

    }
    public int AttackPoints { get; }

    public int DurabilityPoints { get; }

    public void Attack(ITarget target)
    {
    }
}
