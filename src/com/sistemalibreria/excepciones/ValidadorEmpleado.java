package com.sistemalibreria.excepciones;
import com.sistemalibreria.excepciones.*;
import com.PINACOMP.Sistemalibreria.model.enums.TipoSexo;
import com.PINACOMP.Sistemalibreria.model.enums.TipoPuesto;

import java.util.Arrays;


public class ValidadorEmpleado {

        /**
         * Valida que el nombre o apellido contenga solo letras y espacios.
         */
        public static void validarNombre(String nombre) {
            if (nombre == null || !nombre.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ\\s]+$")) {
                throw new NombreInvalidoException("El nombre debe contener solo letras y espacios.");
            }
        }

        /**
         * Valida que el correo tenga formato correcto: contiene '@' y termina en '.com'.
         */
        public static void validarCorreo(String correo) {
            if (correo == null || !correo.matches("^[\\w.-]+@[\\w.-]+\\.com$")) {
                throw new CorreoInvalidoException("El correo debe contener '@' y terminar en '.com'.");
            }
        }

        /**
         * Valida que la edad sea un número entero positivo.
         */
        public static void validarEdad(int edad) {
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
        public static TipoSexo validarSexo(String entrada) {
            return validarEnum(TipoSexo.class, entrada, new SexoNoReconocidoException("Sexo no reconocido: " + entrada));
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

