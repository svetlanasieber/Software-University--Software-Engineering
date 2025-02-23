using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NUnit.Framework;

namespace TestApp.UnitTests;

public class IgnoreTheCharsTests
{
    [Test]
    public void Test_IgnoreChars_EmptyStringSentence_ReturnsEmptyString()
    {
        //Arrange
        string sentence = "";
        List<char> ignoreChars = new List<char> { 'a', 'e' };

        //Act
        string resultSentence = IgnoreTheChars.IgnoreChars(sentence, ignoreChars);

        //Assert
        Assert.AreEqual(sentence, resultSentence);
    }

    [Test]
    public void Test_IgnoreChars_EmptyList_ReturnsSameSentence()
    {
        //Arrange
        string sentence = "Desi is 26 years old.";
        List<char> ignoreChars = new List<char>();

        //Act
        string resultSentence = IgnoreTheChars.IgnoreChars(sentence, ignoreChars);

        //Assert
        Assert.AreEqual(sentence, resultSentence);
    }

    [Test]
    public void Test_IgnoreChars_OneCharSentenceAndSameCharsForIgnoring_ReturnsEmptyString()
    {
        //Arrange
        string sentence = "d";
        List<char> ignoreChars = new List<char> { 'd' };
        string expectedSentence = "";

        //Act
        string resultSentence = IgnoreTheChars.IgnoreChars(sentence, ignoreChars);

        //Assert
        Assert.AreEqual(expectedSentence, resultSentence);
    }

    [Test]
    public void Test_IgnoreChars_WholeSentenceAndFewCharsToIgnore_ReturnsCorrectString()
    {
        // Arrange
        string sentence = "Desi is 26 years old.";
        List<char> ignoreChars = new List<char> { 'a', 'e', '.' };
        string expectedSentence = "Dsi is 26 yrs old";

        //Act
        string resultSentence = IgnoreTheChars.IgnoreChars(sentence, ignoreChars);

        //Assert
        Assert.AreEqual(expectedSentence, resultSentence);

    }
}
