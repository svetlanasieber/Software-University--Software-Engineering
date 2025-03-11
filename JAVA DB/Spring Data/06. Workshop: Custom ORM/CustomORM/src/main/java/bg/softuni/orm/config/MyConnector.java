package bg.softuni.orm.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnector {
    private static final String JDBC_URL_TEMPLATE = "jdbc:mysql://localhost:3306/%s";
    private static Connection connection;

    private MyConnector() {}

    public static void createConnection(String user, String pass, String dbName) throws SQLException {
        String url = String.format(JDBC_URL_TEMPLATE, dbName);

        connection = DriverManager.getConnection(url, user, pass);
    }

    public static Connection getConnection() {
        return connection;
    }
}

//
//class Singleton {
//    private static Object instance;
//
//    private Singleton() {}
//
//    public static Object getInstance() {
//        if (instance == null) {
//            init();
//        }
//
//        return instance;
//    }
//
//    private static void init() {
////        ...
////        instance = ....
//    }
//}
