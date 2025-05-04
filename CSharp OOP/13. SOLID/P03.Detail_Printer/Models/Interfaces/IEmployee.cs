namespace P03.Detail_Printer.Models.Interfaces;
public interface IEmployee
{
    string Name { get; set; }

    string GetDetails();
}
