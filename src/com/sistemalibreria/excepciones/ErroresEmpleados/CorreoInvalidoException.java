package com.sistemalibreria.excepciones.ErroresEmpleados;

import java.util.regex.Pattern;

public class CorreoInvalidoException extends RuntimeException {
    public CorreoInvalidoException(String mensaje) {
        super(mensaje);
    }
}

