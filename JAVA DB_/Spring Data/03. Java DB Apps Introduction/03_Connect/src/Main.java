import java.sql.*;


public class Main {
    public static void main(String[] args) throws SQLException {
        String host = "localhost";
        String port = "3306";
        String user = "";
        String pass = "";

        String url = String.format("jdbc:mysql://%s:%s/", host, port);

        Connection connection = DriverManager.getConnection(url, user, pass);

        String query = "SELECT COUNT(*) FROM soft_uni.employees";

        PreparedStatement prepareStatement = connection.prepareStatement(query);

        ResultSet resultSet = prepareStatement.executeQuery();

        System.out.println(resultSet);

        resultSet.next(); 
        int employeeCount = resultSet.getInt(1); 
        System.out.println(employeeCount);

        //Query 01
        PreparedStatement manyColumns = connection.prepareStatement("SELECT employee_id, first_name, salary FROM soft_uni.employees LIMIT 1");

        ResultSet manyColumnsResult = manyColumns.executeQuery();

        manyColumnsResult.next();
        int id = manyColumnsResult.getInt(1);
        String name = manyColumnsResult.getString(2); //getString
        float salary = manyColumnsResult.getFloat(3);

        System.out.println();

        //Query 02
        PreparedStatement manyRows =
                connection.prepareStatement("SELECT employee_id AS id, first_name, salary " +
                                "FROM soft_uni.employees LIMIT 10");
        ResultSet manyRowsResult = manyRows.executeQuery();

        while (manyRowsResult.next()) {
            System.out.printf("%d %s %f%n",
                    manyRowsResult.getInt("id"),
                    manyRowsResult.getString("first_name"),
                    manyRowsResult.getFloat("salary")
            );


        }


    }
}

