sing Microsoft.Data.SqlClient;

SqlConnection connection = new SqlConnection("Server=.;Database=SoftUni;User Id=sa;Password=SoftUni!2021;MultipleActiveResultSets=true"); //connection string-a
connection.Open();

using (connection)
{
    //1. DataReader
    //string sql = "SELECT * FROM Employee";
}

