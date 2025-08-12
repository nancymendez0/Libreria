package com.PINACOMP.Sistemalibreria.model.enums;

public enum Tipociencia {
    ASTRONOMIA("Astronomía"),
    FISICA("Física"),
    QUIMICA("Química"),
    MATEMATICAS("Matemáticas"),
    COMPUTACION("Computación"),
    MEDICINA("Medicina"),
    PSICOLOGIA("Psicología"),
    BIOLOGIA("Biología");
    private final String ciencia;

    Tipociencia(String ciencia) {
        this.ciencia = ciencia;
    }

    @Override
    public String toString() {
        return this.ciencia;
    }
}
