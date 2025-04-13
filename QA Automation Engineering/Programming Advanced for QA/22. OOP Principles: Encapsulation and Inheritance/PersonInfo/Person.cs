using System;

namespace PersonInfo;

//шаблон, в който описваме всеки един човек
public class Person
{
    //1. характеристики (име, фамилия, възраст) -> fields + properties / properties

    //fields -> съхранява стойността на харакатеристиката
    private string firstName;
    private string lastName;
    private int age;

    //properties -> осигуряваме контролиран достъп до стойностите на полетата
    //метод get -> връща стойността на характеристиката
    //метод set -> задаваме стойност на характеристиката

    public string FirstName
    {
        get //изпълнява се, когато обект.пропърти: person.FirstName
        {
           return this.firstName; 
        }

        set //изпълнява се, когато обект.пропърти = : person.FirstName = "Desi";
        {
            //вградена променилива value, в която съхраняваме стойността след знака =
            //във value съхраняваме стойността, която ще задаваме на полето
            if (value.Length < 3)
            {
                //невалидна стойност
                throw new ArgumentException("First name cannot contain fewer than 3 symbols!");
            }
            //value.Lenght >= 3 -> валидна стойност
            this.firstName = value;      
        }
    }

    public string LastName
    {
        get
        {
            return this.lastName;
        }
        set
        {
            if (value.Length < 3)
            {
                throw new ArgumentException("Last name cannot contain fewer than 3 symbols!");
            }
            this.lastName = value;

        }
    }

    public int Age
    {
        get
        {
            return this.age;
        }
        set
        {
            if (value <= 0)
            {
                //невалидни данни
                throw new ArgumentException("Age cannot be zero or a negative integer!");
            }
            this.age = value;
        }
    }


    //2. конструктор

    //2.1. default / вграден
    public Person()
    {
        //нов празен обект
        //firstName = null
        //lastName = null
        //age = 0

    }

    //2.2. custom / ръчно създаден
    public Person (string firstName, string lastName, int age)
    {
        //нов празен обект
        //firstName = null
        //lastName = null
        //age = 0

        this.FirstName = firstName; //задаваме стойност на полето чрез property!!!
        this.LastName = lastName;
        this.Age = age;
    }


    //3. методи

    //3.1. вградени методи -> ToString
    //ToString -> дава обекта под формата на текст -> "{namespace}.{class}"
    public override string ToString()
    {
        //default behavior: return "{namespace}.{class}";
        return $"{this.FirstName} {this.LastName} is {this.Age} years old.";
    }
}
