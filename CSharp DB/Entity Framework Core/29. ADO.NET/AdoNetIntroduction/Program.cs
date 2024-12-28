using Microsoft.Data.SqlClient;

SqlConnection connection = new SqlConnection("Server=.;Database=SoftUni;User Id=sa;Password=SoftUni!2021;MultipleActiveResultSets=true;Trust Server Certificate=true"); //connection string-a
connection.Open();

using (connection)
{
    //1. DataReader
    //string sql = "SELECT * FROM Employee";

    
    SqlCommand command = new SqlCommand("SELECT COUNT(*) FROM Empleyees", connection);
    int? employeesCount = (int?) await command.ExecuteScalarAsync(); //Asynchronous method

    Console.WriteLine($"There are {employeesCount} employees in our company");
}

/*
//Async/await Pattern => Asynchronous programming with async and await
public async Task Main(string args)
{

}
*/
