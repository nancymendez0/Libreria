package com.PINACOMP.Sistemalibreria.model.enums;

public enum Tiposubgenero {
    NOVELA("Novela", TipoGenero.NARRATIVO),
    COMIC("Cómic", TipoGenero.NARRATIVO),
    POEMA("Poema", TipoGenero.LIRICO),
    TRAGEDIA("Tragedia", TipoGenero.DRAMATICO),
    ENSAYO("Ensayo", TipoGenero.DIDACTICO),
    EPOPEYA("Epopeya", TipoGenero.EPICO);

    private final String etiqueta;
    private final TipoGenero generoPrincipal;

    /**
     * Constructor que vincula el subgénero con su género principal.
     * @param etiqueta Nombre textual del subgénero.
     * @param generoPrincipal Género literario al que pertenece.
     */
    Tiposubgenero(String etiqueta, TipoGenero generoPrincipal) {
        this.etiqueta = etiqueta;
        this.generoPrincipal = generoPrincipal;
    }

    /**
     * Devuelve la etiqueta textual del subgénero.
     * @return Etiqueta como cadena.
     */
    public String getEtiqueta() {
        return etiqueta;
    }

    /**
     * Devuelve el género principal asociado al subgénero.
     * @return Instancia de {@link TipoGenero}.
     */
    public TipoGenero getGeneroPrincipal() {
        return generoPrincipal;
    }

}
