package com.PINACOMP.Sistemalibreria.app;

import com.PINACOMP.Sistemalibreria.model.entidades.Autor;
import com.PINACOMP.Sistemalibreria.model.entidades.Libro;
import com.PINACOMP.Sistemalibreria.model.enums.TipoGenero;
import com.PINACOMP.Sistemalibreria.model.enums.TipoNacionalidad;
import com.PINACOMP.Sistemalibreria.model.enums.Tiposubgenero;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class mainEstatico {
    private static final List<Libro> stock = new ArrayList<>(Arrays.asList(
            new Libro(1, "El valle de las muñecas", 300.0, "9788497594569", TipoGenero.NOVELA, Tiposubgenero.PSICOLOGICA, "Editorial Planeta"),
            new Libro(2, "La Odisea", 300.0, "9780140268867", TipoGenero.LITERARIO, Tiposubgenero.EPOPEYA, "Penguin Classics"),
            new Libro(3, "Poesía no eres tú", 180.0, "9786071605417", TipoGenero.LIRICO, Tiposubgenero.POESIA, "Fondo de Cultura Económica"),
            new Libro(4, "Pedro Páramo", 220.0, "9789681602365", TipoGenero.NARRATIVO, Tiposubgenero.NOVELA, "Editorial RM"),
            new Libro(5, "La vida inútil de Pito Pérez", 200.0, "9789682321234", TipoGenero.NARRATIVO, Tiposubgenero.COMEDIA, "Editorial Porrúa"),
            new Libro(6, "Esculpir el tiempo", 350.0, "9788420674173", TipoGenero.DIDACTICO, Tiposubgenero.ENSAYO, "Ediciones Akal")

    ));

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMENÚ PRINCIPAL");
            System.out.println("1. Mostrar todos los libros");
            System.out.println("2. Buscar libros");
            System.out.println("3. Agregar libro al stock");
            System.out.println("4. Operaciones de biblioteca");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    mostrarTodos();
                    break;

                case 2:
                    System.out.println("\nOpciones de búsqueda:");
                    System.out.println("a. Por autor");
                    System.out.println("b. Por género");
                    System.out.println("c. Por precio exacto");
                    System.out.println("d. Por rango de precios");
                    System.out.print("Seleccione una opción (a/b/c/d): ");
                    String subopcion = scanner.nextLine().toLowerCase();

                    switch (subopcion) {
                        case "a":
                            System.out.print("Nombre del autor: ");
                            String autor = scanner.nextLine();
                            buscarPorAutor(autor);
                            break;
                        case "b":
                            System.out.print("Género: ");
                            String genero = scanner.nextLine();
                            buscarPorGenero(genero);
                            break;
                        case "c":
                            System.out.print("Precio exacto: ");
                            double precioExacto = scanner.nextDouble();
                            buscarPorPrecioExacto(precioExacto);
                            break;
                        case "d":
                            System.out.print("Precio mínimo: ");
                            double minimo = scanner.nextDouble();
                            System.out.print("Precio máximo: ");
                            double maximo = scanner.nextDouble();
                            buscarPorRangoDePrecio(minimo, maximo);
                            break;
                        default:
                            System.out.println("Opción inválida.");
                    }
                    break;

                case 3:
                    System.out.print("ID del libro: ");
                    String id = scanner.nextLine();
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Precio: ");
                    double precio = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Género (enum): ");
                    TipoGenero generoEnum = TipoGenero.valueOf(scanner.nextLine().toUpperCase());
                    System.out.print("Subgénero (enum): ");
                    TiposSubgenero subgeneroEnum = TiposSubgenero.valueOf(scanner.nextLine().toUpperCase());
                    System.out.print("Nombre del autor: ");
                    String nombreAutor = scanner.nextLine();

                    Autor autorNuevo = stock.stream()
                            .map(Libro::getAutor)
                            .filter(a -> a.getNombreCompleto().equalsIgnoreCase(nombreAutor))
                            .findFirst()
                            .orElse(new Autor(999, nombreAutor, "", "", "nuevo@example.com", 0, TipoSexo.NO_ESPECIFICADO, TipoNacionalidad.DESCONOCIDA, LocalDate.now(), 0));

                    Libro nuevoLibro = new Libro(id, titulo, precio, isbn, generoEnum, subgeneroEnum, autorNuevo);
                    stock.add(nuevoLibro);
                    System.out.println("Libro agregado correctamente.");
                    break;

                case 4:
                    System.out.println("\nOperaciones de biblioteca:");
                    System.out.println("a. Registrar venta");
                    System.out.println("b. Registrar préstamo");
                    System.out.println("c. Registrar devolución");
                    System.out.print("Seleccione una operación (a/b/c): ");
                    String operacion = scanner.nextLine().toLowerCase();

                    switch (operacion) {
                        case "a":
                            System.out.println("Función de venta aún no implementada.");
                            break;
                        case "b":
                            System.out.println("Función de préstamo aún no implementada.");
                            break;
                        case "c":
                            System.out.println("Función de devolución aún no implementada.");
                            break;
                        default:
                            System.out.println("Opción inválida.");
                    }
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 0);
    }

    // Métodos auxiliares
    public static void mostrarTodos() {
        if (stock.isEmpty()) {
            System.out.println("\nNo hay libros registrados en el catálogo.");
            return;
        }

        System.out.println("\nCatálogo de libros");
        System.out.println("────────────────────────────────────────────────────────────────────────────");
        System.out.printf("%-6s %-30s %-10s %-15s %-20s%n", "ID", "Título", "Precio", "Género", "Autor");
        System.out.println("────────────────────────────────────────────────────────────────────────────");

        for (Libro libro : stock) {
            String autorNombre = libro.getAutor().getNombreCompleto() + " " ;
            System.out.printf("%-6s %-30s $%-9.2f %-15s %-20s%n",
                    libro.getId(),
                    libro.getTitulo(),
                    libro.getPrecio(),
                    libro.getGenero().name(),
                    autorNombre
            );
        }

        System.out.println("────────────────────────────────────────────────────────────────────────────");
    }

    public static void buscarPorAutor(String nombre) {
        System.out.println("\nLibros del autor: " + nombre);
        boolean encontrado = false;
        for (Libro libro : stock) {
            if (libro.getAutor().getNombreCompleto().equalsIgnoreCase(nombre)) {
                imprimirLibro(libro);
                encontrado = true;
            }
        }
        if (!encontrado) System.out.println("No se encontraron libros de ese autor.");
    }

    public static void buscarPorGenero(String genero) {
        System.out.println("\nLibros del género: " + genero);
        boolean encontrado = false;
        for (Libro libro : stock) {
            if (libro.getGenero().name().equalsIgnoreCase(genero)) {
                imprimirLibro(libro);
                encontrado = true;
            }
        }
        if (!encontrado) System.out.println("No se encontraron libros de ese género.");
    }

    public static void buscarPorPrecioExacto(double precio) {
        System.out.printf("\nLibros con precio exacto: $%.2f%n", precio);
        boolean encontrado = false;
        for (Libro libro : stock) {
            if (libro.getPrecio() == precio) {
                imprimirLibro(libro);
                encontrado = true;
            }
        }
        if (!encontrado) System.out.println("No se encontraron libros con ese precio.");
    }

    public static void buscarPorRangoDePrecio(double minimo, double maximo) {
        System.out.printf("\nLibros con precio entre $%.2f y $%.2f%n", minimo, maximo);
        boolean encontrado = false;
        for (Libro libro : stock) {
            if (libro.getPrecio() >= minimo && libro.getPrecio() <= maximo) {
                imprimirLibro(libro);
                encontrado = true;
            }
        }
        if (!encontrado) System.out.println("No se encontraron libros en ese rango.");
    }

    private static void imprimirLibro(Libro libro) {
        String autorNombre = libro.getAutor().getNombreCompleto() + " " ;
        System.out.printf("%-6s %-30s $%-9.2f %-15s %-20s%n",
                libro.getId(),
                libro.getTitulo(),
                libro.getPrecio(),
                libro.getGenero().name(),
                autorNombre
        );
    }


}




