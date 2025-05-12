
namespace ExerciseOopHierarchy
{
	public class DessertMenuItem : MenuItem
	{
		public DessertMenuItem(string name, string description, decimal price) 
			: base(name, description, price)
		{
		}

		public override string ToString()
		{
			return $"Dessert: {base.ToString()}";
		}
	}
}
