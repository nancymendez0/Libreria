package com.PINACOMP.Sistemalibreria.model.enums;

public enum TipoPuesto {
    VENDEDOR("Vendedor de piso"),
    ADMIN("Administrador del sistema");
    private final String puesto;

    TipoPuesto(String puesto) {
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return puesto;
    }
}
