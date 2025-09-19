package com.PINACOMP.Sistemalibreria.model.interfaces;

import com.PINACOMP.Sistemalibreria.model.enums.TipoOperacion;

import java.time.LocalDate;

public interface OperacionBiblioteca {
    // Identificador único de la operación
    int getIdOperacion();

    // Fecha en que se realizó la operación
    LocalDate getFecha();

    // Tipo de operación (enum): PRESTAMO, DEVOLUCION o VENTA
    TipoOperacion getTipoOperacion();

    // Muestra un resumen detallado de la operación
    void mostrarResumen();

}
