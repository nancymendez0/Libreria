package com.PINACOMP.Sistemalibreria.model.servicios;

import com.PINACOMP.Sistemalibreria.data.Empleados;
import com.PINACOMP.Sistemalibreria.model.entidades.Empleado;
import com.PINACOMP.Sistemalibreria.model.enums.TipoPuesto;
import com.PINACOMP.Sistemalibreria.model.enums.TipoSexo;

import java.util.*;


public class AdminService {
   // private final List<Empleado> empleados;
    //public AdminService() {
        //this.empleados = new ArrayList<>(Empleados.crearEmpleados());
   // }
    /*public List<Empleado> obtenerEmpleados() {
        return empleados;
    }
    */
        private final Map<Integer,Empleado>empleado = new HashMap<>();
        public AdminService(){
            List<Empleado> empleados = Empleados.crearEmpleados();
            for(Empleado e : empleados){
                empleado.put(e.getId(), e);
            }
        }
        public void agregarEmpleado(Scanner scanner , Empleado e) {
            System.out.println("Dame el id del empleado = " );
            int id = scanner.nextInt();
            if (empleado.containsKey(id)) {
                throw new IllegalArgumentException("Ya existe un empleado con ID: " + id);
            }
            empleado.put(id,e);
            scanner.nextLine();
            System.out.println("Dame el nombre del empleado " );
            String nombre = scanner.nextLine();
            empleado.put(id,e);
            System.out.println(" Dame el apellido paterno "  );
            String apellidoPaterno = scanner.nextLine();
            empleado.put(id,e);
            System.out.println(" Dame el correo "  );
            String correo = scanner.nextLine();
            empleado.put(id,e);
            System.out.println("Dame edad " );
            int edad = scanner.nextInt();
            empleado.put(id,e);
            System.out.println("Selecciona tu tipo de sexo del empleado " );
            TipoSexo []sexos = TipoSexo.values();
            for(int i = 0; i < sexos.length; i++){
                System.out.println((i+1) + ". " + sexos[i]);
            }
            int opcion = scanner.nextInt();
            scanner.nextLine();
            System.out.println(" Número de empleado " );
            int numero = scanner.nextInt();
            empleado.put(id,e);
            System.out.println(" Sueldo semanal" );
            double salario = scanner.nextDouble();
            empleado.put(id,e);
            System.out.println("contraseña");
            String password = scanner.nextLine();
            empleado.put(id,e);
            System.out.println("Selecciona tu tipo de puesto del empleado " );
            TipoPuesto[]puestos = TipoPuesto.values();
            for(int i = 0; i < puestos.length; i++){
                System.out.println((i+1) + ". " + puestos[i]);
            }
            int opcionPuesto = scanner.nextInt();
            scanner.nextLine();


        }

        public void actualizarEmpleado(int id, Empleado nuevoEmpleado) {
            if (!empleado.containsKey(id)) {
                throw new IllegalArgumentException("No se encontró ningún empleado con ID: " + id);
            }
            empleado.put(id, nuevoEmpleado);
        }

        public void eliminarEmpleado(int id) {
            if (!empleado.containsKey(id)) {
                throw new IllegalArgumentException("No se puede eliminar. No existe empleado con ID: " + id);
            }
            empleado.remove(id);
        }
        public boolean mostrarTodos() {
            if (empleado.isEmpty()) {
                System.out.println("No hay empleados registrados.");
                return false;
            }

            for (Empleado e : empleado.values()) {
                System.out.println("ID: " + e.getId() + " | " + e.getNombreCompleto() +
                        " | " + e.getCorreo() + " | " + e.getPuesto());
            }
            return false;
        }
        public void mostrarEmpleadosOrdenadosPorId() {
            if (empleado.isEmpty()) {
                System.out.println("No hay empleados registrados.");
                return;
            }

            empleado.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey()) // Ordena por clave (ID)
                    .forEach(entry -> {
                        Empleado e = entry.getValue();
                        System.out.println("ID: " + entry.getKey() + " | " +
                                e.getNombreCompleto() + " | " +
                                e.getCorreo() + " | " +
                                e.getPuesto());
                    });
        }

        public Empleado obtenerEmpleado(int id) {
            return empleado.get(id);
        }

        public boolean existeEmpleado(int id) {
            return empleado.containsKey(id);
        }


        public Map<Integer, Empleado> obtenerTodos() {
            return empleado;
        }
    }






