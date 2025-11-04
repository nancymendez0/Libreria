package com.PINACOMP.Sistemalibreria.model.servicios;

import com.PINACOMP.Sistemalibreria.data.Empleados;
import com.PINACOMP.Sistemalibreria.model.entidades.Empleado;
import com.PINACOMP.Sistemalibreria.model.enums.TipoPuesto;
import com.PINACOMP.Sistemalibreria.model.enums.TipoSexo;
import com.PINACOMP.Sistemalibreria.model.interfaces.BuscadorEmpleados;
import com.sistemalibreria.excepciones.ErroresEmpleados.*;

import java.util.*;

import static com.PINACOMP.Sistemalibreria.app.main.scanner;

public class AdminService2 implements BuscadorEmpleados {

    private final Map<Integer, Empleado> empleado = new HashMap<>();

    public AdminService2() {

        for (Empleado e : Empleados.obtenerEmpleados()) {
            empleado.put(e.getId(), e);
        }
    }

    // MÉTODO REUTILIZABLE PARA VALIDAR ENTRADAS CON 3 SALTOS
    public String leerConValidacion(Scanner scanner, String mensaje) {
        int intentosVacios = 0;
        while (intentosVacios < 3) {
            System.out.println(mensaje + " (o escriba 'salir' para cancelar):");
            String entrada = scanner.nextLine().trim();
            if (entrada.equalsIgnoreCase("salir")) {
                System.out.println("✘ Operación cancelada por el usuario.");
                return null;
            }
            if (entrada.isEmpty()) {
                intentosVacios++;
                if (intentosVacios == 3) {
                    System.out.println("✘ Demasiados intentos vacíos. Cancelando operación.");
                    return null;
                }
                continue;
            }
            return entrada;
        }
        return null;
    }

    public void agregarEmpleado(Scanner scanner) {
        String idTexto = leerConValidacion(scanner, "Ingrese el ID del empleado");
        if (idTexto == null) return;
        int id = Integer.parseInt(idTexto);

        if (empleado.containsKey(id)) {
            System.out.println("✘ Ya existe un empleado con ese ID.");
            return;
        }
        Empleado nuevo = capturarDatosEmpleado(scanner, id);
        empleado.put(id, nuevo);
        System.out.println("✔ Empleado agregado correctamente.");



    }

    public void actualizarEmpleado(Scanner scanner) {
        try {
            String idTexto = leerConValidacion(scanner, "ID del empleado a actualizar");
            if (idTexto == null) return;
            int id = Integer.parseInt(idTexto);

            if (!empleado.containsKey(id)) {
                System.out.println("✘ No se encontró ningún empleado con ID: " + id);
                return;
            }

            mostrarEmpleado(empleado.get(id));
            if (!confirmar(scanner, "¿Deseas modificar este empleado? (s/n): ")) {
                System.out.println("✘ Operación cancelada.");
                return;
            }

            Empleado actualizado = capturarDatosEmpleado(scanner, id);
            if (confirmar(scanner, "¿Confirmas la actualización? (s/n): ")) {
                empleado.put(id, actualizado);
                System.out.println("✔ Empleado actualizado correctamente.");
            } else {
                System.out.println("✘ Actualización cancelada.");
            }

        } catch (RuntimeException e) {
            System.out.println("✘ Error: " + e.getMessage());
        }
    }

    public Empleado capturarDatosEmpleado(Scanner scanner, int id) {
        String entradaGlobal;//verifique que no haya datos vacios
        String nombre=null, apellidoP=null, apellidoM=null, correo=null, contraseña=null;
        int edad=0, numEmpleado=0;
        double sueldo=0.0;
        while(true){
            entradaGlobal = leerConValidacion(scanner, "Nombre");
            try {
                ValidadorEmpleado.validarNombreCompleto(entradaGlobal);
                nombre = entradaGlobal;
                break;
            } catch (NombreYApellidosInvalidoException e) {
                System.out.println(e.getMessage());
            }

        }
        while(true){
            entradaGlobal = leerConValidacion(scanner, "Apellido paterno");//valida 3 saltos para no seguir guardando datos
            try {
                ValidadorEmpleado.validarNombreCompleto(entradaGlobal);
                apellidoP = entradaGlobal;
                break;
            } catch (NombreYApellidosInvalidoException e) {
                System.out.println(e.getMessage());
            }

        }
        while(true){
            entradaGlobal = leerConValidacion(scanner, "Apellido materno");
            try {
                ValidadorEmpleado.validarNombreCompleto(entradaGlobal);
                apellidoM = entradaGlobal;
                break;
            } catch (NombreYApellidosInvalidoException e) {
                System.out.println(e.getMessage());
            }

        }
        while(true){

            entradaGlobal = leerConValidacion(scanner, "Correo");
            try {
                ValidadorEmpleado.validarCorreo(entradaGlobal);
                correo = entradaGlobal;
                break;
            } catch (CorreoInvalidoException e) {
                System.out.println(e.getMessage());
            }
        }
        while(true){
            entradaGlobal = leerConValidacion(scanner, "Edad");
            int entradaNum = 0;
            try {
                entradaNum = Integer.parseInt(entradaGlobal);
                ValidadorEmpleado.validarEdad(entradaNum);
                edad = entradaNum;
                break;
            } catch (EdadInvalidaException e) {
                System.out.println(e.getMessage());
            }

        }
        while(true){

            entradaGlobal = leerConValidacion(scanner, "Sueldo semanal");
            try{
                double entradaDouble = Double.parseDouble(entradaGlobal);
                SueldoInvalidoException.validar(entradaDouble);
                sueldo=entradaDouble;
                break;
            }catch (SueldoInvalidoException e){
                System.out.println(e.getMessage());
            }
        }

        entradaGlobal = leerConValidacion(scanner, "Número de empleado");
        int entradaNum = Integer.parseInt(entradaGlobal);
        numEmpleado = entradaNum;


        while(true){

        entradaGlobal = leerConValidacion(scanner, "Contraseña");
        try{
            ContraseniaInvalidaException.validar(entradaGlobal);
            contraseña=entradaGlobal;
            break;
        }catch (ContraseniaInvalidaException e){
            System.out.println(e.getMessage());
        }
        }

        //detiene el proceso si los campos estan nulos por salto de linea
        if (entradaGlobal == null) {
            throw new RuntimeException("✘ Datos incompletos.");
        }
        TipoSexo sexo = seleccionarEnum(scanner, TipoSexo.values(), "Sexo");
        TipoPuesto puesto = seleccionarEnum(scanner, TipoPuesto.values(), "Puesto");
        //construye el empleado con las validaciones
        //Validar nombre y apellidos
        return new Empleado(id, nombre, apellidoP, apellidoM, edad, sexo, numEmpleado, sueldo, contraseña, puesto);
    }

    //confirma antes de actualizar o eliminar un empleado
    private boolean confirmar(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        String respuesta = scanner.nextLine().trim().toLowerCase();
        return respuesta.equals("s") || respuesta.equals("sí");
    }

    private <T extends Enum<T>> T seleccionarEnum(Scanner scanner, T[] opciones, String etiqueta) {
        System.out.println("Selecciona " + etiqueta + ":");
        for (int i = 0; i < opciones.length; i++) {
            System.out.println((i + 1) + ". " + opciones[i]);
        }

        while (true) {
            String entrada = leerConValidacion(scanner, "Ingrese el número de opción");
            if (entrada == null) throw new RuntimeException("✘ Selección cancelada.");
            try {
                int opcion = Integer.parseInt(entrada);
                if (opcion >= 1 && opcion <= opciones.length) {
                    return opciones[opcion - 1];
                } else {
                    System.out.println("✘ Opción fuera de rango.");
                }
            } catch (NumberFormatException e) {
                System.out.println("✘ Entrada inválida. Debe ser un número.");
            }
        }
    }

    private void mostrarEmpleado(Empleado e) {
        System.out.println("ID: " + e.getId());
        System.out.println("Nombre: " + e.getNombre());
        System.out.println("Apellido: " + e.getApellidoPaterno());
        System.out.println("Correo: " + e.getCorreo());
        System.out.println("Edad: " + e.getEdad());
        System.out.println("Sexo: " + e.getSexo());
        System.out.println("Número de empleado: " + e.getNumEmpleado());
        System.out.println("Sueldo semanal: " + e.getSueldoSemanal());
        System.out.println("Puesto: " + e.getPuesto());
    }


    public void eliminarEmpleado() {
        Scanner scanner = new Scanner(System.in);
        String idTexto = leerConValidacion(scanner, "Ingrese el ID del empleado a eliminar");
        if (idTexto == null) return;

        try {
            int id = Integer.parseInt(idTexto);
            Empleado e = empleado.get(id);
            if (e == null) {
                System.out.println("✘ No se encontró un empleado con ese ID.");
                return;
            }

            mostrarEmpleado(e);
            if (confirmar(scanner, "¿Está seguro que desea eliminar al empleado? (s/n): ")) {
                empleado.remove(id);
                System.out.println("✔ Empleado eliminado.");
            } else {
                System.out.println("✘ Operación cancelada.");
            }

        } catch (NumberFormatException e) {
            System.out.println("✘ Entrada inválida. Debe ser un número.");
        }
    }

    public void calcularPagoEmpleado() {
        Scanner scanner = new Scanner(System.in);
        String entrada = leerConValidacion(scanner, "Ingrese el ID del empleado para calcular su pago");
        if (entrada == null) return;

        try {
            int id = Integer.parseInt(entrada);
            Empleado e = empleado.get(id);
            if (e == null) {
                System.out.println("✘ No se encontró un empleado con ese ID.");
                return;
            }

            System.out.println("✔ El pago semanal del empleado " + e.getNombreCompleto() + " es: $" + e.getSueldoSemanal());

        } catch (NumberFormatException e) {
            System.out.println("✘ Entrada inválida. Debe ser un número.");
        }
    }

    public Empleado buscarEmpleado(int id) {
        Scanner scanner = new Scanner(System.in);
        String entrada = leerConValidacion(scanner, "Ingrese el ID del empleado a buscar");
        if (entrada == null) return null;

        try {
            id = Integer.parseInt(entrada);
            List<Empleado> resultado = busquedaId(id);
            if (resultado.isEmpty()) {
                System.out.println("✘ No se encontró ningún empleado con ID: " + id);
            } else {
                resultado.forEach(this::mostrarEmpleado);
            }
        } catch (NumberFormatException e) {
            System.out.println("✘ Entrada inválida. Debe ser un número.");
        }
        return null;
    }


        public void buscarPorNombre () {
            Scanner scanner = new Scanner(System.in);
            String nombre = leerConValidacion(scanner, "Ingrese el nombre del empleado");
            if (nombre == null) return;

            List<Empleado> resultado = busquedaNombre(nombre);
            if (resultado.isEmpty()) {
                System.out.println("✘ No se encontraron empleados con ese nombre.");
            } else {
                resultado.forEach(this::mostrarEmpleado);
            }
        }

        public void buscarPorApellido () {
            Scanner scanner = new Scanner(System.in);
            String apellido = leerConValidacion(scanner, "Ingrese el apellido paterno del empleado");
            if (apellido == null) return;

            List<Empleado> resultado = busquedaApellido(apellido);
            if (resultado.isEmpty()) {
                System.out.println("✘ No se encontraron empleados con ese apellido.");
            } else {
                resultado.forEach(this::mostrarEmpleado);
            }
        }

        public void buscarPorSexo () {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Seleccione el sexo:");
            for (int i = 0; i < TipoSexo.values().length; i++) {
                System.out.println((i + 1) + ". " + TipoSexo.values()[i]);
            }

            String entrada = leerConValidacion(scanner, "Ingrese el número del sexo");
            if (entrada == null) return;

            try {
                int opcion = Integer.parseInt(entrada);
                if (opcion < 1 || opcion > TipoSexo.values().length) {
                    System.out.println("✘ Opción fuera de rango.");
                    return;
                }

                TipoSexo sexoSeleccionado = TipoSexo.values()[opcion - 1];
                List<Empleado> resultado = busquedaSexo(sexoSeleccionado);
                if (resultado.isEmpty()) {
                    System.out.println("✘ No se encontraron empleados con sexo: " + sexoSeleccionado);
                } else {
                    resultado.forEach(this::mostrarEmpleado);
                }

            } catch (NumberFormatException e) {
                System.out.println("✘ Entrada inválida. Debe ser un número.");
            }
        }

        public void buscarPorPuesto () {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Seleccione el puesto:");
            for (int i = 0; i < TipoPuesto.values().length; i++) {
                System.out.println((i + 1) + ". " + TipoPuesto.values()[i]);
            }

            String entrada = leerConValidacion(scanner, "Ingrese el número del puesto");
            if (entrada == null) return;

            try {
                int opcion = Integer.parseInt(entrada);
                if (opcion < 1 || opcion > TipoPuesto.values().length) {
                    System.out.println("✘ Opción fuera de rango.");
                    return;
                }

                TipoPuesto puestoSeleccionado = TipoPuesto.values()[opcion - 1];
                List<Empleado> resultado = busquedaPuesto(puestoSeleccionado);
                if (resultado.isEmpty()) {
                    System.out.println("✘ No se encontraron empleados con puesto: " + puestoSeleccionado);
                } else {
                    resultado.forEach(this::mostrarEmpleado);
                }

            } catch (NumberFormatException e) {
                System.out.println("✘ Entrada inválida. Debe ser un número.");
            }
        }

        public boolean mostrarTodos () {
            scanner = new Scanner(System.in);
            int intentosVacios = 0;

            while (intentosVacios < 3) {
                System.out.println("Presiona Enter para mostrar empleados o escribe 'salir' para cancelar:");
                String entrada = scanner.nextLine().trim();

                if (entrada.equalsIgnoreCase("salir")) {
                    System.out.println("✘ Operación cancelada por el usuario.");
                    return false;
                }

                if (entrada.isEmpty()) {
                    // ← Entrada vacía es válida: muestra empleados
                    if (empleado.isEmpty()) {
                        System.out.println("✘ No hay empleados registrados.");
                        return false;
                    }

                    System.out.println(" Lista de empleados:");
                    for (Empleado e : empleado.values()) {
                        System.out.println("ID: " + e.getId() + " | " + e.getNombre() + " | " + e.getApellidoPaterno()
                                + " | " + e.getCorreo() + " | " + e.getPuesto() + " | " +e.getSueldoSemanal());
                    }
                    return true;
                }

                System.out.println("✘ Entrada inválida. Solo presiona Enter o escribe 'salir'.");
                intentosVacios++;
            }

            System.out.println("✘ Demasiados intentos inválidos. Cancelando operación.");
            return false;


        }



        // Métodos de la interfaz BuscadorEmpleados
        @Override
        public List<Empleado> busquedaId ( int id){
            List<Empleado> resultado = new ArrayList<>();
            Empleado e = empleado.get(id);
            if (e != null) {
                resultado.add(e);
            }
            return resultado;
        }

        @Override
        public List<Empleado> busquedaNombre (String nombre){
            List<Empleado> resultado = new ArrayList<>();
            for (Empleado e : empleado.values()) {
                if (e.getNombre().equalsIgnoreCase(nombre)) {
                    resultado.add(e);
                }
            }
            return resultado;
        }

        @Override
        public List<Empleado> busquedaApellido (String apellido){
            List<Empleado> resultado = new ArrayList<>();
            for (Empleado e : empleado.values()) {
                if (e.getApellidoPaterno().equalsIgnoreCase(apellido)) {
                    resultado.add(e);
                }
            }
            return resultado;
        }

        @Override
        public List<Empleado> busquedaSexo (TipoSexo sexo){
            List<Empleado> resultado = new ArrayList<>();
            for (Empleado e : empleado.values()) {
                if (e.getSexo() == sexo) {
                    resultado.add(e);
                }
            }
            return resultado;
        }

        @Override
        public List<Empleado> busquedaPuesto (TipoPuesto puesto){
            List<Empleado> resultado = new ArrayList<>();
            for (Empleado e : empleado.values()) {
                if (e.getPuesto() == puesto) {
                    resultado.add(e);
                }
            }
            return resultado;
        }
    }




