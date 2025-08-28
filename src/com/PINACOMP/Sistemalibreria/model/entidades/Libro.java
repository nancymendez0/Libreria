package com.PINACOMP.Sistemalibreria.model.entidades;

import com.PINACOMP.Sistemalibreria.model.interfaces.Buscador;
import com.PINACOMP.Sistemalibreria.model.enums.TipoGenero;

public class Libro  {
    protected int id;
    protected String titulo;
    Autor autor;
    protected double precio;
    protected String isbn;
    protected TipoGenero genero;
    protected String editorial;
    public Libro(int id, String titulo, Autor autor, double precio, String isbn, TipoGenero genero, String editorial) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
        this.isbn = isbn;
        this.genero = genero;
        this.editorial = editorial;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPrecio() {
        return precio;
    }

    public String getIsbn() {
        return isbn;
    }

    public TipoGenero getGenero() {
        return genero;
    }

    public String getEditorial() {
        return editorial;
    }

    public Autor getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder();
        sb.append("Titulo: ").append(titulo);
        sb.append("\nAutor: ").append(autor);
        sb.append(" \nISBN: ").append(isbn);
        sb.append(" \nPrecio: ").append(precio);
        sb.append(" \nGenero: ").append(genero);
        sb.append(" \nEditorial: ").append(editorial);
        return sb.toString();
    }
}
