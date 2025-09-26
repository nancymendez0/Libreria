package com.PINACOMP.Sistemalibreria.model.servicios;

import com.PINACOMP.Sistemalibreria.data.Empleados;
import com.PINACOMP.Sistemalibreria.model.entidades.Empleado;

import java.util.ArrayList;
import java.util.List;

public class AdminService {
    private final List<Empleado> empleados;
    public AdminService() {
        this.empleados = new ArrayList<>(Empleados.crearEmpleados());
    }
    public List<Empleado> obtenerEmpleados() {
        return empleados;
    }

    public void mostrarEmpleados(List<Empleado> resultado){
        System.out.println("Actualmente tenemos: " +resultado.size() +" empleados" );
        for (Empleado empleado : resultado){
            System.out.println("Informacion de nuestro emplado con el ID: "+ empleado.getId());
            System.out.println(empleado);
            System.out.println();
        }
    }

}

