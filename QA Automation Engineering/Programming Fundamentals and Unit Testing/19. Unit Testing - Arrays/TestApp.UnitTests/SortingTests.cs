using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NUnit.Framework;

namespace TestApp.UnitTests;

public class SortingTests
{
    [Test]
    public void Test_ShallowAscendingSort_EmptyArrayParameter_ReturnsEmptyArray()
    {
        // Arrange
        double[] emptyArray = Array.Empty<double>();

        // Act
        double[] result = Sorting.ShallowAscendingSort(emptyArray);

        // Assert
        Assert.That(result, Is.Empty);
    }

    [Test]
    public void Test_DeepAscendingSort_EmptyArrayParameter_ReturnsEmptyArray()
    {
        // Arrange
        double[] emptyArray = Array.Empty<double>();

        // Act
        double[] result = Sorting.DeepAscendingSort(emptyArray);

        // Assert
        Assert.That(result, Is.Empty);
    }

    [Test]
    public void Test_ShallowAscendingSort_UnOrderedArrayParam_ReturnsAscendingOrderedArrayAndDoesNotChangeTheOriginalArray()
    {
        // Arrange
        double[] unsortedNumbers = new double[] { 3.5 , 2.2 , 1};

        double[] expectedSortedArray = new double[] { 1, 2.2, 3.5 };
        double[] expectedUnsortedArray = new double[] { 3.5, 2.2, 1 };

        // Act
        double[] result = Sorting.ShallowAscendingSort(unsortedNumbers);

        //Assert
        CollectionAssert.AreEqual(expectedSortedArray, result);
        CollectionAssert.AreEqual(expectedUnsortedArray, unsortedNumbers);
    }

    [Test]
    public void Test_DeepAscendingSort_UnOrderedArrayParam_ReturnsAscendingOrderedArrayAndDoesChangeTheOriginalArray()
    {
        // Arrange
        double[] unsortedNumbers = new double[] { 3.5, 2.2, 1 };

        double[] expectedSortedArray = new double[] { 1, 2.2, 3.5 };
        double[] unsortedNumbersAfterDeepSort = new double[] { 1, 2.2, 3.5 };

        // Act
        double[] result = Sorting.DeepAscendingSort(unsortedNumbers);

        // Assert
        CollectionAssert.AreEqual(expectedSortedArray, result);
        CollectionAssert.AreEqual(unsortedNumbersAfterDeepSort, unsortedNumbers);
    }
}
