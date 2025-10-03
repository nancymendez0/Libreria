package com.sistemalibreria.excepciones.ErroresEmpleados;

public class SexoNoReconocidoException extends RuntimeException {
    public SexoNoReconocidoException(String mensaje) {
        super(mensaje);
    }
}
