using NUnit.Framework;
using System.Collections.Generic;

namespace TestApp.Tests
{
    [TestFixture]
    public class ConsonantsCounterTests
    {
        [Test]
        public void Test_CountTotalConsonants_GetEmptyList_ReturnsZero()
        {
            // Arrange
            List<string> words = new List<string>();
            // Act
            int result = ConsonantsCounter.CountTotalConsonants(words);
            // Assert
            Assert.AreEqual(0, result);
        }

        [Test]
        public void Test_CountTotalConsonants_GetListWithEmptyStringValues_ReturnsZero()
        {
            // Arrange
            List<string> words = new List<string> { "", "", "" };
            // Act
            int result = ConsonantsCounter.CountTotalConsonants(words);
            // Assert
            Assert.AreEqual(0, result);
        }

        [Test]
        public void Test_CountTotalConsonants_MultipleStrings_ReturnsConsonantsCount()
        {
            // Arrange
            List<string> words = new List<string> { "hello", "world", "csharp" };

            // Act
            int result = ConsonantsCounter.CountTotalConsonants(words);

       

            // Assert 
            Assert.That(result, Is.EqualTo(12));
        }

        [Test]
        public void Test_CountTotalConsonants_GetStringsWithNoConsonants_ReturnsZero()
        {
            // Arrange
            List<string> words = new List<string> { "aeiou", "AEIOU" };
            // Act
            int result = ConsonantsCounter.CountTotalConsonants(words);
            // Assert
            Assert.AreEqual(0, result);
        }

        [Test]
        public void Test_CountTotalConsonants_StringsWithMixedCaseConsonants_ReturnsConsonantsCount()
        {
            // Arrange
            List<string> words = new List<string> { "SoftUni", "NUnit", "Test" };
            // Act
            int result = ConsonantsCounter.CountTotalConsonants(words);
            // Assert
            Assert.AreEqual(10, result);
        }
    }

}

