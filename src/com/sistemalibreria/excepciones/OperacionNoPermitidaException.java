package com.sistemalibreria.excepciones;

/**
 * Excepción lanzada cuando una operación no puede ejecutarse por restricciones del sistema.
 */
public class OperacionNoPermitidaException extends ValidacionUsuarioException {
    public OperacionNoPermitidaException(String mensaje) {
        super("Operación no permitida: " + mensaje);
    }
}

