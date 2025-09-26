package com.PINACOMP.Sistemalibreria.model.servicios;

import com.PINACOMP.Sistemalibreria.model.entidades.Administrador;
import com.PINACOMP.Sistemalibreria.model.entidades.Empleado;
import com.PINACOMP.Sistemalibreria.model.entidades.Libro;

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
    public void accionesCliente(int opcion){
        switch (opcion) {
            case 1 -> servicios.mostrarLibros(biblioteca);

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

}
