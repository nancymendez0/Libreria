package com.sistemalibreria.excepciones;
/**
 * Excepción base para todas las validaciones de entrada del usuario.
 *
 */

public class ValidacionUsuarioException extends RuntimeException {
    public ValidacionUsuarioException(String mensaje) {
        super(mensaje);
    }

}
