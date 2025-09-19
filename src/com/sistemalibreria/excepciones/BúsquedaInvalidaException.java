package com.sistemalibreria.excepciones;
/**
 * Excepción general para errores en búsquedas de libros.
 */
public class BúsquedaInvalidaException extends ValidacionUsuarioException {
    public BúsquedaInvalidaException(String mensaje) {
        super("Error en búsqueda: " + mensaje);
    }
}



