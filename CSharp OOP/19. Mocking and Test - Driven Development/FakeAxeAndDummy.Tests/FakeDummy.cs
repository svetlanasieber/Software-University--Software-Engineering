namespace FakeAxeAndDummy.Tests;

public class FakeDummy : ITarget
{
    public int Health => 0;

    public void TakeAttack(int attackPoints)
    {
    }
    public int GiveExperience()
    {
        return 100;
    }

    public bool IsDead()
    {
        return true;
    }
}
