package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://almacenitla-db.ctam6uiuy8ez.us-east-1.rds.amazonaws.com:3306/yourDatabaseName"; // Cambia 'yourDatabaseName' al nombre real de tu base de datos
    private static final String USER = "estuditlafinal";
    private static final String PASSWORD = "itla123";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

