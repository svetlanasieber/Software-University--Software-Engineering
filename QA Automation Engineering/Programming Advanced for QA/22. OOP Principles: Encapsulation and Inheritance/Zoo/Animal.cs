namespace Zoo;

//BASE = PARENT = SUPER + CLASS -> клас, който ще бъде наследяван
//шаблон, в който ще описваме всяко едно животно
public class Animal
{
    //характеристики -> име
    //field
    private string name;

    //property
    public string Name { get; set; }


    //конструктор
    public Animal(string name)
    {
        //нов празен обект
        //name = null
        this.Name = name;
    }


}
