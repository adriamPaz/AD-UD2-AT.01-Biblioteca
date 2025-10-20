package com.conexions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class MySQLConnection implements DBConnection{

    
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "usuario";
    private static final String PASSWORD = "usuario123";
    
    @Override
    public Connection getConnection() {
        

        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Error conectando a MSQL "+e.getMessage());
            return null;
        }
    
    }
    
}
