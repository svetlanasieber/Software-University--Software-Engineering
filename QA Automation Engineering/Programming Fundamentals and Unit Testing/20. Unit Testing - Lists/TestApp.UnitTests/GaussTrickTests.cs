using NUnit.Framework;

using System.Collections.Generic;

namespace TestApp.UnitTests;

public class GaussTrickTests
{
    [Test]
    public void Test_SumPairs_InputIsEmptyList_ShouldReturnEmptyList()
    {
        //Arrange
        List<int> emptyList = new();

        //Act
        List<int> resultList = GaussTrick.SumPairs(emptyList);

        //Assert
        CollectionAssert.IsEmpty(resultList);
    }


    [Test]
    public void Test_SumPairs_InputHasSingleElement_ShouldReturnSameElement()
    {
        //Arrange
        List<int> listWithSingleElement = new List<int> { 8 };

        //Act
        List<int> resultList = GaussTrick.SumPairs(listWithSingleElement);

        //Assert
        CollectionAssert.AreEqual(listWithSingleElement, resultList);

    }


    [Test]
    public void Test_SumPairs_InputHasEvenCountElements_ShouldReturnSumPairs()
    {
        //Arrange
        List<int> numbers = new List<int> { 1, 2, 3, 4 };
        List<int> expectedList = new List<int> { 5, 5 };

        //Act
        List<int> resultList = GaussTrick.SumPairs(numbers);

        //Assert
        CollectionAssert.AreEqual(expectedList, resultList);
    }

    [Test]
    public void Test_SumPairs_InputHasOddCountElements_ShouldReturnWithMiddleElement()
    {
        //Arrange
        List<int> numbers = new List<int> { 1, 2, 3, 4, 5 };
        List<int> expectedList = new List<int> { 6, 6, 3 };

        //Act
        List<int> resultList = GaussTrick.SumPairs(numbers);

        //Assert
        CollectionAssert.AreEqual(expectedList, resultList);
    }

    [Test]
    public void Test_SumPairs_InputHasLargeEvenCountElements_ShouldReturnSumPairs()
    {
        //Arrange
        List<int> numbers = new List<int> { 1, 2, 3, 4, 5, 6, 7, 8 , 9, 10 };
        List<int> expectedList = new List<int> { 11, 11, 11, 11, 11 };

        //Act
        List<int> resultList = GaussTrick.SumPairs(numbers);

        //Assert
        CollectionAssert.AreEqual(expectedList, resultList);
    }

    [Test]
    public void Test_SumPairs_InputHasLargeOddCountElements_ShouldReturnWithMiddleElement()
    {
        //Arrange
        List<int> numbers = new List<int> { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
        List<int> expectedList = new List<int> { 12, 12, 12, 12, 12, 6 };

        //Act
        List<int> resultList = GaussTrick.SumPairs(numbers);

        //Assert
        CollectionAssert.AreEqual(expectedList, resultList);
    }
}
