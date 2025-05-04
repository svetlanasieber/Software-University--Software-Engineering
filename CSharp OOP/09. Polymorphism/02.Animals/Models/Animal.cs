namespace Animals.Models;

public abstract class Animal
{
    protected Animal(string name, string favouriteFood)
    {
        Name = name;
        FavouriteFood = favouriteFood;
    }

    public string Name { get; private set; }

    public string FavouriteFood { get; private set; }

    public virtual string ExplainSelf() => $"I am {Name} and my favourite food is {FavouriteFood}";
}
