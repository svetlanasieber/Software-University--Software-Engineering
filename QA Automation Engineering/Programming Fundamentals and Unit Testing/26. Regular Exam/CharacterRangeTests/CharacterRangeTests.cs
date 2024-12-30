using NUnit.Framework;
using System;

namespace TestApp.Tests;

public class CharacterRangeTests
{
    [Test]
    public void Test_GetRange_WithAAndBInOrder_ReturnsEmptyString()
    {
        
        char a = 'A';
        char b = 'B';

        
        string result = CharacterRange.GetRange(a, b);

        
        Assert.AreEqual("", result);
    }

    [Test]
    public void Test_GetRange_WithBAndAInOrder_ReturnsEmptyString()
    {
        
        char a = 'B';
        char b = 'A';

        
        string result = CharacterRange.GetRange(a, b);

        
        Assert.AreEqual("", result);
    }

    [Test]
    public void Test_GetRange_WithAAndCInOrder_ReturnsB()
    {
        
        char a = 'A';
        char b = 'C';

        
        string result = CharacterRange.GetRange(a, b);

        
        Assert.AreEqual("B", result);
    }

    [Test]
    public void Test_GetRange_WithDAndGInOrder_Returns_E_F()
    {
        
        char a = 'D';
        char b = 'G';

        
        string result = CharacterRange.GetRange(a, b);

       
        Assert.AreEqual("E F", result);
    }

    [Test]
    public void Test_GetRange_WithXAndZInOrder_Returns_Y()
    {
        {
            
            char a = 'X';
            char b = 'Z';

            
            string result = CharacterRange.GetRange(a, b);

            
            Assert.AreEqual("Y", result);
        }
    }
}
