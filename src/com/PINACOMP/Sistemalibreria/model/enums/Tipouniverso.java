package com.PINACOMP.Sistemalibreria.model.enums;

public enum Tipouniverso {
    MARVEL("Marvel Comics"),
    DC("DC Comics"),
    IMAGE("Image Comics"),
    DARKHOUSE("Dark house Comics"),
    VALIANT("Valiant Comics"),
    IDW("IDW Comics"),
    MANGA("Manga");
    private final String universo;

    Tipouniverso(String universo) {
        this.universo = universo;
    }

    @Override
    public String toString() {
        return this.universo;
    }
}
