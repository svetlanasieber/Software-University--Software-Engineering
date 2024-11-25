import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Get_Minion_Names_03 {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Connection connection = getConnection("root", "denis");

        int villainId = Integer.parseInt(scanner.nextLine());
        PreparedStatement villainStatement = connection.prepareStatement
                ("SELECT name" +
                        " FROM villains" +
                        " WHERE id = ?;");
        villainStatement.setInt(1, villainId);

        ResultSet villainSet = villainStatement.executeQuery();
        if (!villainSet.next()) {
            System.out.printf("No villain with ID %d exists in the database.", villainId);
            return;
        }

        String villainName = villainSet.getString("name");
        System.out.println("Villain: " + villainName);

        PreparedStatement minionStatement = connection.prepareStatement
                ("SELECT" +
                        " m.name," +
                        " m.age" +
                        " FROM minions AS m" +
                        " JOIN minions_villains AS mv ON m.id = mv.minion_id" +
                        " WHERE mv.villain_id = ?;");
        minionStatement.setInt(1, villainId);

        ResultSet minionSet = minionStatement.executeQuery();
        for (int index = 1; minionSet.next(); index++) {
            String name = minionSet.getString("name");
            int age = minionSet.getInt("age");
            System.out.printf("%d. %s %d%n", index, name, age);
        }

        connection.close();
    }

    private static Connection getConnection(String username, String password) throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", username);
        properties.setProperty("password", password);

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);
    }
}
