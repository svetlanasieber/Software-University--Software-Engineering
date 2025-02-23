using System;
using System.Text;
using System.Linq;
using NUnit.Framework;
using System.Collections.Generic;

namespace TestApp.Tests;

[TestFixture]
public class CargoManagementSystemTests
{
    [Test]
    public void Test_Constructor_CheckInitialEmptyCargoCollectionAndCount()
    {
        // Arrange and Act
        var cargoSystem = new CargoManagementSystem();

        // Assert
        Assert.AreEqual(0, cargoSystem.CargoCount);
        CollectionAssert.IsEmpty(cargoSystem.GetAllCargos());
    }

    [Test]
    public void Test_AddCargo_ValidCargoName_AddNewCargo()
    {
        // Arrange
        var cargoSystem = new CargoManagementSystem();
        string cargo = "Cargo1";

        // Act
        cargoSystem.AddCargo(cargo);

        // Assert
        Assert.AreEqual(1, cargoSystem.CargoCount);
        CollectionAssert.Contains(cargoSystem.GetAllCargos(), cargo);
    }

    [Test]
    public void Test_AddCargo_NullOrEmptyCargoName_ThrowsArgumentException()
    {
        // Arrange
        var cargoSystem = new CargoManagementSystem();

        // Act and Assert
        Assert.Throws<ArgumentException>(() => cargoSystem.AddCargo(null));
        Assert.Throws<ArgumentException>(() => cargoSystem.AddCargo(string.Empty));
        Assert.Throws<ArgumentException>(() => cargoSystem.AddCargo("   "));
    }

    [Test]
    public void Test_RemoveCargo_ValidCargoName_RemoveFirstCargoName()
    {
        // Arrange
        var cargoSystem = new CargoManagementSystem();
        string cargo1 = "Cargo1";
        string cargo2 = "Cargo2";
        cargoSystem.AddCargo(cargo1);
        cargoSystem.AddCargo(cargo2);

        // Act
        cargoSystem.RemoveCargo(cargo1);

        // Assert
        Assert.AreEqual(1, cargoSystem.CargoCount);
        CollectionAssert.DoesNotContain(cargoSystem.GetAllCargos(), cargo1);
    }

    [Test]
    public void Test_RemoveCargo_NullOrEmptyCargoName_ThrowsArgumentException()
    {
        // Arrange
        var cargoSystem = new CargoManagementSystem();

        // Act and Assert
        Assert.Throws<ArgumentException>(() => cargoSystem.RemoveCargo("Cargo1")); 
        Assert.Throws<ArgumentException>(() => cargoSystem.RemoveCargo(null));
        Assert.Throws<ArgumentException>(() => cargoSystem.RemoveCargo(string.Empty));
    }

    [Test]
    public void Test_GetAllCargos_AddedAndRemovedCargos_ReturnsExpectedCargoCollection()
    {
        // Arrange
        var cargoSystem = new CargoManagementSystem();
        string cargo1 = "Cargo1";
        string cargo2 = "Cargo2";
        string cargo3 = "Cargo3";

        cargoSystem.AddCargo(cargo1);
        cargoSystem.AddCargo(cargo2);
        cargoSystem.AddCargo(cargo3);

        // Act
        cargoSystem.RemoveCargo(cargo2);
        List<string> result = cargoSystem.GetAllCargos();

        // Assert
        Assert.AreEqual(2, cargoSystem.CargoCount);
        CollectionAssert.AreEquivalent(new List<string> { cargo1, cargo3 }, result);
    }
}


    