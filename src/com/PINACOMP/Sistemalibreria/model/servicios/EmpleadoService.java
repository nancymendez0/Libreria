package com.PINACOMP.Sistemalibreria.model.servicios;

import com.PINACOMP.Sistemalibreria.data.Biblioteca;
import com.PINACOMP.Sistemalibreria.data.Empleados;
import com.PINACOMP.Sistemalibreria.model.entidades.Autor;
import com.PINACOMP.Sistemalibreria.model.entidades.Empleado;
import com.PINACOMP.Sistemalibreria.model.entidades.Libro;
import com.PINACOMP.Sistemalibreria.model.enums.TipoGenero;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class EmpleadoService {
    private final List<Libro> libros;

    public EmpleadoService() {
        this.libros = Biblioteca.obtenerLibros();
    }
    public List<Libro> obtenerLibros() {
        return libros;
    }

    public void mostrarLibros(List<Libro> resultados){
        if (resultados.isEmpty()){
            System.out.println("No se encontraron resultados");
        }else{
            System.out.println("Tengo "+resultados.size()+" Libros actualmente\n");
            int contador=1;
            for (Libro libro : resultados){
                System.out.println("INFORMACIÓN LIBRO" + contador+ ":");
                System.out.println(libro);
                System.out.println();
                contador++;
            }
        }
    }

    public void agregarLibros(Scanner scanner){
        System.out.println("=== Ingresa los datos del libro que deseas agregar");
        System.out.println("ID del libro: ");
        int id= scanner.nextInt();
        scanner.nextLine();

        System.out.println("Titulo: ");
        String titulo = scanner.nextLine();

        System.out.println("Autor (Nombre)");
        String nombreAutor = scanner.nextLine();

        System.out.println("Autor (Apellido Paterno)");
        String apellidoPaterno = scanner.nextLine();

        System.out.println("Autor (Apellido Materno)");
        String apellidoMaterno = scanner.nextLine();

        Autor autor = new Autor( nombreAutor, apellidoPaterno, apellidoMaterno);

        System.out.println("Precio: (Libro)");
        double precio= scanner.nextDouble();
        scanner.nextLine();

        System.out.println("ISBN: ");
        String isbn= scanner.nextLine();

        System.out.println("Género (Elige un número): ");
        for (TipoGenero genero : TipoGenero.values()){
            System.out.println(genero.ordinal()+ " - " + genero);
        }

        int opcionGenero = scanner.nextInt();
        scanner.nextLine();
        TipoGenero generoSeleccionado = TipoGenero.values()[opcionGenero];

        System.out.println("Editorial: ");
        String editorial = scanner.nextLine();

        Libro nuevoLibro= new Libro (id,titulo,autor,precio,isbn,generoSeleccionado,editorial);
        libros.add(nuevoLibro);
        System.out.println("Libro agregado correctamente: " + titulo);
    }

    public void actualizarLibro(Scanner scanner) {
        System.out.println("=== ACTUALIZAR LIBRO ===");
        System.out.println("Ingresa el ID del libro que deseas actualizar:");
        int id = scanner.nextInt();
        scanner.nextLine();

        // Buscar el libro por ID agregar metodo de Nancy
        Libro libroActualizar = null;
        for (Libro libro : libros) {
            if (libro.getId() == id) {
                libroActualizar = libro;
                break;
            }
        }

        if (libroActualizar == null) {
            System.out.println("No se encontró un libro con el ID: " + id);
            return;
        }

        System.out.println("Libro encontrado: " + libroActualizar);
        System.out.println("¿Qué atributo deseas actualizar?");
        System.out.println("1. Título");
        System.out.println("2. Autor");
        System.out.println("3. Precio");
        System.out.println("4. ISBN");
        System.out.println("5. Género");
        System.out.println("6. Editorial");
        System.out.print("Selecciona una opción: ");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer

        switch (opcion) {
            case 1 -> {
                System.out.println("Nuevo título: ");
                String nuevoTitulo = scanner.nextLine();
                libroActualizar.setTitulo(nuevoTitulo);
            }
            case 2 -> {
                System.out.println("Nombre del autor: ");
                String nombre = scanner.nextLine();
                System.out.println("Apellido paterno: ");
                String paterno = scanner.nextLine();
                System.out.println("Apellido materno: ");
                String materno = scanner.nextLine();
                libroActualizar.setAutor(new Autor(nombre, paterno, materno));
            }
            case 3 -> {
                System.out.println("Nuevo precio: ");
                double nuevoPrecio = scanner.nextDouble();
                scanner.nextLine();
                libroActualizar.setPrecio(nuevoPrecio);
            }
            case 4 -> {
                System.out.println("Nuevo ISBN: ");
                String nuevoIsbn = scanner.nextLine();
                libroActualizar.setIsbn(nuevoIsbn);
            }
            case 5 -> {
                System.out.println("Elige nuevo género:");
                for (TipoGenero genero : TipoGenero.values()) {
                    System.out.println(genero.ordinal() + " - " + genero);
                }
                int opcionGenero = scanner.nextInt();
                scanner.nextLine();
                libroActualizar.setGenero(TipoGenero.values()[opcionGenero]);
            }
            case 6 -> {
                System.out.println("Nueva editorial: ");
                String nuevaEditorial = scanner.nextLine();
                libroActualizar.setEditorial(nuevaEditorial);
            }
            default -> System.out.println("Opción no válida.");
        }

        System.out.println("Libro actualizado correctamente: " + libroActualizar);
    }



}



