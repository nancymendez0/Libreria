package com.PINACOMP.Sistemalibreria.model.entidades;

import com.PINACOMP.Sistemalibreria.model.enums.TipoPuesto;
import com.PINACOMP.Sistemalibreria.model.enums.TipoSexo;

public class Empleado  extends Persona{
    int numEmpleado;
    double sueldoSemanal;
    String contraseña;
    TipoPuesto puesto;

    public Empleado(int id, String nombre, String apellidoPaterno, String correo, int edad, TipoSexo sexo, int numEmpleado, double sueldoSemanal, String contraseña, TipoPuesto puesto) {
        super(id, nombre, apellidoPaterno, correo, edad, sexo);
        this.numEmpleado = numEmpleado;
        this.sueldoSemanal = sueldoSemanal;
        this.contraseña = contraseña;
        this.puesto = puesto;
    }

    public int getNumEmpleado() {
        return numEmpleado;
    }

    public double getSueldoSemanal() {
        return sueldoSemanal;
    }

    public String getContraseña() {
        return contraseña;
    }

    public TipoPuesto getPuesto() {
        return puesto;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nEl numero del empleado es: ").append(getNumEmpleado());
        sb.append("\nSu puesto es: ").append(getPuesto());
        sb.append("\nSu sueldo es: ").append(getSueldoSemanal());
        return super.toString() + sb.toString();
    }
}
