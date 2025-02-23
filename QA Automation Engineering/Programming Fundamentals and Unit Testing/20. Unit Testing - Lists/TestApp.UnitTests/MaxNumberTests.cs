using NUnit.Framework;

using System.Collections.Generic;

namespace TestApp.UnitTests;

public class MaxNumberTests
{

    [Test]
    public void Test_FindMax_InputHasOneElement_ShouldReturnTheElement()
    {
        //Arrange
        List<int> list = new List<int> { 4 };
        int expectedNumber = 4;

        //Act
        int actualNumber = MaxNumber.FindMax(list);

        //Assert
        Assert.That(expectedNumber, Is.EqualTo(actualNumber));
        //Assert.AreEqual(actualNumber, expectedNumber);
    }

    [Test]
    public void Test_FindMax_InputHasPositiveIntegers_ShouldReturnMaximum()
    {
        //Arrange
        List<int> numbersList = new List<int> { 4, 3, 5, 8 };
        int expectedMaxNumber = 8;

        //Act
        int actualMaxNumber = MaxNumber.FindMax(numbersList);

        //Assert
        Assert.AreEqual(expectedMaxNumber, actualMaxNumber);
    }

    [Test]
    public void Test_FindMax_InputHasNegativeIntegers_ShouldReturnMaximum()
    {
        //Arrange
        List<int> numbersList = new List<int> { -4, -3, -5, -8 };
        int expectedMaxNumber = -3;

        //Act
        int actualMaxNumber = MaxNumber.FindMax(numbersList);

        //Assert
        Assert.AreEqual(expectedMaxNumber, actualMaxNumber);
    }

    [Test]
    public void Test_FindMax_InputHasMixedIntegers_ShouldReturnMaximum()
    {
        //Arrange
        List<int> numbersList = new List<int> { 4, 5, -3, -8 };
        int expectedMaxNumber = 5;

        //Act
        int actualMaxNumber = MaxNumber.FindMax(numbersList);

        //Assert
        Assert.AreEqual(expectedMaxNumber, actualMaxNumber);
    }

    [Test]
    public void Test_FindMax_InputHasDuplicateMaxValue_ShouldReturnMaximum()
    {
        //Arrange
        List<int> numbersList = new List<int> { 4, 5, -3, -8, 5 };
        int expectedMaxNumber = 5;

        //Act
        int actualMaxNumber = MaxNumber.FindMax(numbersList);

        //Assert
        Assert.AreEqual(expectedMaxNumber, actualMaxNumber);
    }
}
