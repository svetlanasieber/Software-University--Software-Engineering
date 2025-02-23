using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NUnit.Framework;
using static NUnit.Framework.Constraints.Tolerance;

namespace TestApp.UnitTests;

public class EvenLengthWordsFilterTests
{
    [Test]
    public void Test_GetEvenWords_InputArrayWithEmptyStrings_ShouldReturnEmptyString()
    {
        // Arrange
        string[] words = new string[] {"", string.Empty};
        string expected = string.Empty;

        // Act
        string result = EvenLengthWordsFilter.GetEvenWords(words);

        // Assert
        Assert.That(result, Is.EqualTo(expected));
    }

    [Test]
    public void Test_GetEvenWords_InputArrayWithOneOddLengthWord_ShouldReturnEmptyString()
    {
        // Arrange
        string[] words = new string[] { "abc" };
        string expected = string.Empty;

        // Act
        string result = EvenLengthWordsFilter.GetEvenWords(words);

        // Assert
        Assert.That(result, Is.EqualTo(expected));
    }

    [Test]
    public void Test_GetEvenWords_InputArrayOnlyWithOddLengthWords_ShouldReturnEmptyString()
    {
        // Arrange
        string[] words = new string[] { "abc", "omg", "zdr" };
        string expected = string.Empty;

        // Act
        string result = EvenLengthWordsFilter.GetEvenWords(words);

        // Assert
        Assert.That(result, Is.EqualTo(expected));
    }

    [Test]
    public void Test_GetEvenWords_InputArrayWithOneEvenLengthWord_ShouldReturnSameWord()
    {
        // Arrange
        string[] words = new string[] { "abcd" };
        string expected = "abcd";

        // Act
        string result = EvenLengthWordsFilter.GetEvenWords(words);

        // Assert
        Assert.That(result, Is.EqualTo(expected));
    }

    [Test]
    public void Test_GetEvenWords_InputArrayWithEvenAndOddLengthWords_ShouldReturnOnlyEvenLengthWords()
    {
        // Arrange
        string[] words = new string[] { "abcd", "omg", "zdr", "haha", "hello" };
        string expected = "abcd haha";

        // Act
        string result = EvenLengthWordsFilter.GetEvenWords(words);

        // Assert
        Assert.That(result, Is.EqualTo(expected));
    }
}

