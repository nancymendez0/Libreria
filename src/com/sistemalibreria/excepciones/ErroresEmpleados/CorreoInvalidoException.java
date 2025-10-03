package com.sistemalibreria.excepciones.ErroresEmpleados;

import java.util.regex.Pattern;

public class CorreoInvalidoException extends Exception {
    private static final Pattern PATRON_CORREO= Pattern.compile("^[A-Za-z0-9.-]+@[A-Za-z0-9.-]+$");
    public CorreoInvalidoException(String mensaje) {
        super(mensaje);
    }

    //metodo que valida
    public static String validar(String correo) throws CorreoInvalidoException{
        if(correo== null || correo.trim().isEmpty()){
            throw new CorreoInvalidoException("El correo no puede estar vacio.");
        }
        if(!PATRON_CORREO.matcher(correo).matches()){
            throw new CorreoInvalidoException("El correo no tiene un formato válido.");
        }
        return "El correo" +correo+" es valido.";
    }

}

