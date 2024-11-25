import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Increase_Age_Stored_Procedure_09 {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        int minionId = Integer.parseInt(scanner.nextLine());

        Connection connection = getConnection("root", "denis");

        check(connection, minionId);

        CallableStatement statement = connection.prepareCall("call usp_get_older(?)");
        statement.setInt(1, minionId);
        statement.execute();

        check(connection, minionId);

        connection.close();
    }

    private static void check(Connection connection, int minionId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement
                ("SELECT" +
                        " name," +
                        " age" +
                        " FROM minions" +
                        " WHERE id = ?;");
        statement.setInt(1, minionId);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String minionName = resultSet.getString("name");
            int minionAge= resultSet.getInt("age");
            System.out.println(minionName + " " + minionAge);
        }
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
