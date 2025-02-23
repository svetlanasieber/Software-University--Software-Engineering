using NUnit.Framework;
using System;

namespace TestApp.UnitTests;

public class TriangleTests
{
    [Test]
    public void Test_Triangle_OutputMatchesExpected_Size0()
    {
        // Arrange
        int size = 0;
        string expected = string.Empty;

        // Act
        string actual = Triangle.PrintTriangle(size);

        // Assert
        Assert.AreEqual(expected, actual);
    }

    [Test]
    public void Test_Triangle_OutputMatchesExpected_Size3()
    {
        // Arrange
        int size = 3;
        string expected = "1" 
        + Environment.NewLine + "1 2"
        + Environment.NewLine + "1 2 3"
        + Environment.NewLine + "1 2"
        + Environment.NewLine + "1";

        // Act
        string actual = Triangle.PrintTriangle(size);

        // Assert
        Assert.AreEqual(expected, actual);
    }

    [Test]
    public void Test_Triangle_OutputMatchesExpected_Size5()
    {
        // Arrange
        int size = 5;
        string expected = "1"
        + Environment.NewLine + "1 2"
        + Environment.NewLine + "1 2 3"
        + Environment.NewLine + "1 2 3 4"
        + Environment.NewLine + "1 2 3 4 5"
        + Environment.NewLine + "1 2 3 4"
        + Environment.NewLine + "1 2 3"
        + Environment.NewLine + "1 2"
        + Environment.NewLine + "1";

        // Act
        string actual = Triangle.PrintTriangle(size);

        // Assert
        Assert.AreEqual(expected, actual);
    }
}
