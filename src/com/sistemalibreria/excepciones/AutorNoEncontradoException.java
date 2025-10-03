package com.sistemalibreria.excepciones;
import java.util.regex.Pattern;

/**
 * Excepción lanzada cuando el nombre del autor es inválido o no se encuentra.
 */
public class AutorNoEncontradoException extends BúsquedaInvalidaException {
    private static final Pattern SOLO_LETRAS_Y_ESPACIOS = Pattern.compile("^[A-Za-zÁÉÍÓÚÑáéíóúñ ]+$");

    public AutorNoEncontradoException(String mensaje) {
        super(mensaje);
    }

    public static void validar(String nombre) throws AutorNoEncontradoException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new AutorNoEncontradoException("El nombre del autor no puede estar vacío.") ;
        }
        if (!SOLO_LETRAS_Y_ESPACIOS.matcher(nombre).matches()) {
            throw new AutorNoEncontradoException("El nombre del autor contiene caracteres inválidos. Solo se permiten letras y espacios.") ;

        }
        throw new AutorNoEncontradoException("No se encontró ningún autor con el nombre '" + nombre + "'.") ;
    }
}


