package com.sistemalibreria.excepciones;

/**
 * Excepción lanzada cuando el precio ingresado es inválido.
 */
public class PrecioInvalidoException extends Exception {
    public PrecioInvalidoException(String entrada) {
        super(entrada);
    }

    public static double validar(String entrada) throws PrecioInvalidoException{
        try {
            double precio = Double.parseDouble(entrada);
            if (precio <= 0) {
                throw new PrecioInvalidoException("El precio debe ser mayor que cero.");
            }
            return precio;
        } catch (NumberFormatException e) {
            throw new PrecioInvalidoException("El precio ingresado no es numérico.");
        }
    }
}

