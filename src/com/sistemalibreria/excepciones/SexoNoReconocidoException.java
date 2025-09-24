package com.sistemalibreria.excepciones;

public class SexoNoReconocidoException extends RuntimeException {
    public SexoNoReconocidoException(String mensaje) {
        super(mensaje);
    }
}
