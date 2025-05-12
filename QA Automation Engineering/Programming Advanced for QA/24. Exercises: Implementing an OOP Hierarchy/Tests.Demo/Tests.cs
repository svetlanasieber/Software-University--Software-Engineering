using ExerciseOopHierarchy;
using NUnit.Framework;

namespace Tests.Demo
{
	public class Tests
	{
		private Customer customer;
		private Restaurant restaurant;

		[SetUp]
		public void SetUp()
		{
			customer = new Customer("John Doe", "john@gmail.com");

			restaurant = new Restaurant();
		}

		[Test]
		public void Test_Customer_Constructor()
		{
			// Arrange
			string expectedName = "John Doe";
			string expectedMail = "john@gmail.com";

			// Act and Assert
			Assert.AreEqual(expectedName, customer.Name);
			Assert.AreEqual(expectedMail, customer.Email);
			Assert.AreEqual(0, customer.OrderHistory.Count);
			Assert.That(customer.OrderHistory is IReadOnlyCollection<Order>);
		}

		[Test]
		public void Test_Customer_AddOrder_WorkProperly()
		{
			// Arrange
			Order order1 = new Order();
			Order order2 = new Order();
			Order order3 = new Order();
			int expecterOrderCount = 3;

			// Act
			customer.AddOrder(order1);
			customer.AddOrder(order2);
			customer.AddOrder(order3);
			Order actualFirstOrder = customer.OrderHistory.First();

			// Assert
			Assert.AreEqual(expecterOrderCount, customer.OrderHistory.Count);
			Assert.AreEqual(order1, actualFirstOrder);
		}

		[Test]
		public void Test_Restaurant_GetMenuItem_WorkProperly() 
		{
			// Arrange
			MenuItem main = new MainCourseMenuItem("Pasta", "Delicious pasta dish", 12.99m);
			MenuItem appetizer = new AppetizerMenuItem("Salad", "Fresh garden salad", 7.99m);
			MenuItem dessert = new DessertMenuItem("Cheesecake", "Creamy cheesecake", 5.99m);
			restaurant.AddMenuItem(main);
			restaurant.AddMenuItem(appetizer);
			restaurant.AddMenuItem(dessert);

			// Act
			MenuItem actualItem = restaurant.GetMenuItem(1);

			// Assert
			Assert.AreEqual(appetizer.Name, actualItem.Name);
			Assert.AreEqual(appetizer.Description, actualItem.Description);
			Assert.AreEqual(appetizer.Price, actualItem.Price);
		}

		[Test]
		[TestCase(-1)]
		[TestCase(3)]
		[TestCase(8)]
		public void Test_Restaurant_GetMenuItem_ThrowIndexOutOfRangeException(int index)
		{
			// Arrange
			MenuItem main = new MainCourseMenuItem("Pasta", "Delicious pasta dish", 12.99m);
			MenuItem appetizer = new AppetizerMenuItem("Salad", "Fresh garden salad", 7.99m);
			MenuItem dessert = new DessertMenuItem("Cheesecake", "Creamy cheesecake", 5.99m);
			restaurant.AddMenuItem(main);
			restaurant.AddMenuItem(appetizer);
			restaurant.AddMenuItem(dessert);

			// Act and Assert
			Assert.Throws<IndexOutOfRangeException>(() => restaurant.GetMenuItem(index));
		}
	}
}
