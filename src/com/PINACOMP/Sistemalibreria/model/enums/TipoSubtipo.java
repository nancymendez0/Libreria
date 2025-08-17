package com.PINACOMP.Sistemalibreria.model.enums;

public enum TipoSubtipo {
    Problemario,
    Manual,
    Guia,
    Formulario,
    Tesis,
    Desconocido;

    @Override
    public String toString() {
        String nombre = name().toLowerCase().replace("_","");
        return nombre.substring(0, 1).toUpperCase() + nombre.substring(1);
    }
}
