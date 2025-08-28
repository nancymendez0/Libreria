package com.PINACOMP.Sistemalibreria.app;
import com.PINACOMP.Sistemalibreria.data.Biblioteca;
import com.PINACOMP.Sistemalibreria.model.entidades.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Libro> biblioteca = new ArrayList<>();
    public static void main(String[] args) {
        biblioteca = Biblioteca.crearBiblioteca();
        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion();
            ejecutarOpcion(opcion);
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("\nMENÚ PRINCIPAL");
        System.out.println("1. Mostrar todos los libros");
        System.out.println("2. Buscar por género");
        System.out.println("3. Buscar por autor");
        System.out.println("4. Buscar por título");
        System.out.println("5. Buscar por precio");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static int leerOpcion() {
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        return opcion;
    }

    private static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> mostrarResultados(biblioteca);
            /*
            case 2 -> buscarPorGenero();
            case 3 -> buscarPorAutor();
            case 4 -> buscarPorTitulo();
            case 5 -> buscarPorPrecio();

             */
            case 0 -> System.out.println(" Saliendo del sistema...");
            default -> System.out.println(" Opción no válida.");
        }
    }
/*
    private static void buscarPorGenero() {
        System.out.print("Ingrese el género (NOVELA, COMIC, POESIA...): ");
        String generoStr = scanner.nextLine().toUpperCase();
        try {
            TipoGenero genero = TipoGenero.valueOf(generoStr);
            mostrarResultados(buscador.busquedaGeneroLibro(genero));
        } catch (IllegalArgumentException e) {
            System.out.println(" Género no válido.");
        }
    }


    private static void buscarPorAutor() {
        System.out.print("Ingrese el nombre del autor: ");
        String autor = scanner.nextLine();
        mostrarResultados(buscador.busquedaAutor(autor));
    }

    private static void buscarPorTitulo() {
        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine();
        mostrarResultados(buscador.busquedaTitulo(titulo));
    }

    private static void buscarPorPrecio() {
        System.out.print("Ingrese el precio exacto: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();
        mostrarResultados(buscador.busquedaPrecio(precio));
    }
    */

    private static void mostrarResultados(List<Libro> resultados) {
    int contador;
        if (resultados.isEmpty()) {
            System.out.println(" No se encontraron resultados.");
        } else {
            System.out.println("TENGO " + biblioteca.size() + " LIBROS ACTUALMENTE\n");
            contador=1;
            for (Libro libro : resultados) {
                System.out.println("INFORMACIÓN LIBRO " + contador + ":");
                System.out.println(libro);
                System.out.println();
                contador++;
            }
        }
    }
}


