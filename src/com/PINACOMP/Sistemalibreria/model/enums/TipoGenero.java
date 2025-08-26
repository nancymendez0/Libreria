package com.PINACOMP.Sistemalibreria.model.enums;

public enum TipoGenero {
    NARRATIVO("Narrativo"),
    LIRICO("Lírico"),
    DRAMATICO("Dramático"),
    DIDACTICO("Didáctico"),
    FANTASIA("Fantasía"),
    DRAMA("Drama"),
    ROMANCE("Romance"),
    TERROR("Terror"),
    CIENTIFICO("Científico"),
    EDUCATIVO("Educativo"),
    ENTRETENIMIENTO("Entretenimiento"),
    AVENTURA("Aventura"), NOVELA("NOVELA"), LITERARIO("LITERARIO"), ROMANTICO("ROMANTICO");

    private final String descripcion;

    TipoGenero(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }


}
