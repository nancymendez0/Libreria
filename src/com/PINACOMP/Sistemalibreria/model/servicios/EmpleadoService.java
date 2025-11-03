package com.PINACOMP.Sistemalibreria.model.servicios;

import com.PINACOMP.Sistemalibreria.data.Biblioteca;
import com.PINACOMP.Sistemalibreria.data.Empleados;
import com.PINACOMP.Sistemalibreria.model.entidades.Autor;
import com.PINACOMP.Sistemalibreria.model.entidades.Empleado;
import com.PINACOMP.Sistemalibreria.model.entidades.Libro;
import com.PINACOMP.Sistemalibreria.model.enums.TipoGenero;
import com.sistemalibreria.excepciones.*;
import com.sistemalibreria.excepciones.ErroresEmpleados.NombreYApellidosInvalidoException;
import com.sistemalibreria.excepciones.ErroresEmpleados.ValidadorEmpleado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import static com.PINACOMP.Sistemalibreria.app.main.leerOpcion;
import static com.PINACOMP.Sistemalibreria.app.main.leerOpcionDouble;
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
        int id= leerOpcion();


        System.out.println("Titulo: ");
        String titulo=null;
        while(true){
            try{
                titulo = scanner.nextLine();
                TituloInvalidoException.validar(titulo);
                break;
            }catch (TituloInvalidoException e){
                System.out.println(e.getMessage());
            }
        }
        Autor autor = null;
        String nombreAutor=null,apellidoPaterno=null,apellidoMaterno=null;
        while(true) {
            try {
                System.out.println("Autor (Nombre)");
                nombreAutor = scanner.nextLine();
                ValidadorEmpleado.validarNombreCompleto(nombreAutor);
                break;
            } catch (NombreYApellidosInvalidoException e) {
                System.out.println(e.getMessage());
            }
        }
        while(true) {
            try {
                System.out.println("Autor (Apellido Paterno)");
                apellidoPaterno = scanner.nextLine();
                ValidadorEmpleado.validarNombreCompleto(apellidoPaterno);
                break;
            } catch (NombreYApellidosInvalidoException e) {
                System.out.println(e.getMessage());
            }
        }
        while(true) {
            try {
                System.out.println("Autor (Apellido Materno)");
                apellidoMaterno = scanner.nextLine();
                    ValidadorEmpleado.validarNombreCompleto(apellidoMaterno);
                break;
            } catch (NombreYApellidosInvalidoException e) {
                System.out.println(e.getMessage());
            }
        }

        autor = new Autor(nombreAutor, apellidoPaterno, apellidoMaterno);

        double precio=0;
        while(true){
            try {
            System.out.println("Precio: (Libro)");

            precio= leerOpcionDouble();
            PrecioInvalidoException.validar(precio);

            break;

            }catch (PrecioInvalidoException e){
                System.out.println(e.getMessage());
            }
        }
        String isbn="null";
        while (true){
            try {
                System.out.println("ISBN: ");
                isbn= scanner.nextLine();
                ISBNInvalidoException.validar(isbn);
                break;
            }catch (ISBNInvalidoException e){
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Género (Elige un número): ");
        for (TipoGenero genero : TipoGenero.values()){
            System.out.println(genero.ordinal()+ " - " + genero);
        }

        int opcionGenero = leerOpcion();

        TipoGenero generoSeleccionado = TipoGenero.values()[opcionGenero];
        String editorial=null;
        while(true){
            try {
                System.out.println("Editorial: ");
                editorial = scanner.nextLine();
                EditorialInvalidoException.validar(editorial);
                break;
            }catch (EditorialInvalidoException e){
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Dame la cantidad de libros en el stock");
        int stock= leerOpcion();

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

        int opcion = leerOpcion();
        switch (opcion) {
            case 1 -> {
                System.out.println("Nuevo título: ");

                while(true){
                    try{
                        String nuevoTitulo = scanner.nextLine();
                        TituloInvalidoException.validar(nuevoTitulo);
                        libroActualizar.setTitulo(nuevoTitulo);
                        break;//sale del while
                    }catch (TituloInvalidoException e){
                        System.out.println(e.getMessage());
                    }
                }
                break;
            }
            case 2 -> {
                try{
                    
                    System.out.println("Nombre del autor: ");
                    String entrada=scanner.nextLine();
                    //String nombre = validarNombre(entrada);
                    System.out.println("Apellido paterno: ");
                    String entrada2=scanner.nextLine();
                   // String paterno = validarNombre(entrada2);
                    System.out.println("Apellido materno: ");
                    String entrada3=scanner.nextLine();
                    //String materno = validarNombre(entrada3);
                    libroActualizar.setAutor(new Autor(entrada, entrada2, entrada3));
                    System.out.println("Autor actualizado correctamente.");
                }catch (NombreYApellidosInvalidoException e){
                    System.out.println("Error " +e.getMessage());
                }
                break;
            }
            case 3 -> {
                System.out.println("Nuevo precio: ");
                //String entrada =scanner.nextLine();
                while(true){
                    try{
                        double nuevoPrecio=0;
                        PrecioInvalidoException.validar(nuevoPrecio);
                        scanner.nextLine();
                        libroActualizar.setPrecio(nuevoPrecio);
                        System.out.println("Precio actualizado correctamente: " + libroActualizar);
                        break;
                    }catch (PrecioInvalidoException e){
                        System.out.println("Error " + e.getMessage());
                    }

                }
                break;
            }
            case 4 -> {
                while(true){
                    try{
                        System.out.println("Nuevo ISBN: ");
                        String nuevoIsbn = scanner.nextLine();
                        ISBNInvalidoException.validar(nuevoIsbn);
                        libroActualizar.setIsbn(nuevoIsbn);
                        break;

                    }catch (ISBNInvalidoException e){
                        System.out.println(e.getMessage());
                    }
                }
                break;
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
                while(true){
                    try{
                        System.out.println("Nueva editorial: ");
                        String nuevaEditorial = scanner.nextLine();
                        EditorialInvalidoException.validar(nuevaEditorial);
                        libroActualizar.setEditorial(nuevaEditorial);
                        break;

                    }catch (EditorialInvalidoException e){
                        System.out.println(e.getMessage());
                    }
                }
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
        int opcionBusqueda=leerOpcion();
        List<Libro> encontrados= new ArrayList<>();

        switch (opcionBusqueda){
            case 1: {
                int id;
                while(true){
                    System.out.println("Ingresa el ID del libro: ");
                    try{
                        id = Integer.parseInt(scanner.nextLine().trim());
                        break;
                    }catch (NumberFormatException e){
                        System.out.println("ID invalido.");
                    }
                }

                for (Libro libro : libros) {
                    if (libro.getId() == id) {
                        encontrados.add(libro);
                    }
                }
                break;
            }
            case 2: {
                String titulo=null;
                    while(true){
                        try{
                            System.out.println("Ingresa el título: ");
                            titulo =scanner.nextLine();
                            TituloInvalidoException.validar(titulo);
                            break;

                        }catch (TituloInvalidoException e){
                            System.out.println(e.getMessage());
                        }
                    }
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
            int indexLibro = leerOpcion()-1;

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
        int opcionBusqueda=leerOpcion();

        List<Libro> encontrados= new ArrayList<>();

        switch (opcionBusqueda){
            case 1: {
                System.out.println("Ingresa el ID del libro: ");
                int id;
                while(true){
                    System.out.println("Ingresa el ID del libro: ");
                    try{

                        id = Integer.parseInt(scanner.nextLine().trim());
                        break;
                    }catch (NumberFormatException e){
                        System.out.println("ID invalido.");
                    }

                }

                for (Libro libro : libros) {
                    if (libro.getId() == id) {
                        encontrados.add(libro);
                    }
                }
                break;
            }
            case 2: {

                String titulo=null;
                while(true){
                    try{
                        System.out.println("Ingresa el título: ");
                        titulo =scanner.nextLine();
                        TituloInvalidoException.validar(titulo);
                        break;

                    }catch (TituloInvalidoException e){
                        System.out.println(e.getMessage());
                    }
                }
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
            int indexLibro = leerOpcion() -1;
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



