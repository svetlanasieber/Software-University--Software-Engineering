using NUnit.Framework;

namespace TestApp.Tests
{
    [TestFixture]
    public class EvenNumbersFinderTests
    {
        [Test]
        public void Test_FindEvenNumbers_StartGreaterThanEnd_ReturnsErrorMessage()
        {
            // Arrange
            int start = 10;
            int end = 5;

            // Act
            string result = EvenNumbersFinder.FindEvenNumbers(start, end);

            // Assert
            Assert.That(result, Is.EqualTo("Start number should not be greater than end number."));
        }

        [Test]
        public void Test_FindEvenNumbers_NoEvenNumbersInRange_ReturnsEmptyString()
        {
            // Arrange
            int start = 23;
            int end = 23;

            // Act
            string result = EvenNumbersFinder.FindEvenNumbers(start, end);

            // Assert
            Assert.That(result, Is.Empty);
        }

        [Test]
        public void Test_FindEvenNumbers_SingleEvenNumberInRange_ReturnsThatNumber()
        {
            // Arrange
            int start = 7;
            int end = 8;

            // Act
            string result = EvenNumbersFinder.FindEvenNumbers(start, end);

            // Assert
            Assert.That(result, Is.EqualTo("8"));
        }

        [Test]
        public void Test_FindEvenNumbers_MultipleEvenNumbersInRange_ReturnsEvenNumbers()
        {
            // Arrange
            int start = 2;
            int end = 10;

            // Act
            string result = EvenNumbersFinder.FindEvenNumbers(start, end);

            // Assert
            Assert.That(result, Is.EqualTo("2 4 6 8 10"));
        }

        [Test]
        public void Test_FindEvenNumbers_ZeroInRange_ReturnsZero()
        {
            // Arrange
            int start = -2;
            int end = 2;

            // Act
            string result = EvenNumbersFinder.FindEvenNumbers(start, end);

            // Assert
            Assert.That(result, Is.EqualTo("-2 0 2"));
        }
    }
}
