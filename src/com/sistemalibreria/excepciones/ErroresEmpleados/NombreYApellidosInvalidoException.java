package com.sistemalibreria.excepciones.ErroresEmpleados;

import java.util.regex.Pattern;

public class NombreYApellidosInvalidoException extends Exception {
    private static final Pattern PATRON_NOMBRE= Pattern.compile("[A-Za-zÁÉÍÓÚáéíóú]+([A-Za-zÁÉÍÓÚáéíóú]+)*$");
    public NombreYApellidosInvalidoException(String mensaje) {super(mensaje);}

    //Validacion de métodos
    public static String validarNombre(String nombre) throws NombreYApellidosInvalidoException{
        if (nombre==null || nombre.trim().isEmpty()){
            throw new NombreYApellidosInvalidoException("El nombre o apellido no puede estar vacio");
        }
        if(!PATRON_NOMBRE.matcher(nombre).matches()){
            throw new NombreYApellidosInvalidoException("El Nombre o Apellidos no tienen el formato valido");
        }
        return "El nombre "+ nombre+" es valido";
    }
}
