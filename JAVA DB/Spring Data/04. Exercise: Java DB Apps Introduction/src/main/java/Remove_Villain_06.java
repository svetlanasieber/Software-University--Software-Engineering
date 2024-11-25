import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Remove_Villain_06 {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Connection connection = getConnection("root", "denis");

        int villain_id = Integer.parseInt(scanner.nextLine());

        PreparedStatement selectVillain = connection.prepareStatement
                ("SELECT name" +
                        " FROM villains" +
                        " WHERE id = ?;");
        selectVillain.setInt(1, villain_id); 
        ResultSet villainSet = selectVillain.executeQuery();
        if (!villainSet.next()) {
            System.out.println("No such villain was found");
            return;
        }

        String villainName = villainSet.getString("name");

        PreparedStatement selectAllVillainMinions = connection.prepareStatement
                ("SELECT COUNT(minion_id) AS m_count" +
                        " FROM minions_villaIns" +
                        " WHERE villain_id = ?");
        selectAllVillainMinions.setInt(1, villain_id);

        ResultSet minionsCountSet = selectAllVillainMinions.executeQuery();
        minionsCountSet.next();
        int countMinionsDeleted = minionsCountSet.getInt("m_count");

        connection.setAutoCommit(false);

        try {
            PreparedStatement deleteMinionsVillains = connection.prepareStatement
                    ("DELETE FROM minions_villains WHERE villain_id = ?;");
            deleteMinionsVillains.setInt(1, villain_id);
            deleteMinionsVillains.executeUpdate();

            PreparedStatement deleteVillain = connection.prepareStatement
                    ("DELETE FROM villains WHERE id = ?;");
            deleteVillain.setInt(1, villain_id);
            deleteVillain.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
        }

        System.out.println(villainName + " was deleted");
        System.out.println(countMinionsDeleted + " minions released");

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
