package com.PINACOMP.Sistemalibreria.model.entidades;

import com.PINACOMP.Sistemalibreria.model.enums.TipoGenero;
import com.PINACOMP.Sistemalibreria.model.enums.Tipoedicion;
import com.PINACOMP.Sistemalibreria.model.enums.Tipouniverso;

public class Comics extends Libro{
    String personaje;
    Tipouniverso universo;
    int volumen;
    Tipoedicion edicion;

    public Comics(int id, String titulo, Autor autor, double precio, String isbn, TipoGenero genero, String editorial, String personaje, Tipouniverso universo, int volumen, Tipoedicion edicion) {
        super(id, titulo, autor, precio, isbn, genero, editorial);
        this.personaje = personaje;
        this.universo = universo;
        this.volumen = volumen;
        this.edicion = edicion;
    }

    public String getPersonaje() {
        return personaje;
    }

    public Tipouniverso getUniverso() {
        return universo;
    }

    public int getVolumen() {
        return volumen;
    }

    public Tipoedicion getEdicion() {
        return edicion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" Personaje: ").append(personaje );
        sb.append(" Universo: ").append(universo );
        sb.append(" Volumen: ").append(volumen );
        sb.append(" Edicion:").append(edicion);

        return super.toString() +sb.toString();
    }
}
