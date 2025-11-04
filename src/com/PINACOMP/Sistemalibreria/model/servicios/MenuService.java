package com.PINACOMP.Sistemalibreria.model.servicios;

import com.PINACOMP.Sistemalibreria.model.entidades.Administrador;
import com.PINACOMP.Sistemalibreria.model.entidades.Cliente;
import com.PINACOMP.Sistemalibreria.model.entidades.Empleado;
import com.PINACOMP.Sistemalibreria.model.entidades.Libro;
import com.PINACOMP.Sistemalibreria.model.enums.TipoGenero;
import com.PINACOMP.Sistemalibreria.model.enums.TipoPuesto;
import com.PINACOMP.Sistemalibreria.model.enums.TipoSexo;
import com.sistemalibreria.excepciones.AutorNoEncontradoException;
import com.sistemalibreria.excepciones.PrecioInvalidoException;
import com.sistemalibreria.excepciones.TituloInvalidoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.PINACOMP.Sistemalibreria.app.main.*;

public class MenuService {
    static ClienteService servicios = new ClienteService();
    static List<Libro> biblioteca = servicios.obtenerLibros();
    static EmpleadoService serviciosEmpleados = new EmpleadoService();
    static AdminService2 serviciosAdmin = new AdminService2();
    static VentaService serviciosDeVenta = new VentaService();
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
        System.out.println("6. Realizar una compra");
        System.out.println("7. Realizar un prestamo");
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
        System.out.println("6. Buscar empleado");//buscador
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }
    public void accionesCliente(int opcion, Scanner scanner, Cliente cliente){
        switch (opcion) {
            case 1 -> servicios.mostrarLibros(biblioteca);

            case 2 -> {

                System.out.println("Seleccione el número correspondiente al género");
                TipoGenero[] generos = TipoGenero.values();
                for(int i=0; i<generos.length; i++){
                    System.out.println((i+1)+" - "+ generos[i]);
                }
                System.out.println("Opcion: ");
                int opcionGenero=leerOpcion();
                servicios.BusquedaPorGenero(opcionGenero, generos, biblioteca);
            }

            case 3 -> {
                String autorBusqueda=null;
                while(true){
                    System.out.println("Ingresa el nombre del autor a buscar: ");
                    try{
                        autorBusqueda= scanner.nextLine();
                        AutorNoEncontradoException.validar(autorBusqueda);
                        break;

                    }catch (AutorNoEncontradoException e){
                        System.out.println(e.getMessage());
                    }
                }
                for(Libro libro: biblioteca){
                    List<Libro> encontrados = libro.busquedaAutor(autorBusqueda);
                    if(!encontrados.isEmpty()){
                        servicios.mostrarLibros(encontrados);
                    }
                }

            }
            case 4 -> {
                System.out.println("Ingresa el titulo a buscar: ");
                String tituloBuscado=null;
                while(true){
                    try {
                        tituloBuscado = scanner.nextLine();
                        TituloInvalidoException.validar(tituloBuscado);
                        break;
                    }catch (TituloInvalidoException e){
                        System.out.println(e.getMessage());
                    }
                }
                for(Libro libro : biblioteca){
                    List<Libro> encontrado = libro.busquedaTitulo(tituloBuscado);
                    if(!encontrado.isEmpty()){
                        servicios.mostrarLibros(encontrado);
                    }
                }
            }
            case 5 -> {
                System.out.println("Busqueda por rango de precio");
                double min, max;
                while(true){
                    try{
                        double entradaGlobal=0;

                        System.out.println("Dame tu precio minimo");
                        min=leerOpcionDouble();
                        PrecioInvalidoException.validar(min);
                        System.out.println("Dame tu precio maximo");
                        max=leerOpcionDouble();
                        PrecioInvalidoException.validar(max);
                        if (max < min){
                            System.out.println("El precio maximo no puede ser menor al mínimo. Intenta de nuevo.");
                            continue;
                        }
                        break;


                    }catch (PrecioInvalidoException e){
                        System.out.println(e.getMessage());
                    }

                }
                for(Libro libro: biblioteca){
                    List<Libro> encontrados = libro.busquedaPrecio(min, max);
                    if (!encontrados.isEmpty()){
                        servicios.mostrarLibros(encontrados);
                    }
                }

            }
            case 6 ->{
                System.out.println("¿Qué titulo del libro deseas comprar?");
                servicios.mostrarLibros(biblioteca);
                System.out.println("Ingresa el titulo");
                String tituloCompra=leerDatos();
                serviciosDeVenta.venderPorTitulo(tituloCompra,cliente,biblioteca);


            }

            case 0 -> System.out.println(" Saliendo del sistema...");
            default -> System.out.println(" Opción no válida.");
        }
    }
    //método buscar Empleado
    private void buscarEmpleado(Scanner scanner) {
        String opcionTexto = serviciosAdmin.leerConValidacion(scanner, """
        ¿Cómo deseas buscar al empleado?
        1 - Por ID
        2 - Por nombre
        3 - Por apellido paterno
        4 - Por sexo
        5 - Por puesto
        Ingresa una opción (1-5):
        """);
        if (opcionTexto == null) return;

        int opcion;
        try {
            opcion = Integer.parseInt(opcionTexto);
        } catch (NumberFormatException e) {
            System.out.println("✘ Entrada inválida. Debe ser un número.");
            return;
        }

        List<Empleado> resultados = new ArrayList<>();

        switch (opcion) {
            case 1 -> {
                String idTexto = serviciosAdmin.leerConValidacion(scanner, "Ingresa el ID:");
                if (idTexto == null) return;
                try {
                    int id = Integer.parseInt(idTexto);
                    Empleado e = serviciosAdmin.buscarEmpleado(id);
                    if (e != null) resultados.add(e);
                } catch (NumberFormatException e) {
                    System.out.println("✘ Entrada inválida. Debe ser un número.");
                }
            }
            case 2 -> {
                String nombre = serviciosAdmin.leerConValidacion(scanner, "Ingresa el nombre:");
                if (nombre == null) return;
                resultados = serviciosAdmin.busquedaNombre(nombre);
            }
            case 3 -> {
                String apellido = serviciosAdmin.leerConValidacion(scanner, "Ingresa el apellido paterno:");
                if (apellido == null) return;
                resultados = serviciosAdmin.busquedaApellido(apellido);
            }
            case 4 -> {
                TipoSexo[] sexos = TipoSexo.values();
                System.out.println("Selecciona el sexo:");
                for (int i = 0; i < sexos.length; i++) {
                    System.out.println((i + 1) + " - " + sexos[i]);
                }

                String indexTexto = serviciosAdmin.leerConValidacion(scanner, "Ingresa el número del sexo:");
                if (indexTexto == null) return;
                try {
                    int index = Integer.parseInt(indexTexto) - 1;
                    if (index >= 0 && index < sexos.length) {
                        resultados = serviciosAdmin.busquedaSexo(sexos[index]);
                    } else {
                        System.out.println("✘ Opción fuera de rango.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("✘ Entrada inválida. Debe ser un número.");
                }
            }
            case 5 -> {
                TipoPuesto[] puestos = TipoPuesto.values();
                System.out.println("Selecciona el puesto:");
                for (int i = 0; i < puestos.length; i++) {
                    System.out.println((i + 1) + " - " + puestos[i]);
                }

                String indexTexto = serviciosAdmin.leerConValidacion(scanner, "Ingresa el número del puesto:");
                if (indexTexto == null) return;
                try {
                    int index = Integer.parseInt(indexTexto) - 1;
                    if (index >= 0 && index < puestos.length) {
                        resultados = serviciosAdmin.busquedaPuesto(puestos[index]);
                    } else {
                        System.out.println("✘ Opción fuera de rango.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("✘ Entrada inválida. Debe ser un número.");
                }
            }
            default -> System.out.println("✘ Opción inválida.");
        }

        if (resultados.isEmpty()) {
            System.out.println("✘ No se encontraron empleados con ese criterio.");
        } else {
            for (Empleado e : resultados) {
                System.out.println("ID: " + e.getId() + " | " + e.getNombreCompleto()
                        + " | " + e.getCorreo() + " | " + e.getPuesto());
            }
        }
    }
    public void accionesAdmin(int opcion , Scanner scanner){
        switch (opcion) {
            case 1 -> serviciosAdmin.mostrarTodos();
            case 2 -> serviciosAdmin.calcularPagoEmpleado();
            case 3 -> serviciosAdmin.agregarEmpleado(scanner);
            case 4 -> serviciosAdmin.actualizarEmpleado(scanner);
            case 5 -> serviciosAdmin.eliminarEmpleado();
            case 6 -> buscarEmpleado(scanner);//nuevo

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
