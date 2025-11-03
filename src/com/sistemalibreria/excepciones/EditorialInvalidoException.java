package com.sistemalibreria.excepciones;
import java.util.regex.Pattern;
public class EditorialInvalidoException extends Exception{
    private static final Pattern SOLO_LETRAS_Y_ESPACIOS =
            Pattern.compile("^(?:[A-Za-zÁÉÍÓÚÑáéíóúñ]+\\s+){1,3}[A-Za-zÁÉÍÓÚÑáéíóúñ]+$");

    public EditorialInvalidoException(String mensaje) {
        super(mensaje);
    }

    public static String validar(String editorial) throws EditorialInvalidoException {
        if (editorial == null || editorial.trim().isEmpty()) {
            throw new EditorialInvalidoException("El nombre de la editorial no puede estar vacío.");
        }

        editorial = editorial.trim();
        String[] palabras = editorial.split("\\s+");

        if (palabras.length < 2) {
            throw new EditorialInvalidoException("El nombre de la editorial debe tener al menos 2 palabras.");
        }

        if (palabras.length > 4) {
            throw new EditorialInvalidoException("El nombre de la editorial no puede tener más de 4 palabras.");
        }

        if (!SOLO_LETRAS_Y_ESPACIOS.matcher(editorial).matches()) {
            throw new EditorialInvalidoException("El nombre de la editorial solo puede contener letras y espacios.");
        }

        return editorial;
    }
}
