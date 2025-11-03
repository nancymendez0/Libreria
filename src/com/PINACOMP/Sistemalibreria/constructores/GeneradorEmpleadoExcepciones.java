package com.PINACOMP.Sistemalibreria.constructores;

import com.PINACOMP.Sistemalibreria.model.entidades.Empleado;
import com.PINACOMP.Sistemalibreria.model.enums.TipoPuesto;
import com.PINACOMP.Sistemalibreria.model.enums.TipoSexo;
import com.sistemalibreria.excepciones.ErroresEmpleados.ContraseniaInvalidaException;
import com.sistemalibreria.excepciones.ErroresEmpleados.SueldoInvalidoException;
import com.sistemalibreria.excepciones.ErroresEmpleados.ValidadorEmpleado;

public class GeneradorEmpleadoExcepciones {
    private int id;
    private String nombre;
    private String apellidoPaterno;
    private String correo;
    private int edad;
    private TipoSexo sexo;
    private int numEmpleado;
    private double sueldoSemanal;
    private String contraseña;
    private TipoPuesto puesto;

    public GeneradorEmpleadoExcepciones setId(int id) {
        this.id = id;
        return this;
    }

    public GeneradorEmpleadoExcepciones setNombreYApellidos(String nombre, String apellidoPaterno, String apellidoMaterno) {
        String nombreCompleto = nombre + " " + apellidoPaterno ;
        ValidadorEmpleado.validarNombreCompleto(nombreCompleto);
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;

        return this;
    }



    public GeneradorEmpleadoExcepciones setCorreo(String correo) {
        ValidadorEmpleado.validarCorreo(correo);
        this.correo = correo;
        return this;
    }

    public GeneradorEmpleadoExcepciones setEdad(int edad) {
        ValidadorEmpleado.validarEdad(edad);
        this.edad = edad;
        return this;
    }

    public GeneradorEmpleadoExcepciones setSexo(TipoSexo sexo) {
        this.sexo = sexo;
        return this;
    }

    public GeneradorEmpleadoExcepciones setNumEmpleado(int numEmpleado) {
        this.numEmpleado = numEmpleado;
        return this;
    }

    public GeneradorEmpleadoExcepciones setSueldoSemanal(double sueldoSemanal) {
        if (sueldoSemanal <= 0) {
            try {
                throw new SueldoInvalidoException("El sueldo debe ser mayor a cero.");
            } catch (SueldoInvalidoException e) {
                throw new RuntimeException(e);
            }
        }
        this.sueldoSemanal = sueldoSemanal;
        return this;
    }

    public GeneradorEmpleadoExcepciones setContraseña(String contraseña) {
        if (contraseña == null || contraseña.isBlank()) {
            try {
                throw new ContraseniaInvalidaException("La contraseña no puede estar vacía.");
            } catch (ContraseniaInvalidaException e) {
                throw new RuntimeException(e);
            }
        }
        this.contraseña = contraseña;
        return this;
    }

    public GeneradorEmpleadoExcepciones setPuesto(TipoPuesto puesto) {
        this.puesto = puesto;
        return this;
    }

    public Empleado construir() {
        ValidadorEmpleado.validarNombreCompleto(nombre + " " + apellidoPaterno );
        ValidadorEmpleado.validarCorreo(correo);
        ValidadorEmpleado.validarEdad(edad);


        return new Empleado(id, nombre, apellidoPaterno,  correo, edad, sexo, numEmpleado, sueldoSemanal, contraseña, puesto);
    }



}
