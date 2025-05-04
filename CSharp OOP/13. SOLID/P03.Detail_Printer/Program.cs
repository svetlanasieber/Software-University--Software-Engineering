using P03.Detail_Printer.Models;
using P03.Detail_Printer.Models.Interfaces;
using System.Collections.Generic;

namespace P03.DetailPrinter;

class Program
{
    static void Main()
    {
        List<IEmployee> employees = new();

        employees.Add(new Employee("George"));
        employees.Add(new Manager("Peter", new List<string> { "CV", "Contract", "Diploma" }));

        DetailsPrinter printer = new(employees);

        printer.PrintDetails();
    }
}
