import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Main {
    public static void main(String[] args) throws SQLException {
        String host = "localhost";
        String port = "3306";
        String user = "root";
        String pass = "12345";

        String url = String.format("jdbc:mysql://%s:%s/", host, port);

        Connection connection = DriverManager.getConnection(url, user, pass);

        String query = "SELECT COUNT(*) FROM soft_uni.employees";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();
        int employeeCount = resultSet.getInt(1);
        System.out.println(employeeCount);

        PreparedStatement manyColumns =
            connection.prepareStatement("SELECT employee_id, first_name, salary FROM soft_uni.employees LIMIT 1");
        ResultSet manyColumnsResult = manyColumns.executeQuery();

        manyColumnsResult.next();
        int id = manyColumnsResult.getInt(1);
        String name = manyColumnsResult.getString(2);
        float salary = manyColumnsResult.getFloat(3);

        PreparedStatement manyRows =
                connection.prepareStatement(
                        "SELECT employee_id AS id, first_name, salary " +
                        "FROM soft_uni.employees LIMIT 10");
        ResultSet manyRowsResult = manyRows.executeQuery();

        while (manyRowsResult.next()) {
            System.out.printf("%d %s %f%n",
                    manyRowsResult.getInt("id"),
                    manyRowsResult.getString("first_name"),
                    manyRowsResult.getFloat("salary")
            );
        }

        PreparedStatement emptyQuery =
                connection.prepareStatement(
                        "SELECT * FROM soft_uni.employees WHERE salary < -10");
        ResultSet emptyQueryResult = emptyQuery.executeQuery();

        boolean nextResult = emptyQueryResult.next();
        emptyQueryResult.getInt(1);
    }
}
