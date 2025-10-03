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

    public String getNombre() {
        return nombre;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellidoPaterno;
    }


    public Persona(int id, String nombre, String apellidoPaterno) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
    }
    public Persona( String nombre, String apellidoPaterno) {

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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSexo(TipoSexo sexo) {
        this.sexo = sexo;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Su nombre es: ").append(getNombreCompleto());
        sb.append("\n Su edad es: ").append(edad);
        sb.append("\nSu sexo es: ").append(sexo);
        sb.append("\nSu correo es: ").append(correo);
        return sb.toString();
    }
}
