package com.jdbc;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Diablo {
    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);



        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "1234");

        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/diablo", props);

        System.out.print("Enter username: ");
        String name = scanner.nextLine();

        PreparedStatement query =
                connection.prepareStatement("SELECT user_name, first_name, last_name, " +
                        "(SELECT count(id) FROM users_games " +
                        "WHERE user_id = u.id " +
                        ") AS games_count FROM  users AS u " +
                        "WHERE user_name = ?");

        query.setString(1, name);


        ResultSet result = query.executeQuery();

        if (result.next()){
            String username = result.getString("user_name");
            String firstName = result.getString("first_name");
            String lastName = result.getString("last_name");
            int gamesCount = result.getInt("games_count");
            System.out.printf("User: %s%n%s %s has played %d games",
                    username, firstName, lastName, gamesCount);

        }else {
            System.out.println("No such user exists");
        }



    }
}
