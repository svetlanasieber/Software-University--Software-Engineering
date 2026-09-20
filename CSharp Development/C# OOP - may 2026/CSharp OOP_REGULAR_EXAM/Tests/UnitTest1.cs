using System;
using NUnit.Framework;

namespace MythicLegion.Tests
{
    public class Tests
    {
        private Legion legion;

        [SetUp]
        public void Setup()
        {
            legion = new Legion();
        }

        [Test]
        public void Constructor_ShouldCreateEmptyLegion()
        {
            Assert.AreEqual("No heroes in the legion.", legion.GetLegionInfo());
        }

        [Test]
        public void AddHero_ShouldThrowArgumentNullException_WhenHeroIsNull()
        {
            var ex = Assert.Throws<ArgumentNullException>(() => legion.AddHero(null));
            Assert.That(ex.ParamName, Is.EqualTo("hero"));
            Assert.That(ex.Message, Does.Contain("Hero cannot be null"));
        }

        [Test]
        public void AddHero_ShouldAddHero_WhenHeroIsValid()
        {
            var hero = new Hero("Aragorn", "Warrior");

            legion.AddHero(hero);

            string expected = "Aragorn (Warrior) - Power: 20, Health: 100, Trained: False";
            Assert.AreEqual(expected, legion.GetLegionInfo());
        }

        [Test]
        public void AddHero_ShouldAddMultipleHeroes_WhenNamesAreDifferent()
        {
            var first = new Hero("Aragorn", "Warrior");
            var second = new Hero("Legolas", "Archer");

            legion.AddHero(first);
            legion.AddHero(second);

            string expected = string.Join(
                Environment.NewLine,
                "Aragorn (Warrior) - Power: 20, Health: 100, Trained: False",
                "Legolas (Archer) - Power: 20, Health: 100, Trained: False");

            Assert.AreEqual(expected, legion.GetLegionInfo());
        }

        [Test]
        public void AddHero_ShouldThrowArgumentException_WhenHeroWithSameNameExists()
        {
            var hero = new Hero("Aragorn", "Warrior");
            var duplicate = new Hero("Aragorn", "Archer");
            legion.AddHero(hero);

            var ex = Assert.Throws<ArgumentException>(() => legion.AddHero(duplicate));
            Assert.That(ex.Message, Is.EqualTo("Hero with name Aragorn already exists in the legion."));
        }

        [Test]
        public void RemoveHero_ShouldReturnTrueAndRemove_WhenHeroExists()
        {
            var hero = new Hero("Aragorn", "Warrior");
            legion.AddHero(hero);

            bool result = legion.RemoveHero("Aragorn");

            Assert.IsTrue(result);
            Assert.AreEqual("No heroes in the legion.", legion.GetLegionInfo());
        }

        [Test]
        public void RemoveHero_ShouldReturnFalse_WhenHeroDoesNotExist()
        {
            var hero = new Hero("Aragorn", "Warrior");
            legion.AddHero(hero);

            bool result = legion.RemoveHero("Legolas");

            Assert.IsFalse(result);
            string expected = "Aragorn (Warrior) - Power: 20, Health: 100, Trained: False";
            Assert.AreEqual(expected, legion.GetLegionInfo());
        }

        [Test]
        public void RemoveHero_ShouldReturnFalse_WhenLegionIsEmpty()
        {
            bool result = legion.RemoveHero("Aragorn");

            Assert.IsFalse(result);
        }

        [Test]
        public void RemoveHero_ShouldOnlyRemoveMatchingHero()
        {
            legion.AddHero(new Hero("Aragorn", "Warrior"));
            legion.AddHero(new Hero("Legolas", "Archer"));

            bool result = legion.RemoveHero("Aragorn");

            Assert.IsTrue(result);
            string expected = "Legolas (Archer) - Power: 20, Health: 100, Trained: False";
            Assert.AreEqual(expected, legion.GetLegionInfo());
        }

        [Test]
        public void TrainHero_ShouldReturnSuccessMessage_WhenHeroExists()
        {
            var hero = new Hero("Aragorn", "Warrior");
            legion.AddHero(hero);

            string result = legion.TrainHero("Aragorn");

            Assert.AreEqual("Aragorn has been trained.", result);
        }

        [Test]
        public void TrainHero_ShouldIncreaseStatsAndSetTrained_WhenHeroExists()
        {
            var hero = new Hero("Aragorn", "Warrior");
            legion.AddHero(hero);

            legion.TrainHero("Aragorn");

            string expected = "Aragorn (Warrior) - Power: 30, Health: 101, Trained: True";
            Assert.AreEqual(expected, legion.GetLegionInfo());
        }

        [Test]
        public void TrainHero_ShouldStackStats_WhenTrainedMultipleTimes()
        {
            var hero = new Hero("Aragorn", "Warrior");
            legion.AddHero(hero);

            legion.TrainHero("Aragorn");
            legion.TrainHero("Aragorn");

            string expected = "Aragorn (Warrior) - Power: 40, Health: 102, Trained: True";
            Assert.AreEqual(expected, legion.GetLegionInfo());
        }

        [Test]
        public void TrainHero_ShouldReturnNotFoundMessage_WhenHeroDoesNotExist()
        {
            string result = legion.TrainHero("Legolas");

            Assert.AreEqual("Hero with name Legolas not found.", result);
        }

        [Test]
        public void TrainHero_ShouldNotChangeOtherHeroes()
        {
            legion.AddHero(new Hero("Aragorn", "Warrior"));
            legion.AddHero(new Hero("Legolas", "Archer"));

            legion.TrainHero("Aragorn");

            string expected = string.Join(
                Environment.NewLine,
                "Aragorn (Warrior) - Power: 30, Health: 101, Trained: True",
                "Legolas (Archer) - Power: 20, Health: 100, Trained: False");

            Assert.AreEqual(expected, legion.GetLegionInfo());
        }

        [Test]
        public void GetLegionInfo_ShouldReturnNoHeroesMessage_WhenLegionIsEmpty()
        {
            Assert.AreEqual("No heroes in the legion.", legion.GetLegionInfo());
        }

        [Test]
        public void GetLegionInfo_ShouldReturnSingleHeroInfo_WhenOneHeroExists()
        {
            legion.AddHero(new Hero("Gandalf", "Wizard"));

            string expected = "Gandalf (Wizard) - Power: 20, Health: 100, Trained: False";
            Assert.AreEqual(expected, legion.GetLegionInfo());
        }

        [Test]
        public void GetLegionInfo_ShouldJoinHeroesWithNewLine_WhenMultipleHeroesExist()
        {
            legion.AddHero(new Hero("Aragorn", "Warrior"));
            legion.AddHero(new Hero("Legolas", "Archer"));
            legion.AddHero(new Hero("Gimli", "Warrior"));

            string expected = string.Join(
                Environment.NewLine,
                "Aragorn (Warrior) - Power: 20, Health: 100, Trained: False",
                "Legolas (Archer) - Power: 20, Health: 100, Trained: False",
                "Gimli (Warrior) - Power: 20, Health: 100, Trained: False");

            Assert.AreEqual(expected, legion.GetLegionInfo());
        }
    }
}
