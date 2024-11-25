import java.sql.*;
import java.util.Arrays;
import java.util.Properties;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Increase_Minions_Age_08 {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String [] minionsIds = scanner.nextLine().split("\\s+");

        Connection connection = getConnection("root", "denis");

        for (String minionsId : minionsIds) {
            PreparedStatement updateMinionsNames = connection.prepareStatement
                    ("UPDATE minions" +
                            " SET name = LOWER(name)" +
                            " WHERE id = ?;");
            updateMinionsNames.setString(1, minionsId);
            updateMinionsNames.executeUpdate();
        }

        for (String minionsId : minionsIds) {
            PreparedStatement updateMinionsAges = connection.prepareStatement
                    ("UPDATE minions" +
                            " SET age = age + 1" +
                            " WHERE id = ?;");
            updateMinionsAges.setString(1, minionsId);
            updateMinionsAges.executeUpdate();
        }

        checkResult(connection, minionsIds);

        connection.close();
    }

    private static void checkResult(Connection connection, String [] minion_ids) throws SQLException {
        String ids = Arrays.stream(minion_ids).collect(Collectors.joining(","));
        String statement = String.format("SELECT" +
                " name," +
                " age" +
                " FROM minions" +
                " WHERE id IN (%s)", ids);
        PreparedStatement prepareStatement = connection.prepareStatement(statement);
        ResultSet resultSet = prepareStatement.executeQuery();
        while (resultSet.next()) {
            String minionName = resultSet.getString("name");
            int minionAge = resultSet.getInt("age");
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
