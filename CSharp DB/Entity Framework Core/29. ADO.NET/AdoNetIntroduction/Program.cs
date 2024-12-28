using Microsoft.Data.SqlClient;

SqlConnection connection = new SqlConnection("Server=.;Database=SoftUni;User Id=sa;Password=SoftUni!2021;MultipleActiveResultSets=true;Trust Server Certificate=true"); //connection string-a
connection.Open();

using (connection)
{
   
    SqlCommand command = new SqlCommand("SELECT COUNT(*) FROM Empleyees", connection);
    int? employeesCount = (int?) await command.ExecuteScalarAsync(); //ExecuteScalar vrushta edin resultat. Asynchronous method

    Console.WriteLine($"There are {employeesCount} employees in our company");
}

