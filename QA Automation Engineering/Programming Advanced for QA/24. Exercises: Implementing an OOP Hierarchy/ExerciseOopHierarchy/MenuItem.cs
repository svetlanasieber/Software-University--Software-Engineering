namespace ExerciseOopHierarchy;

public abstract class MenuItem
{
    public MenuItem(string name, string description, decimal price)
	{
		Name = name;
		Description = description;
		Price = price;
	}

	public string Name { get; set; }

    public string Description { get; set; }

    public decimal Price { get; set; }

	public override string ToString()
	{
		return $"{this.Name} - {this.Description} - ${this.Price}";
	}
}



