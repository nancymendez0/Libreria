package com.PINACOMP.Sistemalibreria.model.servicios;

import com.PINACOMP.Sistemalibreria.data.Empleados;
import com.PINACOMP.Sistemalibreria.model.entidades.Empleado;

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






