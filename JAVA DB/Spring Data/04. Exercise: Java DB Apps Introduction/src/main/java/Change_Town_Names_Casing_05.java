import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class Change_Town_Names_Casing_05 {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Connection connection = getConnection("root", "denis");

        String countryName = scanner.nextLine();

        PreparedStatement updateTownNames = connection.prepareStatement
                ("UPDATE towns" +
                        " SET name = UPPER(name)" +
                        " WHERE country = ?;");
        updateTownNames.setString(1, countryName);
        int updatedCount = updateTownNames.executeUpdate();

        if (updatedCount == 0) {
            System.out.println("No town names were affected.");
            return;
        }

        System.out.println(updatedCount + " town names were affected.");

        PreparedStatement selectAllTowns = connection.prepareStatement
                ("SELECT name FROM towns WHERE country = ?;");
        selectAllTowns.setString(1, countryName);
        ResultSet townsSet = selectAllTowns.executeQuery();

        List<String> towns = new ArrayList<>();
        while (townsSet.next()) {
            String townName = townsSet.getString("name");
            towns.add(townName);
        }
        System.out.println(towns);

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
