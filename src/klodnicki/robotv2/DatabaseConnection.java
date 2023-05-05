package klodnicki.robotv2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/robot_app"; //URL bazy danych
        String username = "robot_app_user";
        String password = "Szymon123456";
        return DriverManager.getConnection(url, username, password);
    }
}