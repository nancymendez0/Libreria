package com.PINACOMP.Sistemalibreria.model.servicios;

import com.PINACOMP.Sistemalibreria.model.entidades.Administrador;
import com.PINACOMP.Sistemalibreria.model.entidades.Empleado;
import com.PINACOMP.Sistemalibreria.model.entidades.Libro;
import com.PINACOMP.Sistemalibreria.model.enums.TipoGenero;

import java.util.List;
import java.util.Scanner;

public class MenuService {
    static LibroService servicios = new LibroService();
    static List<Libro> biblioteca = servicios.obtenerLibros();
    static EmpleadoService serviciosEmpleados = new EmpleadoService();
    static AdminService serviciosAdmin = new AdminService();
    //static List<Empleado> oficina = serviciosAdmin.mostrarTodos();
    static Administrador ad1 = new Administrador("lalo9807","12345");
    static Empleado e1=null;
    public void menuCliente(){
        System.out.println("\nBienvenido a nuestro Menú");
        System.out.println("1. Mostrar todos los libros");
        System.out.println("2. Buscar por género");
        System.out.println("3. Buscar por autor");
        System.out.println("4. Buscar por título");
        System.out.println("5. Buscar por precio");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }
    public void menuEmpleado(){
        System.out.println("\nBienvenido a nuestro Menú");
        System.out.println("1. Mostrar todos los libros");
        System.out.println("2. Agregar un Libro");
        System.out.println("3. Actualizar un libro");
        System.out.println("4. Eliminar un libro");
        System.out.println("5. Realizar un reporte");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }
    public void menuAdmin(String administrador){
        System.out.println("\nBienvenido " + administrador +"\n ¿Qué deseas realizar");
        System.out.println("1. Mostrar información de empleados");
        System.out.println("2. Calcular el pago de un empleado");
        System.out.println("3. Agregar a empleado");
        System.out.println("4. Actualizar información empleados");
        System.out.println("5. Eliminar información empleado");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }
    public void accionesCliente(int opcion, Scanner scanner){
        switch (opcion) {
            case 1 -> servicios.mostrarLibros(biblioteca);

            case 2 -> {
                System.out.println("Seleccione el número correspondiente al género");
                TipoGenero[] generos = TipoGenero.values();
                for(int i=0; i<generos.length; i++){
                    System.out.println((i+1)+" - "+ generos[i]);
                }
                System.out.println("Opcion: ");
                int opcionGenero=scanner.nextInt();
                scanner.nextLine();
                if(opcionGenero<1 || opcionGenero>generos.length){
                    System.out.println("Opcion no válida");
                }else{
                    TipoGenero generoSeleccionado= generos[opcionGenero-1];
                    System.out.println("Has seleccionado: "+generoSeleccionado);
                    boolean encontrado = false;
                    for(Libro libro : biblioteca){
                        List<Libro> encontrados = libro.busquedaGeneroLibro(generoSeleccionado);
                        if(!encontrados.isEmpty()){
                            servicios.mostrarLibros(encontrados);
                            encontrado=true;
                        }
                    }
                    if(!encontrado){
                        System.out.println("No tenemos aún libros de ese género");
                    }
                }

            }

            case 3 -> {
                System.out.println("Ingresa el nombre del autor a buscar: ");
                String autorBusqueda= scanner.nextLine();
                for(Libro libro: biblioteca){
                    List<Libro> encontrados = libro.busquedaAutor(autorBusqueda);
                    if(!encontrados.isEmpty()){
                        servicios.mostrarLibros(encontrados);
                    }
                }

            }
            case 4 -> {
                System.out.println("Ingresa el titulo a buscar: ");
                String titulouscado = scanner.nextLine();
                for(Libro libro : biblioteca){
                    List<Libro> encontrado = libro.busquedaTitulo(titulouscado);
                    if(!encontrado.isEmpty()){
                        servicios.mostrarLibros(encontrado);
                    }
                }
            }
            case 5 -> {
                System.out.println("Busqueda por rango de precio");
                double min, max;
                System.out.println("Dame tu precio minimo");
                min=scanner.nextDouble();
                System.out.println("Dame tu precio maximo");
                max=scanner.nextDouble();
                for(Libro libro: biblioteca){
                    List<Libro> encontrados = libro.busquedaPrecio(min, max);
                    if (!encontrados.isEmpty()){
                        servicios.mostrarLibros(encontrados);
                    }
                }

            }
            case 0 -> System.out.println(" Saliendo del sistema...");
            default -> System.out.println(" Opción no válida.");
        }
    }
    public void accionesAdmin(int opcion , Scanner scanner){
        switch (opcion) {
            case 1 -> serviciosAdmin.mostrarTodos();
           // case 2 -> ad1.calcularSueldoMensual(oficina);
            case 3 -> serviciosAdmin.agregarEmpleado( scanner,e1);
            /*case 4 -> buscarPorTitulo();
            case 5 -> buscarPorPrecio();

             */
            case 0 -> System.out.println(" Saliendo del sistema...");
            default -> System.out.println(" Opción no válida.");
        }
    }
    public void accionesEmpleado(int opcion, Scanner scanner){
        switch (opcion) {
            case 1 -> serviciosEmpleados.mostrarLibros(biblioteca);
            case 2 -> serviciosEmpleados.agregarLibros(scanner);
            case 3 -> serviciosEmpleados.actualizarLibro(scanner);
            case 4 -> serviciosEmpleados.borrarLibro(scanner);
            case 0 -> System.out.println(" Saliendo del sistema...");
            default -> System.out.println(" Opción no válida.");
        }
    }

}
