package com.sistemalibreria.excepciones.ErroresEmpleados;
import com.PINACOMP.Sistemalibreria.model.enums.TipoSexo;
import com.PINACOMP.Sistemalibreria.model.enums.TipoPuesto;
import com.sistemalibreria.excepciones.NombreInvalidoException;

import java.util.Arrays;
import java.util.regex.Pattern;


public class ValidadorEmpleado {

        /**
         * Valida que el nombre o apellido contenga solo letras y espacios.
         */
        private static final Pattern PATRON_NOMBRE_COMPLETO = Pattern.compile("^[A-Za-zÁÉÍÓÚáéíóúÑñ]+(\\s[A-Za-zÁÉÍÓÚáéíóúÑñ]+){0,2}$");

    public static void validarNombreCompleto(String nombreCompleto) throws NombreYApellidosInvalidoException {
        if (nombreCompleto == null || nombreCompleto.trim().isEmpty()) {
            throw new NombreYApellidosInvalidoException("El nombre completo no puede estar vacío.");
        }
        if (!PATRON_NOMBRE_COMPLETO.matcher(nombreCompleto.trim()).matches()) {
            throw new NombreYApellidosInvalidoException("Formato inválido. Usa nombre y uno o dos apellidos. Ejemplo: 'Juan Pérez Gómez'.");
        }
    }

        /**
         * Valida que el correo tenga formato correcto: contiene '@' y termina en '.com'.
         */
        private static final Pattern PATRON_CORREO = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}$");


    public static void validarCorreo(String correo) throws CorreoInvalidoException {
            if (correo == null || correo.trim().isEmpty()) {
                throw new CorreoInvalidoException("El correo no puede estar vacío.");
            }
            if (!PATRON_CORREO.matcher(correo).matches()) {
                throw new CorreoInvalidoException("El correo no tiene un formato válido. Ejemplo: usuario@dominio.com");
            }
        }




    /**
         * Valida que la edad sea un número entero positivo.
         */
        public static void validarEdad(int edad) throws EdadInvalidaException {
            if (edad <= 0) {
                throw new EdadInvalidaException("La edad debe ser un número entero positivo.");
            }
        }

        /**
         * Valida que el valor ingresado coincida con un enum definido.
         * Ignora mayúsculas/minúsculas y espacios.
         */
        public static <E extends Enum<E>> E validarEnum(Class<E> tipoEnum, String entrada, RuntimeException excepcionPersonalizada) {
            if (entrada == null) throw excepcionPersonalizada;
            for (E constante : tipoEnum.getEnumConstants()) {
                if (constante.name().equalsIgnoreCase(entrada.trim())) {
                    return constante;
                }
            }
            throw excepcionPersonalizada;
        }

        /**
         * Valida el sexo como TipoSexo.
         */
        public static TipoSexo validarSexo(String entrada) throws SexoNoReconocidoException{
            throw new SexoNoReconocidoException("Sexo no reconocido: " );
        }

        /**
         * Valida el puesto como TipoPuesto.
         */
        public static TipoPuesto validarPuesto(String entrada) {
            if (entrada == null || entrada.isBlank()) {
                throw new PuestoNoReconocidoException("El puesto no puede estar vacío.");
            }

            String normalizado = entrada.trim().toUpperCase();
            for (TipoPuesto tipo : TipoPuesto.values()) {
                if (tipo.name().equals(normalizado)) {
                    return tipo;
                }
            }

            throw new PuestoNoReconocidoException(
                    "Puesto no reconocido: '" + entrada + "'. Valores válidos: " + Arrays.toString(TipoPuesto.values())
            );
        }


}

