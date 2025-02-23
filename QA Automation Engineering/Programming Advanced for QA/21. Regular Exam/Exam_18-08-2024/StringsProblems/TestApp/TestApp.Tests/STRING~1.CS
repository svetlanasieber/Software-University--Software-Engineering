using System;
using System.Text;
using System.Linq;
using NUnit.Framework;
using System.Collections.Generic;

namespace TestApp.Tests;

[TestFixture]
public class StringLengthCalculatorTests
{
    [Test]
    public void Test_Calculate_EmptyString_ReturnsZero()
    {
        //Arrange
        string input = string.Empty;
        //Act
        int result = StringLengthCalculator.Calculate(input);
        //Assert
        Assert.AreEqual(0, result);
    }

    [Test]
    public void Test_Calculate_SingleEvenLengthWord_ReturnsCorrectInteger()
    {
        //Arrange
        string input = "test";
        //Act
        int result = StringLengthCalculator.Calculate(input);
        //Assert
        Assert.AreEqual(896, result);

    }

    [Test]
    public void Test_Calculate_SingleOddLengthWord_ReturnsCorrectInteger()
    {
        //Arrange
        string input = "SoftUni";

        //Act
        int result = StringLengthCalculator.Calculate(input);
        //Assert
        Assert.AreEqual(356, result);
    }

    [Test]
    public void Test_Calculate_WholeSentenceString_ReturnsCorrectInteger()
    {
        //Arrange
        string input = "SoftUni is the best!";

        //Act
        int result = StringLengthCalculator.Calculate(input);

        //Assert
        Assert.AreEqual(3624, result);
    }

}

