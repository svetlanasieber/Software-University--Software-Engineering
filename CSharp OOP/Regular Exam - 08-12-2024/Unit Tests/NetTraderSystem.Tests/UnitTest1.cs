using NUnit.Framework;
using System;
using System.Collections.Generic;
using NetTraderSystem;

namespace NetTraderSystem.Tests
{
    [TestFixture]
    public class TradingPlatformTests
    {
        private TradingPlatform platform;

        [SetUp]
        public void Setup()
        {

            platform = new TradingPlatform(5);
        }

        [Test]
        public void Constructor_ShouldInitializeCorrectly()
        {
            // Arrange & Act
            var platform = new TradingPlatform(10);

            // Assert
            Assert.AreEqual(0, platform.Products.Count);
            //Assert.AreEqual(10, platform.InventoryLimit);
        }

        [Test]
        public void AddProduct_ShouldAddProductSuccessfully()
        {
            // Arrange
            var product = new Product("Laptop", "Electronics", 1500);

            // Act
            var result = platform.AddProduct(product);

            // Assert
            Assert.AreEqual("Product Laptop added successfully", result);
            Assert.AreEqual(1, platform.Products.Count);
        }

        [Test]
        public void AddProduct_ShouldReturnInventoryFullMessage()
        {
            // Arrange
            for (int i = 0; i < 5; i++)
            {
                platform.AddProduct(new Product($"Product{i}", "Category", 100));
            }

            var product = new Product("ExtraProduct", "Category", 100);

            // Act
            var result = platform.AddProduct(product);

            // Assert
            Assert.AreEqual("Inventory is full", result);
            Assert.AreEqual(5, platform.Products.Count);
        }

        [Test]
        public void RemoveProduct_ShouldRemoveProductSuccessfully()
        {
            // Arrange
            var product = new Product("Laptop", "Electronics", 1500);
            platform.AddProduct(product);

            // Act
            var result = platform.RemoveProduct(product);

            // Assert
            Assert.IsTrue(result);
            Assert.AreEqual(0, platform.Products.Count);
        }

        [Test]
        public void RemoveProduct_ShouldReturnFalse_WhenProductNotFound()
        {
            // Arrange
            var product = new Product("NonExistent", "Category", 100);

            // Act
            var result = platform.RemoveProduct(product);

            // Assert
            Assert.IsFalse(result);
        }

        [Test]
        public void SellProduct_ShouldSellProductSuccessfully()
        {
            // Arrange
            var product = new Product("Phone", "Electronics", 800);
            platform.AddProduct(product);

            // Act
            var soldProduct = platform.SellProduct(product);

            // Assert
            Assert.AreEqual(product, soldProduct);
            Assert.AreEqual(0, platform.Products.Count);
        }

        [Test]
        public void SellProduct_ShouldReturnNull_WhenProductNotFound()
        {
            // Arrange
            var product = new Product("NonExistent", "Category", 100);

            // Act
            var result = platform.SellProduct(product);

            // Assert
            Assert.IsNull(result);
        }

        [Test]
        public void InventoryReport_ShouldReturnCorrectReport()
        {
            // Arrange
            platform.AddProduct(new Product("Laptop", "Electronics", 1500));
            platform.AddProduct(new Product("Phone", "Electronics", 800));

            // Act
            var report = platform.InventoryReport();

            // Assert
            StringAssert.Contains("Available Products: 2", report);
            StringAssert.Contains("Name: Laptop, Category: Electronics - $1500.00", report);
            StringAssert.Contains("Name: Phone, Category: Electronics - $800.00", report);
        }
    }
}
