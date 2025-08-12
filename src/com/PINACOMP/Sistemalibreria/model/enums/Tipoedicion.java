package com.PINACOMP.Sistemalibreria.model.enums;

public enum Tipoedicion {
    PRIMERAEDICION("Primera edición"),
    REIMPRESION("Reimpresión"),
    EDICIONLIMITADA("Edición elimitada"),
    EDICIONESPECIAL("Edición especial"),
    EDICIONCOLECCIONISTA("Edición coleccionista"),
    EDICIONANIVERSARIO("Edición aniversario"),
    EDICIONILUSTRADA("Edición aniversario"),
    EDICIONDELUXE("Edicion Deluxe"),
    EDICIONBOLSILLO("Edición del bolsillo");
    private final String edicion;

    Tipoedicion(String edicion) {
        this.edicion = edicion;
    }

    @Override
    public String toString() {
        return this.edicion;
    }
}
