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

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/soft_uni", user, pass);

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

        //UnsafeQuery -> SQL Injection
        //String unsafeQuery = "SELECT * FROM employees WHERE salary > ";
        //unsafeQuery += "10000"; // Good case
        //unsafeQuery = "1; SELECT * FROM users"; //Bad case
        //unsafeQuery = "1 OR 1 = 1"; //Bad case
        //unsafeQuery += "1; DROP TABLE users;"; //Bad case
        //SELECT * FROM users WHERE username = %s AND password = %s; //Bad case
        // username = pesho"; SELECT * FROM users WHERE role = admin //Bad case

        //ResultSet unsafeResult = connection.createStatement().executeQuery(unsafeQuery);

        //while (unsafeResult.next()) {
        //    System.out.printf("%id -> %s",
        //            unsafeResult.getInt("employee_id"),
        //            unsafeResult.getString("first_name")
        //    );
        
        }
    }

