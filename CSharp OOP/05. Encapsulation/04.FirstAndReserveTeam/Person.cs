using System;

namespace PersonsInfo;

public class Person
{
    private string firstName;
    private string lastName;
    private int age;
    private decimal salary;

    public Person(string firstName, string lastName, int age, decimal salary)
    {
        FirstName = firstName;
        LastName = lastName;
        Age = age;
        Salary = salary;
    }

    public string FirstName
    {
        get
        {
            return firstName;
        }
        private set
        {
            if (value != null && value.Length < 3)
            {
                throw new ArgumentException("First name cannot contain fewer than 3 symbols!");
            }

            firstName = value;
        }
    }

    public string LastName
    {
        get
        {
            return lastName;
        }
        private set
        {
            if (value != null && value.Length < 3)
            {
                throw new ArgumentException("Last name cannot contain fewer than 3 symbols!");
            }

            lastName = value;
        }
    }

    public int Age
    {
        get
        {
            return age;
        }
        private set
        {
            if (value <= 0)
            {
                throw new ArgumentException("Age cannot be zero or a negative integer!");
            }

            age = value;
        }
    }

    public decimal Salary
    {
        get
        {
            return salary;
        }
        private set
        {
            salary = value;
        }
    }

    public void IncreaseSalary(decimal percentage)
    {
        if (Age < 30)
        {
            percentage /= 2;
        }

        Salary += Salary * percentage / 100;
    }

    public override string ToString() => $"{FirstName} {LastName} receives {Salary:f2} leva.";
}
