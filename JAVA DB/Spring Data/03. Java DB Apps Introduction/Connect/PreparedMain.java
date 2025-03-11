import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedMain {

    public static void main(String[] args) throws SQLException {
        String host = "localhost";
        String port = "3306";
        String user = "root";
        String pass = "12345";

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/soft_uni", user, pass);

        String query = "SELECT * FROM employees WHERE first_name LIKE ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, "%gu%");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.printf("%d -> %s",
                    resultSet.getInt("employee_id"),
                    resultSet.getString("first_name")
            );
        }

        String unsafeQuery = "SELECT * FROM employees WHERE salary > ";
//        unsafeQuery += "10000"; // Good case
//        unsafeQuery += "1 OR 1 = 1"; // Bad case
//        unsafeQuery += "1; SELECT * FROM users;"; // Bad case
//        unsafeQuery += "1; DROP TABLE users;"; // Bad case
//      SELECT * FROM users WHERE username = "%s" AND password = "%s";
//        username = pesho"; SELECT * FROM users WHERE role = admin;
        ResultSet unsafeResult = connection.createStatement().executeQuery(unsafeQuery);

        while (unsafeResult.next()) {
            System.out.printf("%d -> %s",
                    unsafeResult.getInt("employee_id"),
                    unsafeResult.getString("first_name")
            );
        }
    }
}
