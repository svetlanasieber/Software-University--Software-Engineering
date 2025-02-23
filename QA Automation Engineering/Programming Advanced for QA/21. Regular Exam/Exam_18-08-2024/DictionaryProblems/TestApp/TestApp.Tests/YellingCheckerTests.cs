using System;
using System.Linq;
using System.Text;
using NUnit.Framework;
using System.Threading.Tasks;
using System.Collections.Generic;
using static NUnit.Framework.Constraints.Tolerance;

namespace TestApp.Tests;

[TestFixture]
public class YellingCheckerTests
{
    [Test]
    public void Test_AnalyzeSentence_EmptyString_ReturnsEmptyDictionary()
    {
        // Arrange
        string input = string.Empty;

        // Act
        var result = YellingChecker.AnalyzeSentence(input);

        // Assert
        Assert.IsEmpty(result);
    }

    [Test]
    public void Test_AnalyzeSentence_OnlyUpperCaseWords_ReturnsDictionaryWithYellingEntriesOnly()
    {
        // Arrange
        string input = "HELLO WORLD!";

        // Act
        var result = YellingChecker.AnalyzeSentence(input);

        // Assert
        Assert.AreEqual(1, result.Count);
        Assert.IsTrue(result.ContainsKey("yelling"));
        Assert.AreEqual(2, result["yelling"]);
    }

    [Test]
    public void Test_AnalyzeSentence_OnlyLowerCaseWords_ReturnsDictionaryWithSpeakingLowerEntriesOnly()
    {
        // Arrange
        string input = "hello world.";

        // Act
        var result = YellingChecker.AnalyzeSentence(input);

        // Assert
        Assert.AreEqual(1, result.Count);
        Assert.IsTrue(result.ContainsKey("speaking lower"));
        Assert.AreEqual(2, result["speaking lower"]);
    }

    [Test]
    public void Test_AnalyzeSentence_OnlyMixedCaseWords_ReturnsDictionaryWithSpeakingNormalEntriesOnly()
    {
        // Arrange
        string input = "Hello World123"; 

        // Act
        var result = YellingChecker.AnalyzeSentence(input);

        // Assert
        Assert.AreEqual(1, result.Count);
        Assert.IsTrue(result.ContainsKey("speaking normal"));
        Assert.AreEqual(2, result["speaking normal"]);
    }

    [Test]
    public void Test_AnalyzeSentence_LowerUpperMixedCasesWords_ReturnsDictionaryWithAllTypeOfEntries()
    {
        // Arrange
        string input = "Unit TESTING is the 1st step!!!"; 

        // Act
        var result = YellingChecker.AnalyzeSentence(input);

        // Assert
        Assert.AreEqual(3, result.Count); 
        Assert.IsTrue(result.ContainsKey("yelling"));
        Assert.IsTrue(result.ContainsKey("speaking lower"));
        Assert.IsTrue(result.ContainsKey("speaking normal"));

        Assert.AreEqual(1, result["yelling"]);
        Assert.AreEqual(4, result["speaking lower"]);
        Assert.AreEqual(1, result["speaking normal"]);
    }
}

