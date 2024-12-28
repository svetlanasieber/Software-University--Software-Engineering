using Microsoft.Data.SqlClient;

SqlConnection connection = new SqlConnection("Server=.;Database=SoftUni;User Id=sa;Password=SoftUni!2021;MultipleActiveResultSets=true;Trust Server Certificate=true"); //connection string-a
connection.Open();

using (connection)
{
   
    SqlCommand command = new SqlCommand("SELECT * FROM WHERE DepartmentID", connection);
    SqlDataReader reader = command.ExecuteReader();

    using (reader)
    {

        while (reader.Read())
        {
            string? name = reader["FirstName"]?.ToString();
            string lastName = reader[2]?.ToString();

            Console.WriteLine($"{name} {lastName}");
        }
    }

}

