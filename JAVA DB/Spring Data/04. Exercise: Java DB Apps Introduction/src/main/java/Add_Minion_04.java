import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Add_Minion_04 {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Connection connection = getConnection("root", "denis");

        String[] minionInfo = scanner.nextLine().split(" ");
        String minionName = minionInfo[1];
        int minionAge = Integer.parseInt(minionInfo[2]);
        String minionTown = minionInfo[3];
        String villainName = scanner.nextLine().split(" ")[1];

        int town_id = getOrInsertTown(connection, minionTown);
        int villain_id = getOrInsertVillain(connection, villainName);

        System.out.printf("Successfully added %s to be minion of %s.", minionName, villainName);

        PreparedStatement insertMinion = connection.prepareStatement
                ("INSERT INTO minions(name, age, town_id) VALUES(?, ?, ?);");
        insertMinion.setString(1, minionName);
        insertMinion.setInt(2, minionAge);
        insertMinion.setInt(3, town_id);
        insertMinion.executeUpdate();

        PreparedStatement getLastMinion = connection.prepareStatement
                ("SELECT id FROM minions ORDER BY id DESC LIMIT 1;");
        ResultSet lastMinionSet = getLastMinion.executeQuery();
        lastMinionSet.next(); // Мести до първият резултат
        int lastMinionId = lastMinionSet.getInt("id");

        PreparedStatement insertMinionsVillains = connection.prepareStatement
                ("INSERT INTO minions_villains VALUES(?, ?);");
        insertMinionsVillains.setInt(1, lastMinionId);
        insertMinionsVillains.setInt(2, villain_id);
        insertMinionsVillains.executeUpdate();

        connection.close();
    }

    private static int getOrInsertVillain(Connection connection, String villainName) throws SQLException {
        PreparedStatement selectVillain = connection.prepareStatement
                ("SELECT id" +
                        " FROM villains" +
                        " WHERE name = ?;");
        selectVillain.setString(1, villainName);

        ResultSet villainSet = selectVillain.executeQuery();
        int villain_id = 0;
        if (!villainSet.next()) {
            PreparedStatement insertVillain = connection.prepareStatement
                    ("INSERT INTO villains(name, evilness_factor) VALUES(?, ?);");
            insertVillain.setString(1, villainName);
            insertVillain.setString(2, "evil");
            insertVillain.executeUpdate();

            ResultSet newVillainSet = selectVillain.executeQuery();
            newVillainSet.next();
            villain_id = newVillainSet.getInt("id");

            System.out.printf("Villain %s was added to the database.%n", villainName);
        } else {
            villain_id = villainSet.getInt("id");
        }
        return villain_id;
    }

    private static int getOrInsertTown(Connection connection, String minionTown) throws SQLException {
        PreparedStatement selectTown = connection.prepareStatement
                ("SELECT id" +
                        " FROM towns" +
                        " WHERE name = ?;");
        selectTown.setString(1, minionTown);

        ResultSet townSet = selectTown.executeQuery();
        int townId = 0;
        if (!townSet.next()) {
            PreparedStatement insertTown = connection.prepareStatement
                    ("INSERT INTO towns(name) VALUES(?);");
            insertTown.setString(1, minionTown);
            insertTown.executeUpdate();

            ResultSet newTownSet = selectTown.executeQuery();
            newTownSet.next();
            townId = newTownSet.getInt("id");

            System.out.printf("Town %s was added to the database.%n", minionTown);
        } else {
            townId = townSet.getInt("id");
        }
        return townId;
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
