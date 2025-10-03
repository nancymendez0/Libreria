package com.sistemalibreria.excepciones;

import com.PINACOMP.Sistemalibreria.model.enums.TipoGenero;

/**
 * Excepción lanzada cuando el género ingresado no es válido o no está definido en el sistema.
 */
public class GeneroNoReconocidoException extends BúsquedaInvalidaException {

    /**
     * Constructor que valida el género ingresado.
     * @param generoIngresado texto ingresado por el usuario
     */
    public GeneroNoReconocidoException(String generoIngresado) {
        super(generoIngresado);
    }

    /**
     * Valida sintaxis y existencia del género en el enum TipoGenero.
     * @param genero texto ingresado
     * @return mensaje de error semántico
     */
    public static void validarGenero(String genero) throws GeneroNoReconocidoException {
        if (genero == null || genero.isBlank()) {
            throw new GeneroNoReconocidoException("El género no puede estar vacío.") ;
        }

        String entrada = genero.trim().toUpperCase();

        if (!entrada.matches("^[A-ZÁÉÍÓÚÑ]+$")) {
            throw new GeneroNoReconocidoException("El género contiene caracteres inválidos. Solo se permiten letras mayúsculas sin espacios ni símbolos.");
        }

        for (TipoGenero tipo : TipoGenero.values()) {
            if (tipo.name().equals(entrada)) {
                return; // No se lanza si es válido
            }
        }

        throw new GeneroNoReconocidoException("Género no reconocido: '" + genero + "'. Los géneros válidos son: " + obtenerGenerosValidos()) ;
    }

    /**
     * Devuelve una lista formateada de los géneros definidos en el enum TipoGenero.
     */
    public static String obtenerGenerosValidos() {
        StringBuilder generos = new StringBuilder();
        for (TipoGenero tipo : TipoGenero.values()) {
            generos.append(tipo.name()).append(", ");
        }
        return generos.substring(0, generos.length() - 2); // elimina la última coma
    }
}


