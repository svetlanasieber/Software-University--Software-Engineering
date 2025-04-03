import java.sql.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws SQLException {

        Properties properties = new Properties();
        properties.setProperty("user", "");
        properties.setProperty("password", "");
        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT name FROM villains");

        while (resultSet.next()) {
            String name = resultSet.getString("name");
            System.out.printf("%s%n", name);
        }
            System.out.println();
        }
    }

