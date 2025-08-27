package com.PINACOMP.Sistemalibreria.app;

import com.PINACOMP.Sistemalibreria.model.entidades.Autor;
import com.PINACOMP.Sistemalibreria.model.entidades.Libro;
import com.PINACOMP.Sistemalibreria.model.entidades.Persona;
import com.PINACOMP.Sistemalibreria.model.enums.TipoGenero;

import java.util.Scanner;

public class mainVersion2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Autor a1 = new Autor("Eduardo", "Piña", "Gonzalez");
        Libro libro1 = new Libro(
                1,
                "Cien años de soledad",
                a1,
                299.0,
                "ISBN-001",
                TipoGenero.NARRATIVO,
                "Editorial Sudamericana"
        );

        Libro libro2 = new Libro(
                2,
                "Watchmen",
                349.0,
                "ISBN-002",
                TipoGenero.NARRATIVO,
                "DC Comics"
        );

        Libro libro3 = new Libro(
                3,
                "La casa de los espíritus",
                279.0,
                "ISBN-003",
                TipoGenero.NARRATIVO,
                "Editorial Plaza & Janés"
        );
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

        private static int leerOpcion(Scanner scanner) {
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            return opcion;
        }

        private static void ejecutarOpcion(int opcion) {
            switch (opcion) {
                case 1 -> System.out.println("hola");//mostrarTodosLosLibros();
                case 2 -> System.out.println("hola");//buscarPorGenero();
                case 3 -> System.out.println("hola");//buscarPorAutor();
                case 4 -> System.out.println("hola");//buscarPorTitulo();
                case 5 -> System.out.println("hola");//buscarPorPrecio();
                case 0 -> System.out.println(" Saliendo del sistema...");
                default -> System.out.println(" Opción no válida.");
            }
        }
    }

