namespace TestApp;

public class CargoManagementSystem
{
    private List<string> cargos = new List<string>();
    public int CargoCount => cargos.Count;

    public void AddCargo(string cargo)
    {
        if(string.IsNullOrWhiteSpace(cargo))
        {
            throw new ArgumentException("Cargo cannot be empty or whitespace.");
        }
        cargos.Add(cargo);
    }

    public void RemoveCargo(string cargo)
    {
        if (!cargos.Contains(cargo))
        {
            throw new ArgumentException("Cargo not found in the system.");
        }
        cargos.Remove(cargo);
    }

    public List<string> GetAllCargos()
    {
        return new List<string>(cargos);
    }
}
