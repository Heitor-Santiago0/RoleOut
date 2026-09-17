package br.com.roleout.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String URL =
            System.getenv().getOrDefault(
                "DB_URL",
                "jdbc:mysql://localhost:3306/roleout"
            );

    private static final String USER =
            System.getenv().getOrDefault(
                "DB_USER",
                "roleout"
            );

    private static final String PASSWORD =
            System.getenv().getOrDefault(
                "DB_PASSWORD",
                "roleout123"
            );

            static {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        throw new RuntimeException("Driver MySQL não encontrado.", e);
    }
}
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}