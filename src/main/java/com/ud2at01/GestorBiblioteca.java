package com.ud2at01;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class GestorBiblioteca {
    void sentencia1(boolean ifAlready){
        if (!ifAlready) {
            try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb?user=usuario&password=usuario123");            
            Statement s= conn.createStatement();
            int result = s.executeUpdate("CREATE DATABASE biblioAdriamP");
            conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("La base de datos ya existe, ¿desea borrarla?: (S/N)");
            Scanner sc = new Scanner(System.in);
            if (sc.nextLine().toUpperCase() == "S") {
                try {
                    Connection cone = DriverManager.getConnection("jdbc:mysql://localhost/testdb?user=usuario&password=usuario123");
                    Statement se = cone.createStatement();
                    int resultsado = se.executeUpdate("DROP DATABASE biblioAdriamP");
                    cone.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            sc.close();
        }
        
    }
}