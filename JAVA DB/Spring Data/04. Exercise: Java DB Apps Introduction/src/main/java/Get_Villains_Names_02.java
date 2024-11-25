import java.sql.*;
import java.util.Properties;

public class Get_Villains_Names_02 {
    public static void main(String[] args) throws SQLException {

        Connection connection = getConnection("root", "denis");

        PreparedStatement statement = connection.prepareStatement
                ("SELECT" +
                        " name," +
                        " COUNT(DISTINCT mv.minion_id) AS minion_count" +
                        " FROM villains AS v" +
                        " JOIN minions_villains AS mv ON mv.villain_id = v.id" +
                        " GROUP BY mv.villain_id" +
                        " HAVING minion_count > 15" +
                        " ORDER BY minion_count DESC;");

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String villainName = resultSet.getString("name");
            int minionCount = resultSet.getInt("minion_count");
            System.out.println(villainName + " " + minionCount);
        }

        connection.close();
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
