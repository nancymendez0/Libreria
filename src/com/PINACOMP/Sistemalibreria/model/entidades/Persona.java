package com.PINACOMP.Sistemalibreria.model.entidades;

import com.PINACOMP.Sistemalibreria.model.enums.TipoSexo;

public class Persona {
    protected String nombre;
    protected String apellidoPaterno;
    protected String correo;
    protected int edad;
    protected TipoSexo sexo;
    protected int id;//acceso desde subclases
    //constructor
    public Persona(int id,String nombre, String apellidoPaterno, String correo, int edad, TipoSexo sexo) {
        this.id=id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.correo = correo;
        this.edad = edad;
        this.sexo = sexo;
    }
    public int getId() {
        return id;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellidoPaterno;
    }

    public String getNombre() {
        return nombre;
    }

    public Persona(int id, String nombre, String apellidoPaterno) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getCorreo() {
        return correo;
    }

    public int getEdad() {
        return edad;
    }

    public TipoSexo getSexo() {
        return sexo;
    }


}
