using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NUnit.Framework;

namespace TestApp.UnitTests;

public class ListManipulationTests
{
    [Test]
    public void Test_RemoveNegativesAndReverse_EmptyListInput_ReturnEmptyList()
    {
        //Arrange
        List<int> emptyList = new List<int>();

        //Act
        List<int> resultList = ListManipulation.RemoveNegativesAndReverse(emptyList);

        //Assert
        CollectionAssert.IsEmpty(resultList);
    }

    [Test]
    public void Test_RemoveNegativesAndReverse_OnlyNegativeNumbers_ReturnEmptyList()
    {
        //Arrange
        List<int> negativeNumbers = new List<int> { -3, -4, -5, -12, -16 };

        //Act
        List<int> resultList = ListManipulation.RemoveNegativesAndReverse(negativeNumbers);

        //Assert
        CollectionAssert.IsEmpty(resultList);
    }

    [Test]
    public void Test_RemoveNegativesAndReverse_OnlyOnePositiveNumber_ReturnSameCollection()
    {
        //Arrange
        List<int> listWithOnePositiveNumber = new List<int> { 9 };

        //Act
        List<int> resultList = ListManipulation.RemoveNegativesAndReverse(listWithOnePositiveNumber);

        //Assert
        CollectionAssert.AreEqual(listWithOnePositiveNumber, resultList);
    }

    [Test]
    public void Test_RemoveNegativesAndReverse_OnlyPositiveNumbers_ReturnRevursedList()
    {
        //Arrange
        List<int> listWithPositiveNumbers = new List<int> { 1, 2, 3, 4, 5 };
        List<int> expectedList = new List<int> { 5, 4, 3, 2, 1 };

        //Act
        List<int> resultList = ListManipulation.RemoveNegativesAndReverse(listWithPositiveNumbers);

        //Assert
        CollectionAssert.AreEqual(expectedList, resultList);
    }

    [Test]
    public void Test_RemoveNegativesAndReverse_PostiveAndNegativeElements_ReturnPositiveNumbersInReversedOrder()
    {
        //Arrange
        List<int> numbers = new List<int> { 4, -5, 6, -3, 2, 5, 19, -87 };
        List<int> expectedList = new List<int> { 19, 5, 2, 6, 4 };

        //Act
        List<int> resultList = ListManipulation.RemoveNegativesAndReverse(numbers);

        //Assert
        CollectionAssert.AreEqual(expectedList, resultList);
    }
}
