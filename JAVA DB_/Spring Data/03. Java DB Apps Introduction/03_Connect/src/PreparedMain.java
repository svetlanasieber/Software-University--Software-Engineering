import java.sql.*;

public class PreparedMain {
    public static void main(String[] args) throws SQLException {

        String host = "localhost";
        String port = "3306";
        String user = "";
        String pass = "";

        //jdbc connection string
        //from demo: Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/soft_uni", props);
        // String url = String.format("jdbc:mysql://%s:%s/dbName", host, port);

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/soft_uni", user, pass);

        String query = "SELECT * FROM employees WHERE first_name LIKE ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, "%gu%");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.printf("%id -> %s",
                    resultSet.getInt("employee_id"),
                    resultSet.getString("first_name")
            );

        }
    }
}
