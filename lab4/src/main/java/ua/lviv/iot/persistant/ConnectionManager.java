package ua.lviv.iot.persistant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    public static final String url = "jdbc:mysql://localhost:3306/planes?serverTimezone=UTC&useSSL=false&" +
            "allowPublicKeyRetrieval=true";
    private static final String user = "root";
    private static final String password = "death291702";

    private static Connection connection;

    private ConnectionManager() {}

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                System.out.println("MySQL Driver is not loaded");
            } catch (SQLException e) {
                System.out.println("SQLException: " + e.getMessage());
                System.out.println("SQL State: " + e.getSQLState());
                System.out.println("VendorError" + e.getErrorCode());
            }
        }
        return connection;
    }
}
