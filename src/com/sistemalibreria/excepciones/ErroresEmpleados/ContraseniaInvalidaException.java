package com.sistemalibreria.excepciones.ErroresEmpleados;

import java.util.regex.Pattern;

public class ContraseniaInvalidaException extends Exception{
    private static final Pattern PATRON_CONTRASENIA =
            Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&.-])[A-Za-z\\d@$!%*?&.-]{8,}$");
    public ContraseniaInvalidaException (String mensaje){super(mensaje);}

    //validando metodos

    public String validar(String contrasenia) throws ContraseniaInvalidaException{
        if(contrasenia==null || contrasenia.trim().isEmpty()  ){
            throw new ContraseniaInvalidaException("La contraseña no puede ser vacia");
        }
        if(!PATRON_CONTRASENIA.matcher(contrasenia).matches()){
            throw new ContraseniaInvalidaException("La contraseña no tiene el formato valido");
        }
        if(contrasenia.length()<8){
            throw new ContraseniaInvalidaException("La contraseña debe tener 8 caracteres como minímo");
        }
        return ("La contraseña "+contrasenia+" es válida");
    }
}
