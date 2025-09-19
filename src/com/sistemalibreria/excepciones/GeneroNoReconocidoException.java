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
        super(validar(generoIngresado));
    }

    /**
     * Valida sintaxis y existencia del género en el enum TipoGenero.
     * @param genero texto ingresado
     * @return mensaje de error semántico
     */
    private static String validar(String genero) {
        if (genero == null || genero.isBlank()) {
            return "El género no puede estar vacío.";
        }

        String entrada = genero.trim().toUpperCase();

        if (!entrada.matches("^[A-ZÁÉÍÓÚÑ]+$")) {
            return "El género contiene caracteres inválidos. Solo se permiten letras mayúsculas sin espacios ni símbolos.";
        }

        for (TipoGenero tipo : TipoGenero.values()) {
            if (tipo.name().equals(entrada)) {
                return "Género válido."; // No se lanza si es válido
            }
        }

        return "Género no reconocido: '" + genero + "'. Los géneros válidos son: " + obtenerGenerosValidos();
    }

    /**
     * Devuelve una lista formateada de los géneros definidos en el enum TipoGenero.
     */
    private static String obtenerGenerosValidos() {
        StringBuilder generos = new StringBuilder();
        for (TipoGenero tipo : TipoGenero.values()) {
            generos.append(tipo.name()).append(", ");
        }
        return generos.substring(0, generos.length() - 2); // elimina la última coma
    }
}


