package com.example.tidsrejsefeedbackopgave.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    // Lokal MySQL-forbindelse (skoleprojekt)
    private static final String URL = "jdbc:mysql://localhost:3306/tidsrejse";
    private static final String USER = "root";
    private static final String PASSWORD = "Benfica121!";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Hurtig test af forbindelse
    public static void main(String[] args) {
        try (Connection conn = connect()) {
            System.out.println("Connected to tidsrejse database");
        } catch (SQLException e) {
            System.out.println("DB-fejl: " + e.getMessage());
        }
    }
}
