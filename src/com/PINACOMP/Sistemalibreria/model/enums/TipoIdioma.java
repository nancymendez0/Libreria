package com.PINACOMP.Sistemalibreria.model.enums;

public enum TipoIdioma {
    ESPAÑOL,
    FRANCES,
    INGLES,
    DESCONOCIDO;

    @Override
    public String toString() {
        String nombre = name().toLowerCase();
        //Separa el nombre , convirtiendo la primer letra a mayúscula ,despues une el resto del nombre
        return nombre.substring(0, 1).toUpperCase() + nombre.substring(1);
    }
}
