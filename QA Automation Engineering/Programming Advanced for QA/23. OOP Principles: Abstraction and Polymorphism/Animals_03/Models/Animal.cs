namespace Animals.Models;


public abstract class Animal
{

    private string name;
    private string favouriteFood;

    public string Name { get; set; }
    public string FavouriteFood { get; set;}


    public Animal(string name, string favouriteFood)
    {
        this.Name = name;
        this.FavouriteFood = favouriteFood;
    }


    public abstract void ExplainSelf();
}
