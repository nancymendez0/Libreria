package com.sistemalibreria.excepciones.ErroresEmpleados;

public class EdadInvalidaException extends RuntimeException {
    public EdadInvalidaException(String mensaje) {
        super(mensaje);
    }
}

