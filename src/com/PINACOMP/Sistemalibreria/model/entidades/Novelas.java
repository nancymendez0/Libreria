package com.PINACOMP.Sistemalibreria.model.entidades;

import com.PINACOMP.Sistemalibreria.model.enums.TipoGenero;
import com.PINACOMP.Sistemalibreria.model.enums.Tipoedicion;
import com.PINACOMP.Sistemalibreria.model.enums.Tiposubgenero;

public class Novelas extends Libro {
    Tiposubgenero subgenero;
    int numPaginas;
    Tipoedicion edicion;

    public Novelas(int id, String titulo, double precio, String isbn, TipoGenero genero, String editorial, Tiposubgenero subgenero, int numPaginas, Tipoedicion edicion) {
        super(id, titulo, precio, isbn, genero, editorial);
        this.subgenero = subgenero;
        this.numPaginas = numPaginas;
        this.edicion = edicion;
    }

    public Tiposubgenero getSubgenero() {
        return subgenero;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public Tipoedicion getEdicion() {
        return edicion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" Subgenero: ").append(subgenero);
        sb.append(" Numero de páginas: ").append(numPaginas);
        sb.append(" Tipo de edicion: ").append(edicion);
        return super.toString()+ sb.toString();
    }
}
