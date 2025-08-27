package com.PINACOMP.Sistemalibreria.app;

import com.PINACOMP.Sistemalibreria.model.entidades.*;
import com.PINACOMP.Sistemalibreria.model.enums.TipoGenero;
import com.PINACOMP.Sistemalibreria.model.enums.TipoNacionalidad;
import com.PINACOMP.Sistemalibreria.model.enums.TipoSexo;
import com.PINACOMP.Sistemalibreria.model.enums.Tiposubgenero;

import java.util.*;


public abstract class mainEstatico implements Buscador {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Libro> biblioteca;
    private static Buscador buscador;

    public static void main(String[] args) {
        biblioteca = crearBiblioteca();
        buscador = new BuscadorObras(biblioteca) {
            @Override
            public List<Libro> buscar(String criterio) {
                return List.of(); // Implementación vacía por ahora
            }
        };
        System.out.println("Biblioteca inicializada con " + biblioteca.size() + " libros.");
        System.out.println("Iniciando menú interactivo...");


        int opcion=-1;
        while (opcion != 0) {
            mostrarMenu(); //  Menú visible
            opcion = leerOpcion(); //  Lectura
            ejecutarOpcion(opcion); //  Switch
        }
    }
    /**
     * Crea e inicializa una lista de libros con autores y datos completos.
     * Utiliza una estructura dinámica para facilitar extensiones y validaciones.
     *
     * @return Lista de libros inicializada y validada.
     */
    private static List<Libro> crearBiblioteca() {
        List<Libro> lista = new ArrayList<>(); // Lista explícita y extensible

        // Crear personas
        Persona p1 = new Persona(1, "Gabriel", "García", "Márquez", "gabriel@realismo.com", 82, TipoSexo.Masculino) {
            @Override
            public TipoNacionalidad getNacionalidad() {
                return TipoNacionalidad.MEXICANA;
            }
        };
        Persona p2 = new Persona(2, "Isabel", "Allende", "", "isabel@latinoamericana.com", 80, TipoSexo.Femenino) {
            @Override
            public TipoNacionalidad getNacionalidad() {
                return TipoNacionalidad.MEXICANA;
            }
        };
        Persona p3 = new Persona(3, "Alan", "Moore", "", "alan@comics.com", 70, TipoSexo.Masculino) {
            @Override
            public TipoNacionalidad getNacionalidad() {
                return TipoNacionalidad.BRITANICA;
            }
        };

        // Crear autores
        Autor autor1 = new Autor(p1);
        Autor autor2 = new Autor(p2);
        Autor autor3 = new Autor(p3);
        Autor autor4 = new Autor("Nancy","Mendez","Guevara");
        // Crear libros y agregarlos a la lista
        Libro libro1 = new Libro(1, "Cien años de soledad", 299.0, "ISBN-001", TipoGenero.NARRATIVO, "Editorial Sudamericana", autor1);
        libro1.setAutor(autor4);
        libro1.setSubgenero(Tiposubgenero.NOVELA);
        lista.add(libro1); //  Agregado dinámicamente

        Libro libro2 = new Libro(2, "Watchmen", 349.0, "ISBN-002", TipoGenero.NARRATIVO, "DC Comics",autor2);
        libro2.setAutor(autor3);
        libro2.setSubgenero(Tiposubgenero.NOVELA);
        lista.add(libro2);

        Libro libro3 = new Libro(3, "La casa de los espíritus", 279.0, "ISBN-003", TipoGenero.NARRATIVO, "Plaza & Janés",autor3);
        libro3.setAutor(autor2);
        libro3.setSubgenero(Tiposubgenero.NOVELA);
        lista.add(libro3);

        // Verificación en consola
        System.out.println("Libros creados: " + lista.size());

        return lista;
    }

    private static void mostrarTodosLosLibros() {
        System.out.println("\nTodos los libros:");
        if (biblioteca == null || biblioteca.isEmpty()) {
            System.out.println("La biblioteca está vacía.");
            return;
        }
        for (Libro libro : biblioteca) {
            System.out.println(" - TITULO :" + libro.getTitulo());
            System.out.println(" - AUTOR  :" + libro.getAutor().getNombreCompleto());
            System.out.println(" - GÉNERO :" + libro.getGenero());
            System.out.println("AUTORES"+buscador.buscar("AUTORES"));
        }
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
            case 1 -> mostrarTodosLosLibros();
            case 2 -> buscarPorGenero();
            case 3 -> buscarPorAutor();
            case 4 -> buscarPorTitulo();
            case 5 -> buscarPorPrecio();
            case 0 -> System.out.println("Saliendo del sistema...");
            default -> System.out.println("Opción no válida.");
        }
    }




    private static void buscarPorGenero() {
        System.out.print("Ingrese el género (NARRATIVO, COMIC, POESIA...): ");
        String generoStr = scanner.nextLine().toUpperCase();
        try {
            TipoGenero genero = TipoGenero.valueOf(generoStr);
            mostrarResultados(buscador.busquedaGeneroLibro(genero));
        } catch (IllegalArgumentException e) {
            System.out.println("Género no válido.");
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

    private static void mostrarResultados(List<Libro> resultados) {
        if (resultados.isEmpty()) {
            System.out.println("No se encontraron resultados.");
        } else {
            System.out.println("Resultados encontrados:");
            for (Libro libro : resultados) {
                System.out.println(" - " + libro.getTitulo() +
                        " | Autor: " + libro.getAutor().getNombreCompleto() +
                        " | Género: " + libro.getGenero() +
                        " | Subgénero: " + libro.getSubgenero());
            }
        }
    }
}



