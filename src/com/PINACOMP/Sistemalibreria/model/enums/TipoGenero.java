package com.PINACOMP.Sistemalibreria.model.enums;

public enum TipoGenero {
    TERROR("Terror"),
    ROMANTICO("Romantico"),
    FANTASIA("Fantasia"),
    LITERARIO("Literario"),
    CIENCIAFICCION("Ciencia ficción"),
    NOVELA("Novela");
    private final String genero;

    TipoGenero(String genero) {
        this.genero=genero;
    }

    @Override
    public String toString() {
        return this.genero;
    }
}
