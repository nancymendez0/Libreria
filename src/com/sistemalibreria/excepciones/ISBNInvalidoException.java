package com.sistemalibreria.excepciones;

public class ISBNInvalidoException extends Exception{
    public ISBNInvalidoException(String mensaje) {
        super(mensaje);
    }
    public static String validar(String isbn) throws ISBNInvalidoException {
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new ISBNInvalidoException("El ISBN no puede estar vacío.");
        }

        // Eliminar guiones o espacios si el usuario los puso
        isbn = isbn.replaceAll("[-\\s]", "");

        // Verificar que solo contenga dígitos
        if (!isbn.matches("\\d+")) {
            throw new ISBNInvalidoException("El ISBN solo puede contener números.");
        }

        // Verificar longitud (10 o 13)
        if (isbn.length() != 10 && isbn.length() != 13) {
            throw new ISBNInvalidoException("El ISBN debe tener 10 o 13 dígitos.");
        }
        return isbn;
    }
}
