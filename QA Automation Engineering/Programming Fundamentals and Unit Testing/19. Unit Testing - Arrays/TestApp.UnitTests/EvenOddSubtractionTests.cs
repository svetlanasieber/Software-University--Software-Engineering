using NUnit.Framework;

using System;

namespace TestApp.UnitTests;

public class EvenOddSubtractionTests
{
    [Test]
    public void Test_FindDifference_InputIsEmpty_ShouldReturnZero()
    {
        // Arrange
        int[] emptyArray = Array.Empty<int>();
        int expected = 0;

        // Act
        int result = EvenOddSubtraction.FindDifference(emptyArray);

        // Assert
        Assert.That(result, Is.EqualTo(expected));
    }

    // TODO: finish the test
    [Test]
    public void Test_FindDifference_InputHasOnlyEvenNumbers_ShouldReturnEvenSum()
    {
        // Arrange
        int[] arrayWithEvenNumbers = new int[] { 2, 6, 12 };
        int expected = 20;

        // Act
        int result = EvenOddSubtraction.FindDifference(arrayWithEvenNumbers);

        // Assert
        Assert.That(result, Is.EqualTo(expected));
    }

    [Test]
    public void Test_FindDifference_InputHasOnlyOddNumbers_ShouldReturnNegativeOddSum()
    {
        // Arrange
        int[] arrayWithOddNumbers = new int[] { 3, 7, 1 };
        int expected = -11;

        // Act
        int result = EvenOddSubtraction.FindDifference(arrayWithOddNumbers);

        // Assert
        Assert.That(result, Is.EqualTo(expected));
    }

    [Test]
    public void Test_FindDifference_InputHasMixedNumbers_ShouldReturnDifference()
    {
        // Arrange
        int[] arrayWithMixedNumbers = new int[] { 1, 2, 3, 4, 5 };
        int expected = -3;

        // Act
        int result = EvenOddSubtraction.FindDifference(arrayWithMixedNumbers);

        // Assert
        Assert.That(result, Is.EqualTo(expected));
    }
}
