package com.ud2at01;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class GestorBiblioteca {
    Connection connection = null;
    Statement statement = null;

    
    void sentencia1(String nombreBD, String server, String user, String pswd){        
        try {
            //localhost,usuario,usuario123
            this.connection = DriverManager.getConnection("jdbc:mysql://"+server+"/?user="+user+"&password="+pswd);
            statement = this.connection.createStatement();

            statement.executeUpdate("CREATE DATABASE "+nombreBD);
            System.out.println("La base de datos ha sido creada");
            statement.close();
        } catch (SQLException sqlException) {
            if (sqlException.getErrorCode() == 1007) {
                // codigo de error si la db ya existe
                System.out.println("La base de datos ya existe, ¿desea borrarla? (S/N)");
                Scanner sn = new Scanner(System.in);
                String yn = sn.nextLine().toUpperCase();
                if (yn.equals("S")) {
                    try {
                        statement.executeUpdate("DROP DATABASE "+nombreBD);
                        statement.close();
                    } catch (SQLException sqlExcption) {
                        System.out.println(sqlExcption.getMessage());
                    }
                }
            } else {
                //para otros errores
                sqlException.printStackTrace();
            }
        } catch (Error e) {
            System.out.println(e.getMessage());
        }
        /* 
        Connection cone = DriverManager.getConnection("jdbc:mysql://localhost/testdb?user=usuario&password=usuario123");
        Statement se = cone.createStatement();
        boolean ifAlready = 
        if (!ifAlready) {
            try {
            int result = se.executeUpdate("CREATE DATABASE biblioAdriamP");
            cone.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("La base de datos ya existe, ¿desea borrarla?: (S/N)");
            Scanner sc = new Scanner(System.in);
            if (sc.nextLine().toUpperCase() == "S") {
                try {
                    
                    int resultsado = se.executeUpdate("DROP DATABASE biblioAdriamP");
                    cone.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            sc.close();
        }
        */
        
    }
    public Connection getConnection() {
        return this.connection;
    }
}