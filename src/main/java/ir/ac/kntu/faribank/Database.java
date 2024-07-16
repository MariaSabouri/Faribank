package ir.ac.kntu.faribank;

import java.sql.*;

public class Database {
    private static Connection conn;

    public static Connection getConn() {
        return conn;
    }

    public static void openConnection(){
        try {
            String url = "jdbc:postgresql://localhost:5432/FariBank";
            String user = "postgres";
            String password = "root";

            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Database connection successful.");
        } catch (SQLException e) {
            System.err.println("Error connecting to database: " + e.getMessage());
        }
    }
}
