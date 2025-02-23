using NUnit.Framework;

using System;

namespace TestApp.UnitTests;

public class AverageTests
{
    // TODO: finish the test
    [Test]
    public void Test_CalculateAverage_InputHasOneElement_ShouldReturnSameElement()
    {
        // Arrange
        int[] array = { 42 };
        double expected = 42;

        // Act
        double result = Average.CalculateAverage(array);

        // Assert
        Assert.That(result, Is.EqualTo(expected));
    }

    [Test]
    public void Test_CalculateAverage_InputHasPositiveIntegers_ShouldReturnCorrectAverage()
    {
        // Arrange 
        int[] array = new int[] { 1, 2, 3, 4, 5 };
        double expected = 3;

        // Act
        double result = Average.CalculateAverage(array);

        // Assert
        Assert.That (result, Is.EqualTo(expected));
    }

    [Test]
    public void Test_CalculateAverage_InputHasNegativeIntegers_ShouldReturnCorrectAverage()
    {
        // Arrange 
        int[] array = new int[] { -1, -2, -3, -4, -5 };
        double expected = -3;

        // Act
        double result = Average.CalculateAverage(array);

        // Assert
        Assert.That(result, Is.EqualTo(expected));
    }

    [Test]
    public void Test_CalculateAverage_InputHasMixedIntegers_ShouldReturnCorrectAverage()
    {
        // Arrange 
        int[] array = new int[] { -1, 2, -3, 4, -5 };
        double expected = -0.6;

        // Act
        double result = Average.CalculateAverage(array);

        // Assert
        Assert.That(result, Is.EqualTo(expected).Within(0.01));
    }


    // Случай в който имате резултат в период (примерно 3.33333333)
    // Този тест не е за Judge и не е по условието 
    [Test]
    public void Bonus_Test()
    {
        // Arrange 
        int[] array = new int[] { 3, 6, 1 };
        double expected = 3.33;

        // Act
        double result = Math.Round(Average.CalculateAverage(array), 2);

        // Assert
        Assert.That(result, Is.EqualTo(expected));
    }
}
