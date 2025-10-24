package com.ud2at01;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido al menu de MySQL");
        Boolean salir = false;
        Scanner sc =new Scanner(System.in);
        while (!salir) {
            System.out.println("¿Qué desea hacer?");
            System.out.println("1. Crear una base de datos");
            System.out.println("2. Modificar la base de datos biblioteca");
            System.out.println("3. Realizar una consulta en biblioteca");
            System.out.println("Salir (cualquier otra tecla)");
            
            int switchValue1 = sc.nextInt();

           

            switch (switchValue1) {
                case 1:
                    ArrayList<String> data = getServerdata();
                    GestorBiblioteca gestorBiblioteca = new GestorBiblioteca();
                    gestorBiblioteca.sentencia1(data.get(0), data.get(1), data.get(2), data.get(3));
                    break;
                case 2:
                    data = getServerdata();
                    GestorLibros gestorLibros = new GestorLibros(null);
                    //gestorLibros.(data.get(0), data.get(1), data.get(2), data.get(3));
                    System.out.println();

                    System.out.println("Seleccione la modificación que desea realizar: ");
                    System.out.println("1. Crear una tabla nueva");
                    System.out.println("2. Añadir un libro");
                    System.out.println("3. Cambiar nombre de un libro");
                    System.out.println("4. Cambiar autor de un libro");
                    System.out.println("5. Cambiar fecha de publicacion de un libro");
                    System.out.println("6. Borrar un libro");
                    System.out.println("7. Borrar libros publicados despues de un año");
                    System.out.println("8. Borrar todos los libros");
                    switch (sc.nextInt()) {
                        case 1:
                            
                            break;
                        case 2:
                            
                            break;
                        case 3:
                            
                            break;
                        case 4:
                            
                            break;
                        case 5:
                            
                            break;
                        case 6:
                            
                            break;
                        case 7:
                            
                            break;
                        case 8:
                            
                            break;
                    
                        default:
                            break;
                    }
                    break;
                case 3:
                    data = getServerdata();
                    gestorBiblioteca = new GestorBiblioteca();
                    gestorBiblioteca.sentencia1(data.get(0), data.get(1), data.get(2), data.get(3));
                    break;
                default:
                    salir = true;
                    sc.close();
                    break;
            }
        }
        
        
        
        GestorLibros gestorLibros = new GestorLibros(null);
        gestorLibros.deleteBook("9788426156020");

        gestorLibros.selectAllBooks();
    }

    static ArrayList<String> getServerdata(){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> str = new ArrayList<String>();

        System.out.println("Introduzca el nombre de la BD a la que desea conectarse: ");
        str.add(sc.next());
        System.out.println("Introduzca el nombre del servidor: ");
        str.add(sc.next());
        System.out.println("Introduzca el nombre de usuario: ");
        str.add(sc.next());
        System.out.println("Introduzca la contraseña: ");
        str.add(sc.next());

        sc.close();
        return  str;
    }
}