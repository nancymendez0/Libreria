package com.PINACOMP.Sistemalibreria.servicios;
import java.util.HashMap;
import java.util.Map;

public class EmpleadoServicios {
    private final Map<Integer, Empleado> empleados = new HashMap<>();

    public void agregarEmpleado(Empleado empleado) {
        int id = empleado.getId();
        if (empleados.containsKey(id)) {
            throw new IllegalArgumentException("Ya existe un empleado con ID: " + id);
        }
        empleados.put(id, empleado);
    }

    public void actualizarEmpleado(int id, Empleado nuevoEmpleado) {
        if (!empleados.containsKey(id)) {
            throw new IllegalArgumentException("No se encontró ningún empleado con ID: " + id);
        }
        empleados.put(id, nuevoEmpleado);
    }

    public void eliminarEmpleado(int id) {
        if (!empleados.containsKey(id)) {
            throw new IllegalArgumentException("No se puede eliminar. No existe empleado con ID: " + id);
        }
        empleados.remove(id);
    }
    public boolean mostrarTodos() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
            return false;
        }

        for (Empleado e : empleados.values()) {
            System.out.println("ID: " + e.getId() + " | " + e.getNombreCompleto() +
                    " | " + e.getCorreo() + " | " + e.getPuesto());
        }
        return false;
    }
    public void mostrarEmpleadosOrdenadosPorId() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
            return;
        }

        empleados.entrySet().stream()
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
        return empleados.get(id);
    }

    public boolean existeEmpleado(int id) {
        return empleados.containsKey(id);
    }


    public Map<Integer, Empleado> obtenerTodos() {
        return empleados;
    }
}
