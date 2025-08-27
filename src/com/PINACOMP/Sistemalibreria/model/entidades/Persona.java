package com.PINACOMP.Sistemalibreria.model.entidades;

import com.PINACOMP.Sistemalibreria.model.enums.TipoNacionalidad;
import com.PINACOMP.Sistemalibreria.model.enums.TipoSexo;

import java.time.LocalDate;

public abstract class Persona {

    protected String nombre;
    protected String apellidoPaterno;
    protected String apellidoMaterno;
    protected String correo;
    protected int edad;
    protected TipoSexo sexo;
    protected int id;//acceso desde subclases
    protected LocalDate fechaNacimiento;
    //constructor
    public Persona(int id,String nombre, String apellidoPaterno,String apellidoMaterno, String correo, int edad, TipoSexo sexo) {
        this.id=id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.edad = edad;
        this.sexo = sexo;
    }

    public Persona(int id, String nombre, String apellidoPaterno, String correo) {
    }

    public Persona(String nombre, String apellidoPaterno, String correo, int edad, TipoSexo sexo, int id) {
    }

    public Persona(String nombre, String apellidoPaterno) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
    }

    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }
    public String getapellidoMaterno() {
        return apellidoMaterno;
    }

    public String getNombreCompleto() {
        return getNombre() + " " + getApellidoPaterno() + " " + apellidoMaterno;
    }

    public abstract TipoNacionalidad getNacionalidad();

    public String getCorreo() {
        return correo;
    }

    public int getEdad() {
        return edad;
    }

    public TipoSexo getSexo() {
        return sexo;
    }


    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
}
