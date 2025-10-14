package com.sistemalibreria.excepciones.ErroresEmpleados;

import jdk.jshell.spi.ExecutionControl;

import java.util.regex.Pattern;

public class NombreYApellidosInvalidoException extends RuntimeException {
    public NombreYApellidosInvalidoException(String mensaje) {
        super(mensaje);
    }
}
