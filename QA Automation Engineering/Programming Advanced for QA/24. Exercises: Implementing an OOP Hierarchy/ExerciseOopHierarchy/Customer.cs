using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExerciseOopHierarchy
{
	public class Customer
	{
		private List<Order> _orderHistory;

		public Customer(string name, string email)
		{
			Name = name;
			Email = email;
			_orderHistory = new List<Order>();
		}

		public string Name { get; set; }

        public string Email { get; set; }

        public IReadOnlyCollection<Order> OrderHistory => _orderHistory.AsReadOnly();

		public void AddOrder(Order order)
		{
			_orderHistory.Add(order);
		}

	}
}


