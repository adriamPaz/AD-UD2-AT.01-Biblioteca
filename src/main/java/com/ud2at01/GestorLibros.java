package com.ud2at01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GestorLibros {
    Connection connection = null;
    GestorLibros(Connection connection){
        this.connection = connection;
    }

    void tablaNueva(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/biblioAdriamP?user=usuario&password=usuario123");
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE libros (titulo VARCHAR(35), autor VARCHAR(25), año_de_publicacion INT, isbn VARCHAR(13))");
            System.out.println("Tabla creada");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    void addLibro(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/biblioAdriamP?user=usuario&password=usuario123");
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into libros (titulo, autor, año_de_publicacion, isbn) values ('Crimen y Castigo','Fyodor Dostoyevsky',1866,'9788426156020')");
            System.out.println("Libro añadido");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    void selectAllBooks(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/biblioAdriamP?user=usuario&password=usuario123");
            Statement statement = connection.createStatement();
            ResultSet resultset =statement.executeQuery("SELECT * FROM libros");

            while (resultset.next()) {
                System.out.println(resultset.getString("titulo"));
                System.out.println(resultset.getString("autor"));
                System.out.println(resultset.getString("isbn"));
                System.out.println(resultset.getString("año_de_publicacion"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    void selectAutorBooks(String autor){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/biblioAdriamP?user=usuario&password=usuario123");
            Statement statement = connection.createStatement();
            ResultSet resultset =statement.executeQuery("SELECT * FROM libros WHERE autor = '"+autor+"'");

            while (resultset.next()) {
                System.out.println(resultset.getString("titulo"));
                System.out.println(resultset.getString("autor"));
                System.out.println(resultset.getString("isbn"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void selectBooksAfter(int fechaPubli){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/biblioAdriamP?user=usuario&password=usuario123");
            Statement statement = connection.createStatement();
            ResultSet resultset =statement.executeQuery("SELECT * FROM libros WHERE año_de_publicacion > "+fechaPubli);

            while (resultset.next()) {
                System.out.println(resultset.getString("titulo"));
                System.out.println(resultset.getString("autor"));
                System.out.println(resultset.getString("isbn"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void changeBookName(String name, String isbn){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/biblioAdriamP?user=usuario&password=usuario123");
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE libros set titulo = '"+name+"' where isbn = '"+isbn+"'");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    void changeBookAuthor(String name, String isbn){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/biblioAdriamP?user=usuario&password=usuario123");
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE libros set autor = '"+name+"' where isbn = '"+isbn+"'");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void changeBookPublishingDate(int year, String isbn){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/biblioAdriamP?user=usuario&password=usuario123");
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE libros set año_de_publicacion = "+year+" where isbn = '"+isbn+"'");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void deleteBook(String isbn){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/biblioAdriamP?user=usuario&password=usuario123");
            Statement statement = connection.createStatement();
            statement.executeUpdate("delete from libros where isbn = '"+isbn+"'");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void deleteBookAfterYear(int year){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/biblioAdriamP?user=usuario&password=usuario123");
            Statement statement = connection.createStatement();
            statement.executeUpdate("delete from libros where año_de_publicacion < "+year);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void cleanBooks(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/biblioAdriamP?user=usuario&password=usuario123");
            Statement statement = connection.createStatement();
            statement.executeUpdate("delete from libros");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
