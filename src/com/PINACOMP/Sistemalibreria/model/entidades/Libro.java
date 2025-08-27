package com.PINACOMP.Sistemalibreria.model.entidades;

import com.PINACOMP.Sistemalibreria.model.enums.TipoGenero;
import com.PINACOMP.Sistemalibreria.model.enums.Tiposubgenero;

public class Libro {
    protected int id;
    protected String titulo;
    protected double precio;
    protected String isbn;
    public TipoGenero genero;
    protected Tiposubgenero subgenero;
    protected String editorial;
    public Autor autor;

    public Libro(int id, String titulo, double precio, String isbn, TipoGenero genero, String editorial, Autor autor) {
        this.id = id;
        this.titulo = titulo;
        this.precio = precio;
        this.isbn = isbn;
        this.genero = genero;
        this.subgenero = subgenero;
        this.editorial = editorial;
        this.autor = autor;
    }



    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public double getPrecio() { return precio; }
    public String getIsbn() { return isbn; }
    public TipoGenero getGenero() { return genero; }
    public Tiposubgenero getSubgenero() { return subgenero; }
    public String getEditorial() { return editorial; }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Título: " + titulo +
                " | Precio: $" + precio +
                " | ISBN: " + isbn +
                " | Género: " + genero +
                " | Subgénero: " + subgenero +
                " | Editorial: " + editorial;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void setSubgenero(Tiposubgenero subgenero) {
        this.subgenero = subgenero;
    }
}
