
namespace FakeAxeAndDummy.Tests;

using Moq;
using NUnit.Framework;

[TestFixture]
public class HeroTests
{
    [Test]
    public void NewHero_ShouldSetDataCorrectly()
    {
        IWeapon weapon = new Axe(10, 10);
        Hero hero = new("George", weapon);

        Assert.AreEqual("George", hero.Name);
        Assert.AreEqual(0, hero.Experience);
        Assert.NotNull(hero.Weapon);
    }

    //[Test]
    //public void HeroAttack_ShouldIncрeaseHeroExperiance()
    //{
    //    IWeapon axe = new Axe(10, 10);
    //    ITarget dummy = new Dummy(10, 90);
    //    Hero hero = new Hero("George", axe);

    //    hero.Attack(dummy);

    //    Assert.AreEqual(90, hero.Experience);
    //}

    //[Test]
    //public void HeroAttack_ShouldIncreaseHeroExperiance()
    //{
    //    IWeapon weapon = new FakeAxe();
    //    ITarget target = new FakeDummy();

    //    Hero hero = new Hero("George", weapon);

    //    hero.Attack(target);

    //    Assert.AreEqual(100, hero.Experience);
    //}

    [Test]
    public void HeroAttack_ShouldIncрeaseHeroExperiance()
    {
        Mock<IWeapon> weaponMock = new();
        Mock<ITarget> targetMock = new();

        targetMock.Setup(m => m.IsDead()).Returns(true);
        targetMock.Setup(m => m.GiveExperience()).Returns(100);

        Hero hero = new Hero("George", weaponMock.Object);

        hero.Attack(targetMock.Object);

        Assert.AreEqual(100, hero.Experience);
    }
}
