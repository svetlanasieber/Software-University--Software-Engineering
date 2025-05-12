using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExerciseOopHierarchy
{
	public class Order
	{
		private List<MenuItem> _items;

		public Order()
		{
			_items = new List<MenuItem>();
		}

		public IReadOnlyCollection<MenuItem> Items => _items.AsReadOnly();
		

        public void AddItem(MenuItem item)
		{
			_items.Add(item);
		}

		public decimal GetTotal()
		{
			decimal total = 0;
			foreach (MenuItem item in _items)
			{
				total += item.Price;
			}

			return total;
		}
	}
}
