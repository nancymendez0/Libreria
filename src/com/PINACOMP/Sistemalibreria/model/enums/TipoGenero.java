package com.PINACOMP.Sistemalibreria.model.enums;
//ENUM que representa los géenros literarios , tomando una clasificacion academica
public enum TipoGenero {
    NARRATIVO("Narrativo"),
    LIRICO("Lírico"),
    DRAMATICO("Dramático"),
    DIDACTICO("Didáctico"),
    EPICO("Épico");

    private final String etiqueta;

    /**
     * Constructor del enum que asigna la descripción legible.
     * @param etiqueta Representación textual del género.
     */
    TipoGenero(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    /**
     * Devuelve la descripción legible del género.
     * @return descripción como cadena.
     */
    @Override
    public String toString() {
        return etiqueta;
    }

    public String getEtiqueta() {
        return etiqueta;
    }


}
