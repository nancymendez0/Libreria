package com.PINACOMP.Sistemalibreria.model.servicios;

import com.PINACOMP.Sistemalibreria.data.Biblioteca;
import com.PINACOMP.Sistemalibreria.data.Empleados;
import com.PINACOMP.Sistemalibreria.model.entidades.Autor;
import com.PINACOMP.Sistemalibreria.model.entidades.Empleado;
import com.PINACOMP.Sistemalibreria.model.entidades.Libro;
import com.PINACOMP.Sistemalibreria.model.enums.TipoGenero;
import com.sistemalibreria.excepciones.AutorNoEncontradoException;
import com.sistemalibreria.excepciones.ErroresEmpleados.NombreYApellidosInvalidoException;
import com.sistemalibreria.excepciones.GeneroNoReconocidoException;
import com.sistemalibreria.excepciones.PrecioInvalidoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.sistemalibreria.excepciones.ErroresEmpleados.NombreYApellidosInvalidoException.validarNombre;
import static com.sistemalibreria.excepciones.GeneroNoReconocidoException.validarGenero;
import static com.sistemalibreria.excepciones.PrecioInvalidoException.validar;


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
        Autor autor = null;
        try{
            System.out.println("Autor (Nombre)");
            String nombreAutor = scanner.nextLine();
            AutorNoEncontradoException.validar(nombreAutor);
            System.out.println("Autor (Apellido Paterno)");
            String apellidoPaterno = scanner.nextLine();

            System.out.println("Autor (Apellido Materno)");
            String apellidoMaterno = scanner.nextLine();
            autor = new Autor( nombreAutor, apellidoPaterno, apellidoMaterno);
        }catch (AutorNoEncontradoException e){
            System.out.println("Error: " + e.getMessage());
            return;
        }



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
        System.out.println("Dame la cantidad de libros en el stock");
        int stock= scanner.nextInt();
        scanner.nextLine();

        Libro nuevoLibro= new Libro (id,titulo,autor,precio,isbn,generoSeleccionado,editorial, stock);
        libros.add(nuevoLibro);
        System.out.println("Libro agregado correctamente: " + titulo);
    }


    public void actualizarAtributos(Libro libroActualizar, Scanner scanner){
        System.out.println("Libro encontrado: ");
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
                break;
            }
            case 2 -> {
                try{
                    
                    System.out.println("Nombre del autor: ");
                    String entrada=scanner.nextLine();
                    String nombre = validarNombre(entrada);
                    System.out.println("Apellido paterno: ");
                    String entrada2=scanner.nextLine();
                    String paterno = validarNombre(entrada2);
                    System.out.println("Apellido materno: ");
                    String entrada3=scanner.nextLine();
                    String materno = validarNombre(entrada3);
                    libroActualizar.setAutor(new Autor(nombre, paterno, materno));
                    System.out.println("Autor actualizado correctamente.");
                }catch (NombreYApellidosInvalidoException e){
                    System.out.println("Error " +e.getMessage());
                }
                break;
            }
            case 3 -> {
                System.out.println("Nuevo precio: ");
                String entrada =scanner.nextLine();
                try{
                    double nuevoPrecio = validar(entrada);
                    scanner.nextLine();
                    libroActualizar.setPrecio(nuevoPrecio);
                    System.out.println("Precio actualizado correctamente: " + libroActualizar);
                }catch (PrecioInvalidoException e){
                    System.out.println("Error " + e.getMessage());
                }
                break;
            }
            case 4 -> {
                System.out.println("Nuevo ISBN: ");
                String nuevoIsbn = scanner.nextLine();
                libroActualizar.setIsbn(nuevoIsbn);
            }
            case 5 -> {
                System.out.println("Géneros disponibles:  " + GeneroNoReconocidoException.obtenerGenerosValidos());

                System.out.println("Escribe el nuevo género: ");

                String entradaGenero=scanner.nextLine().trim();
                try{
                    validarGenero(entradaGenero);
                    libroActualizar.setGenero(TipoGenero.valueOf(entradaGenero.toUpperCase()));
                    System.out.println("Género actualizado correctamente.");

                }catch (GeneroNoReconocidoException e){
                    System.out.println("Error. "+ e.getMessage());
                }

                break;
            }
            case 6 -> {
                System.out.println("Nueva editorial: ");
                String nuevaEditorial = scanner.nextLine();
                libroActualizar.setEditorial(nuevaEditorial);
                break;
            }
            default -> System.out.println("Opción no válida.");
        }


    }
    public void actualizarLibro(Scanner scanner) {
        System.out.println("=== ACTUALIZAR LIBRO ===");
        System.out.println("¿Cómo deseas buscar el libro?");
        System.out.println("1. Por ID");
        System.out.println("2. Por Título");
        System.out.println("3. Por Autor");
        int opcionBusqueda=scanner.nextInt();
        scanner.nextLine();
        List<Libro> encontrados= new ArrayList<>();

        switch (opcionBusqueda){
            case 1: {
                System.out.println("Ingresa el ID del libro: ");
                int id;
                try{

                    id = Integer.parseInt(scanner.nextLine().trim());

                }catch (NumberFormatException e){
                    System.out.println("ID invalido.");
                    return;
                }

                for (Libro libro : libros) {
                    if (libro.getId() == id) {
                        encontrados.add(libro);
                    }
                }
                break;
            }
            case 2: {

                    System.out.println("Ingresa el título: ");
                    String titulo =scanner.nextLine();
                    for(Libro libro : libros){
                        encontrados.addAll(libro.busquedaTitulo(titulo));
                    }
                    break;

            }
            case 3: {
                    System.out.println("Ingresa el nombre del autor: ");
                    String autor = scanner.nextLine();
                    AutorNoEncontradoException.validar(autor);
                    for(Libro libro : libros){
                        encontrados.addAll(libro.busquedaAutor(autor));
                    }
                    break;

            }
            default:{
                System.out.println("opcion invalida.");
            }

        }



        if (encontrados.isEmpty()) {
            System.out.println("No se encontró ningún libro");
            return;
        }
        if(encontrados.size()>1){
            System.out.println("Se encontraron varios libros: ");
            for(int i=0; i<encontrados.size(); i++){
                System.out.println((i+1)+ ". " + encontrados.get(i));
            }
            System.out.println("Selecciona el número del libro ue deseas actualizar: ");
            int indexLibro = scanner.nextInt() -1;
            scanner.nextLine();
            if(indexLibro<0 || indexLibro>=encontrados.size()){
                System.out.println("Seleccion invalida");
                return;
            }
            actualizarAtributos(encontrados.get(indexLibro), scanner);
        }else{
            actualizarAtributos(encontrados.get(0), scanner);
        }


    }

    public void borrarLibro(Scanner scanner){
        System.out.println("=== Borrar LIBRO ===");
        System.out.println("¿Cómo deseas buscar el libro?");
        System.out.println("1. Por ID");
        System.out.println("2. Por Título");
        System.out.println("3. Por Autor");
        int opcionBusqueda=scanner.nextInt();
        scanner.nextLine();
        List<Libro> encontrados= new ArrayList<>();

        switch (opcionBusqueda){
            case 1: {
                System.out.println("Ingresa el ID del libro: ");
                int id;
                try{

                    id = Integer.parseInt(scanner.nextLine().trim());

                }catch (NumberFormatException e){
                    System.out.println("ID invalido.");
                    return;
                }

                for (Libro libro : libros) {
                    if (libro.getId() == id) {
                        encontrados.add(libro);
                    }
                }
                break;
            }
            case 2: {

                System.out.println("Ingresa el título: ");
                String titulo =scanner.nextLine();
                for(Libro libro : libros){
                    encontrados.addAll(libro.busquedaTitulo(titulo));
                }
                break;

            }
            case 3: {
                System.out.println("Ingresa el nombre del autor: ");
                String autor = scanner.nextLine();
                AutorNoEncontradoException.validar(autor);
                for(Libro libro : libros){
                    encontrados.addAll(libro.busquedaAutor(autor));
                }
                break;

            }
            default:{
                System.out.println("opcion invalida.");
            }

        }



        if (encontrados.isEmpty()) {
            System.out.println("No se encontró ningún libro");
            return;
        }
        if(encontrados.size()>1){
            System.out.println("Se encontraron varios libros: ");
            for(int i=0; i<encontrados.size(); i++){
                System.out.println((i+1)+ ". " + encontrados.get(i));
            }
            System.out.println("Selecciona el número del libro que deseas borrar: ");
            int indexLibro = scanner.nextInt() -1;
            scanner.nextLine();
            if(indexLibro<0 || indexLibro>=encontrados.size()){
                System.out.println("Seleccion invalida");
                return;
            }
            confirmarBorrado(encontrados.get(indexLibro), scanner);
        }else{
            confirmarBorrado(encontrados.get(0), scanner);
        }
    }

    private void confirmarBorrado(Libro libro, Scanner scanner) {
        System.out.println("¿Estás seguro de borrar este libro? " + libro.getTitulo() + " (Y/N)");
        char decision = scanner.next().charAt(0);
        if (decision == 'Y' || decision == 'y') {
            libros.remove(libro);
            System.out.println("Libro borrado exitosamente.");
        } else {
            System.out.println("Operación cancelada.");
        }
    }


}



