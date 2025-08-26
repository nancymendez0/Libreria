package com.PINACOMP.Sistemalibreria.model.enums;

public enum Tiposubgenero {

    NOVELA("NOVELA"),
    PSICOLOGICA("Psicológica"),
    EPOPEYA("Epopeya"),
    COMEDIA("Comedia"),
    ENSAYO("Ensayo"),
    TESIS("Tesis"),
    TEST("Test"),
    FRAILE("Fraile"),
    SIN_SUBGENERO("Sin subgénero"), POESIA("Poesia");

    private final String descripcion;

    Tiposubgenero(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }








}
