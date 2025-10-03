package com.sistemalibreria.excepciones.ErroresEmpleados;

import com.PINACOMP.Sistemalibreria.model.enums.TipoPuesto;
import com.sistemalibreria.excepciones.ValidacionUsuarioException;


/**
 * Excepción lanzada cuando el puesto ingresado no coincide con los valores definidos en TipoPuesto.
 */
public class PuestoNoReconocidoException extends ValidacionUsuarioException {


    /**
     * Constructor que valida si el puesto ingresado es reconocido.
     * @param entrada texto ingresado por el usuario
     */
    public PuestoNoReconocidoException(String entrada) {
        super(generarMensaje(entrada));
    }

    /**
     * Verifica si la entrada corresponde a un valor válido del enum TipoPuesto.
     * @param entrada texto ingresado por el usuario
     * @return mensaje de error si el puesto no es válido
     */
    private static String generarMensaje(String entrada) {
        if (entrada == null || entrada.isBlank()) {
            return "El puesto no puede estar vacío.";
        }

        String puesto = entrada.trim().toUpperCase();

        for (TipoPuesto tipo : TipoPuesto.values()) {
            if (tipo.name().equals(puesto)) {
                return "Puesto válido."; // No se lanza si es válido
            }
        }

        return "Puesto no reconocido: '" + entrada + "'. Solo se permite CLIENTE, EMPLEADO o ADMINISTRADOR.";
    }
}