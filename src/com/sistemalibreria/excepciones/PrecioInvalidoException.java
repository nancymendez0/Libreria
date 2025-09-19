package com.sistemalibreria.excepciones;

/**
 * Excepción lanzada cuando el precio ingresado es inválido.
 */
public class PrecioInvalidoException extends BúsquedaInvalidaException {
    public PrecioInvalidoException(String entrada) {
        super(validar(entrada));
    }

    private static String validar(String entrada) {
        try {
            double precio = Double.parseDouble(entrada);
            if (precio <= 0) {
                return "El precio debe ser mayor que cero.";
            }
            return "Precio válido.";
        } catch (NumberFormatException e) {
            return "El precio ingresado no es numérico.";
        }
    }
}

