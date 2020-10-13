package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
    public Connection getNewConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/test_user?useUnicode=true&serverTimezone=Europe/Moscow";
            String user = "root";
            String password = "XXX";
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
