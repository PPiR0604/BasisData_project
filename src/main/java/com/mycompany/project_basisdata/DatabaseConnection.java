package com.mycompany.project_basisdata;

/**
 *
 * @author Asus
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=TestProjekAhir;encrypt=true;trustServerCertificate=true;";
    private static final String USER = "Ajel";
    private static final String PASSWORD = "123";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            if (connection != null) {
                System.out.println("Koneksi berhasil!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
