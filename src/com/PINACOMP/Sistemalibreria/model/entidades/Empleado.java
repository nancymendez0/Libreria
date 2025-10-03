package com.PINACOMP.Sistemalibreria.model.entidades;

import com.PINACOMP.Sistemalibreria.model.enums.TipoPuesto;
import com.PINACOMP.Sistemalibreria.model.enums.TipoSexo;
import com.PINACOMP.Sistemalibreria.model.interfaces.BuscadorEmpleados;

import java.util.ArrayList;
import java.util.List;

public class Empleado  extends Persona implements BuscadorEmpleados{
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

    public void setNumEmpleado(int numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public void setSueldoSemanal(double sueldoSemanal) {
        this.sueldoSemanal = sueldoSemanal;
    }

    public void setPuesto(TipoPuesto puesto) {
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nEl numero del empleado es: ").append(getNumEmpleado());
        sb.append("\nSu puesto es: ").append(getPuesto());
        sb.append("\nSu sueldo es: ").append(getSueldoSemanal());
        return super.toString() + sb.toString();
    }


    @Override
    public List<Empleado> busquedaId(int id) {
        List<Empleado> resultado = new ArrayList<>();
        if (this.id==id){
            resultado.add(this);

        }
        return resultado;
    }

    @Override
    public List<Empleado> busquedaNombre(String nombre) {
        List<Empleado> resultado = new ArrayList<>();
        if(this.nombre.equalsIgnoreCase(nombre)){
            resultado.add(this);
        }
        return resultado;
    }

    @Override
    public List<Empleado> busquedaApellido(String apellido) {
        List<Empleado> reultado = new ArrayList<>();
        if(this.apellidoPaterno.equalsIgnoreCase(apellido)){
            reultado.add(this);
        }
        return reultado;
    }

    @Override
    public List<Empleado> busquedaSexo(TipoSexo sexo) {
        List<Empleado> resultado = new ArrayList<>();
        if(this.sexo==sexo){
            resultado.add(this);
        }
        return resultado;
    }

    @Override
    public List<Empleado> busquedaPuesto(TipoPuesto puesto) {
        List<Empleado> resultado = new ArrayList<>();
        if(this.puesto == puesto){
            resultado.add(this);
        }
        return resultado;
    }
}
