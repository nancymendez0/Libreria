package com.sistemalibreria.excepciones;

import java.util.regex.Pattern;

public class TituloInvalidoException  extends  Exception {
    private static final Pattern SOLO_LETRAS_Y_ESPACIOS =
            Pattern.compile("^(?:[A-Za-zÁÉÍÓÚÑáéíóúñ]+\\s+){1,4}[A-Za-zÁÉÍÓÚÑáéíóúñ]+$");

    public TituloInvalidoException(String mensaje) {
        super(mensaje);
    }

    public static String validar(String titulo) throws TituloInvalidoException {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new TituloInvalidoException("El título del libro no puede estar vacío.");
        }
        //eliminar espacios al inicio y final
        titulo = titulo.trim();
        //Contador de palabras
        String[] palabras = titulo.split("\\s+");
        int numPlabras = palabras.length;
        if (numPlabras < 2) {
            throw new TituloInvalidoException("El título debe tener al menos 2 palabras.");

        }
        if (numPlabras > 5) {
            throw new TituloInvalidoException("El título no puede tener más de 5 palabras.");

        }
        if (!SOLO_LETRAS_Y_ESPACIOS.matcher(titulo).matches()) {
            throw new TituloInvalidoException("El título solo puede contener letras y espacios (sin números ni símbolos).");
        }
        return titulo;
    }
}
