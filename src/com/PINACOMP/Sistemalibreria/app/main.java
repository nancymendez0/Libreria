package com.PINACOMP.Sistemalibreria.app;

import com.PINACOMP.Sistemalibreria.data.Biblioteca;
import com.PINACOMP.Sistemalibreria.model.entidades.*;
import com.PINACOMP.Sistemalibreria.model.enums.TipoPuesto;
import com.PINACOMP.Sistemalibreria.model.enums.TipoSexo;
import com.PINACOMP.Sistemalibreria.model.interfaces.OperacionBiblioteca;
import com.PINACOMP.Sistemalibreria.servicios.Empleado;
import com.PINACOMP.Sistemalibreria.servicios.EmpleadoServicios;
import com.sistemalibreria.excepciones.*;
import com.sistemalibreria.excepciones.ValidadorEmpleado;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;

public class main {
    static final Scanner sc = new Scanner(System.in);
    static final List<Libro> biblioteca = Biblioteca.crearBiblioteca();
    static final BuscadorObras buscador = new BuscadorObras(biblioteca) {
        public List<Libro> buscar(String criterio) {
            return List.of(); // Implementación vacía
        }
    };
    static final List<OperacionBiblioteca> operaciones = List.of(
            new Venta(101, LocalDate.now(), biblioteca.get(0), biblioteca.get(0).getPrecio()),
            new Prestamo(102, LocalDate.now(), 1, biblioteca.get(1), LocalDate.now().plusDays(7)),
            new Devolucion(103, LocalDate.now(), 102, biblioteca.get(2), false, 0.0)
    );
    static final EmpleadoServicios empleados = new EmpleadoServicios();

    public static void main(String[] args) {
        while (true) {
            int opcion = leerInt(menu());
            if (opcion == 0) break;
            ejecutar(opcion);
        }
    }

    static String menu() {
        return """
                MENÚ PRINCIPAL
                1. Mostrar libros
                2. Buscar por género
                3. Buscar por autor
                4. Buscar por título
                5. Buscar por precio
                6. Mostrar operaciones
                7. Agregar empleado
                8. Consultar empleado
                9. Actualizar empleado
                10. Eliminar empleado
                11. Mostrar todos los empleados
                12. Mostrar empleados ordenados por ID
                0. Salir
                Opción: """;
    }

    static void ejecutar(int op) {
        switch (op) {
            case 1 -> mostrar(biblioteca);
            case 2 -> buscar("género", buscador::buscarPorGenero);
            case 3 -> buscar("autor", buscador::busquedaAutor);
            case 4 -> buscar("título", buscador::busquedaTitulo);
            case 5 -> buscarPrecio();
            case 6 -> resumen();
            case 7 -> empleado("agregar");
            case 8 -> empleado("consultar");
            case 9 -> empleado("actualizar");
            case 10 -> empleado("eliminar");
            case 11 -> mostrarTodosLosEmpleados();
            case 12 -> mostrarEmpleadosOrdenadosPorId();
            default -> System.out.println("Opción inválida.");
        }
    }

    static int leerInt(String msg) {
        System.out.print(msg);
        while (!sc.hasNextInt()) {
            System.out.print("Inválido. " + msg);
            sc.next();
        }
        int val = sc.nextInt();
        sc.nextLine();
        return val;
    }

    static String leer(String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }

    static void buscar(String tipo, Function<String, List<Libro>> f) {
        try {
            mostrar(f.apply(leer("Ingrese " + tipo + ": ")));
        } catch (ValidacionUsuarioException e) {
            System.out.println(e.getMessage());
        }
    }

    static void buscarPrecio() {
        try {
            mostrar(buscador.busquedaPrecio(Double.parseDouble(leer("Precio: "))));
        } catch (Exception e) {
            System.out.println("Precio inválido.");
        }
    }

    static void mostrar(List<Libro> libros) {
        if (libros.isEmpty()) System.out.println("No hay resultados.");
        else for (int i = 0; i < libros.size(); i++)
            System.out.println("LIBRO " + (i + 1) + ":\n" + libros.get(i) + "\n");
    }

    static void resumen() {
        Set<String> tipos = new HashSet<>();
        for (OperacionBiblioteca op : operaciones) {
            String tipo = op.getTipoOperacion().name();
            if (tipos.add(tipo)) System.out.println(tipo + ":");
            op.mostrarResumen();
            if (tipos.size() == 3) break;
        }
    }

    static void empleado(String accion) {
        int id = leerInt("ID: ");

        if (accion.equals("consultar")) {
            Empleado e = empleados.obtenerEmpleado(id);
            if (e != null) {
                System.out.println("ID: " + e.getId() + " | " + e.getNombreCompleto() +
                        " | " + e.getCorreo() + " | " + e.getPuesto());
            } else {
                System.out.println("No existe un empleado con ese ID.");
            }
            return;
        }

        if (accion.equals("eliminar")) {
            if (empleados.existeEmpleado(id)) {
                empleados.eliminarEmpleado(id);
                System.out.println("Empleado eliminado.");
            } else {
                System.out.println("No existe un empleado con ese ID.");
            }
            return;
        }

        System.out.println("""
                Ingrese los datos del empleado respetando el formato. Ejemplo:

                Nombre: Laura
                Apellido: Martínez
                Correo: laura.martinez@correo.com
                Sexo: FEMENINO
                Puesto: AUXILIAR
                Edad: 28

                Reglas:
                - Nombre y apellido: solo letras y espacios
                - Correo: debe contener '@' y terminar en '.com'
                - Sexo válido: """ + Arrays.toString(TipoSexo.values()) + """
                - Puesto válido: """ + Arrays.toString(TipoPuesto.values()) + """
                - Edad: número entero positivo
                """);

        String n = leer("Nombre: ");
        String a = leer("Apellido: ");
        String c = leer("Correo: ");
        String s = leer("Sexo: ").toUpperCase();
        String pStr = leer("Puesto: ").toUpperCase();
        int edad = leerInt("Edad: ");

        try {
            ValidadorEmpleado.validarNombre(n);
            ValidadorEmpleado.validarNombre(a);
            ValidadorEmpleado.validarCorreo(c);
            ValidadorEmpleado.validarEdad(edad);
            TipoSexo sexo = ValidadorEmpleado.validarSexo(s);
            TipoPuesto puesto = ValidadorEmpleado.validarEnum(TipoPuesto.class, pStr, new PuestoNoReconocidoException("Puesto inválido: " + pStr));

            Empleado emp = new Empleado(id, n, a, c, edad, sexo, puesto);

            if (accion.equals("agregar")) {
                empleados.agregarEmpleado(emp);
                System.out.println("Empleado agregado correctamente.");
            } else {
                empleados.actualizarEmpleado(id, emp);
                System.out.println("Empleado actualizado correctamente.");
                System.out.println("Datos actualizados: " + emp.getNombreCompleto() + " | " + emp.getCorreo() + " | " + emp.getPuesto());
            }

        } catch (RuntimeException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    static void mostrarTodosLosEmpleados() {
        Map<Integer, Empleado> mapa = empleados.obtenerTodos();
        if (mapa.isEmpty()) {
            System.out.println("No hay empleados registrados.");
            return;
        }

        for (Empleado e : mapa.values()) {
            System.out.println("ID: " + e.getId() + " | " + e.getNombreCompleto() +
                    " | " + e.getCorreo() + " | " + e.getPuesto());
        }
    }

    static void mostrarEmpleadosOrdenadosPorId() {
        Map<Integer, Empleado> mapa = empleados.obtenerTodos();
        if (mapa.isEmpty()) {
            System.out.println("No hay empleados registrados.");
            return;
        }

        mapa.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    Empleado e = entry.getValue();
                    System.out.println("ID: " + entry.getKey() + " | " +
                            e.getNombreCompleto() + " | " +
                            e.getCorreo() + " | " + e.getPuesto());
                });
    }
}
