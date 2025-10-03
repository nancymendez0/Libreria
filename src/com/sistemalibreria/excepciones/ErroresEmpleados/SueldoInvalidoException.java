package com.sistemalibreria.excepciones.ErroresEmpleados;

public class SueldoInvalidoException extends Exception{
    public SueldoInvalidoException(String mensaje){super(mensaje);}

    //Métodos que validan
    public static String validar(int sueldo) throws SueldoInvalidoException{

        if (sueldo==0){
            throw new SueldoInvalidoException("No puedes tener un sueldo vacio");
        }
        if(sueldo<0){
            throw new SueldoInvalidoException("No puedes tener sueldos negativos");
        }
        return "El sueldo " + " es valido";
    }
}
