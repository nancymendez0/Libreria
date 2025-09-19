package com.PINACOMP.Sistemalibreria.app;
import com.PINACOMP.Sistemalibreria.data.Biblioteca;
import com.PINACOMP.Sistemalibreria.model.entidades.*;
import com.PINACOMP.Sistemalibreria.model.enums.EstadoOperacion;
import com.PINACOMP.Sistemalibreria.model.enums.TipoGenero;
import com.PINACOMP.Sistemalibreria.model.enums.TipoOperacion;
import com.PINACOMP.Sistemalibreria.model.interfaces.OperacionBiblioteca;
import com.sistemalibreria.excepciones.ValidacionUsuarioException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Libro> biblioteca = new ArrayList<>();
    private static BuscadorObras buscador;
    private static List<OperacionBiblioteca> operaciones=new ArrayList<>();
    public static void main(String[] args) {
        biblioteca = Biblioteca.crearBiblioteca();
        buscador= new BuscadorObras(biblioteca) {
            @Override
            public List<Libro> buscar(String criterio) {
                return List.of();
            }
        };
       //operacioones de biblioteca
 //Operaciones que afectan stock
        // Inicializar operaciones con libros de la biblioteca
        Libro libroVenta = biblioteca.get(0);
        Libro libroPrestamo = biblioteca.get(1);
        Libro libroDevolucion = biblioteca.get(2);

        Venta venta = new Venta(101, LocalDate.now(), libroVenta, libroVenta.getPrecio());
        Prestamo prestamo = new Prestamo(102, LocalDate.now(), 1, libroPrestamo, LocalDate.now().plusDays(7));
        Devolucion devolucion = new Devolucion(103, LocalDate.now(), 102, libroDevolucion, false, 0.0);

        // usa el primer libro disponible

        operaciones.add(venta);
        operaciones.add(prestamo);
        operaciones.add(devolucion);
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
        System.out.println("6. Ejemplo de operaciones");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }
    //validando entrada de OPCION
    private static int leerOpcion() {
        while (!scanner.hasNextInt()) {
            System.out.println("  Entrada inválida. Ingrese un número entero.");
            scanner.next(); // descarta entrada incorrecta
            System.out.print("Seleccione una opción: ");
        }
        int opcion = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer
        return opcion;
    }

    private static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1, 7 -> mostrarResultados(biblioteca);
            case 2 -> {
                System.out.print("Ingrese el género (ej. NARRATIVO): ");
                String entrada = scanner.nextLine().toUpperCase();

                try {
                    List<Libro> resultados = buscador.buscarPorGenero(entrada);
                    mostrarResultados(resultados);
                } catch (ValidacionUsuarioException e) {
                    System.out.println("!!! " + e.getMessage());
                }

            }
            case 3 -> {
                System.out.print("Ingrese el nombre del autor: ");
                String nombre = scanner.nextLine();
                try {
                    List<Libro> resultados = buscador.busquedaAutor(nombre);
                    mostrarResultados(resultados);
                } catch (ValidacionUsuarioException e) {
                    System.out.println(" advertencia " + e.getMessage());
                }

            }
            case 4 -> {
                System.out.print("Ingrese el título del libro: ");
                String titulo = scanner.nextLine();
                try {
                    List<Libro> resultados = buscador.busquedaTitulo(titulo);
                    mostrarResultados(resultados);
                } catch (ValidacionUsuarioException e) {
                    System.out.println("advertencia " + e.getMessage());
                }

            }
            case 5 -> {
                System.out.print("Ingrese el precio exacto: ");
                String entrada = scanner.nextLine();
                try {
                    double precio = Double.parseDouble(entrada);
                    List<Libro> resultados = buscador.busquedaPrecio(precio);
                    mostrarResultados(resultados);
                } catch (NumberFormatException e) {
                    System.out.println(" El precio debe ser un número válido.");
                } catch (ValidacionUsuarioException e) {
                    System.out.println(" advertencia " + e.getMessage());
                }

            }
            case 6 -> mostrarEjemploOperaciones();
            case 0 -> System.out.println("Saliendo del sistema...");
            default -> System.out.println("Opción no válida.");
        }
    }
    private static void mostrarEjemploOperaciones() {
        System.out.println("\n--- EJEMPLO DE OPERACIONES ---");

        boolean ventaMostrada = false;
        boolean prestamoMostrado = false;
        boolean devolucionMostrada = false;

        for (OperacionBiblioteca op : operaciones) {
            switch (op.getTipoOperacion()) {
                case VENTA -> {
                    if (!ventaMostrada) {
                        System.out.println(" Venta:");
                        op.mostrarResumen();
                        ventaMostrada = true;
                    }
                }
                case PRESTAMO -> {
                    if (!prestamoMostrado) {
                        System.out.println(" Préstamo:");
                        op.mostrarResumen();
                        prestamoMostrado = true;
                    }
                }
                case DEVOLUCION -> {
                    if (!devolucionMostrada) {
                        System.out.println(" Devolución:");
                        op.mostrarResumen();
                        devolucionMostrada = true;
                    }
                }
            }

            if (ventaMostrada && prestamoMostrado && devolucionMostrada) break;
        }
    }
    private static void mostrarResultados(List<Libro> resultados) {
    int contador;
        if (biblioteca.isEmpty()) {
            System.out.println(" No se encontraron resultados.");
        } else {
            System.out.println("TENGO " + resultados.size() + " LIBROS ACTUALMENTE\n");
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


