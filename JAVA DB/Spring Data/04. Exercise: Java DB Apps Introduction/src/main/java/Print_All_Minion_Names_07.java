import java.sql.*;
import java.util.Properties;

public class Print_All_Minion_Names_07 {
    public static void main(String[] args) throws SQLException {

        Connection connection = getConnection("root", "denis");

        int firstIndex = 1;
        int lastIndex = getLastIndex(connection);

        for (int index = 0; index < lastIndex / 2; index++) {
            print(connection, firstIndex + index);

            print(connection, lastIndex - index);
        }

        connection.close();
    }

    private static void print(Connection connection, int i) throws SQLException {
        PreparedStatement firstHalfElements = connection.prepareStatement(
                "SELECT name FROM minions WHERE id = ?;");
        firstHalfElements.setInt(1, i);
        ResultSet firstHalfSet = firstHalfElements.executeQuery();
        firstHalfSet.next();
        System.out.println(firstHalfSet.getString("name"));
    }

    private static int getLastIndex(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT COUNT(name) AS count FROM minions;");
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        return resultSet.getInt("count");
    }

    private static Connection getConnection(String username, String password) throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", username);
        properties.setProperty("password", password);

        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);
        return connection;
    }
}
