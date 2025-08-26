package com.PINACOMP.Sistemalibreria.model.enums;

public enum TipoNacionalidad {
    MEXICANA,
    ARGENTINA,
    ESPAÑOLA,
    ESTADOUNIDENSE,
    BRITANICA,
    FRANCESA,
    DESCONOCIDA;
    @Override
    public String toString() {
        String nombre=name().toLowerCase();
        //Da formato a nombre que contiene la nacionalidad , cambiando la primer letra a mayúscula
        return nombre.substring(0, 1).toUpperCase() + nombre.substring(1);
    }
}
