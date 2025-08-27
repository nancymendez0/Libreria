package com.PINACOMP.Sistemalibreria.model.entidades;

import com.PINACOMP.Sistemalibreria.app.Buscador;
import com.PINACOMP.Sistemalibreria.model.enums.TipoGenero;

public class Libro implements Buscador {
    protected int id;
    protected String titulo;
    Autor autor;
    protected double precio;
    protected String isbn;
    protected TipoGenero genero;
    protected String editorial;
    //generando nuestro constructor vacio
    public Libro() {
    }

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
        sb.append(" ISBN: ").append(isbn);
        sb.append(" Precio: ").append(precio);
        sb.append(" Genero: ").append(genero);
        sb.append(" Editorial: ").append(editorial);
        return sb.toString();
    }
}
