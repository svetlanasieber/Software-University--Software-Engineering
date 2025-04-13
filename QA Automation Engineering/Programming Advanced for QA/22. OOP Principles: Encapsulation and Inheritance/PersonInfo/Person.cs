using System;

namespace PersonInfo;


public class Person
{
    private string firstName;
    private string lastName;
    private int age;


    public string FirstName
    {
        get 
        {
           return this.firstName; 
        }

        set
        {

            if (value.Length < 3)
            {
                
                throw new ArgumentException("First name cannot contain fewer than 3 symbols!");
            }
      
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
               
                throw new ArgumentException("Age cannot be zero or a negative integer!");
            }
            this.age = value;
        }
    }

    public Person()
    {


    }


    public Person (string firstName, string lastName, int age)
    {


        this.FirstName = firstName; 
        this.LastName = lastName;
        this.Age = age;
    }

    public override string ToString()
    {
        return $"{this.FirstName} {this.LastName} is {this.Age} years old.";
    }
}
