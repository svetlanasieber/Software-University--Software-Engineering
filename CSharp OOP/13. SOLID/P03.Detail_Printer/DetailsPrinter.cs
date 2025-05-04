using P03.Detail_Printer.Models.Interfaces;
using System;
using System.Collections.Generic;

namespace P03.DetailPrinter;

public class DetailsPrinter
{
    private IList<IEmployee> employees;

    public DetailsPrinter(IList<IEmployee> employees)
    {
        this.employees = employees;
    }

    public void PrintDetails()
    {
        foreach (IEmployee employee in employees)
        {
            Console.WriteLine(employee.GetDetails());
        }
    }

    //private void PrintEmployee(Employee employee)
    //{
    //    Console.WriteLine(employee.Name);
    //}

    //private void PrintManager(Manager manager)
    //{
    //    Console.WriteLine(manager.Name);
    //    Console.WriteLine(string.Join(Environment.NewLine, manager.Documents));
    //}
}
