package com.PINACOMP.Sistemalibreria.model.entidades;
import com.PINACOMP.Sistemalibreria.model.interfaces.Buscador;
import com.PINACOMP.Sistemalibreria.model.enums.TipoGenero;

import java.util.ArrayList;
import java.util.List;

//Implementa la interfaz buscador para permitir busqueda por atributos
public class Libro implements Buscador {
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
    //Getters
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
    //ToStrins representacion textual
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
    //implementacion de métodos de busqueda
    //Busca coincidencias generales por título, autor o editorial.

    @Override
    public List<Libro> buscar(String criterio) {
        List<Libro> resultado = new ArrayList<>();
        if (titulo.toLowerCase().contains(criterio.toLowerCase()) ||
                autor.getNombre().toLowerCase().contains(criterio.toLowerCase()) ||
                editorial.toLowerCase().contains(criterio.toLowerCase())) {
            resultado.add(this);
        }
        return resultado;
    }

    //Busca libros que coincidan con el género especificado.

    @Override
    public List<Libro> busquedaGeneroLibro(TipoGenero genero) {
        List<Libro> resultado = new ArrayList<>();
        if (this.genero == genero) {
            resultado.add(this);
        }
        return resultado;
    }

    //Busca libros por nombre de autor.

    @Override
    public List<Libro> busquedaAutor(String nombre) {
        List<Libro> resultado = new ArrayList<>();
        if (autor.getNombre().equalsIgnoreCase(nombre)) {
            resultado.add(this);
        }
        return resultado;
    }

    //Busca libros por título exacto.

    @Override
    public List<Libro> busquedaTitulo(String titulo) {
        List<Libro> resultado = new ArrayList<>();
        if (this.titulo.equalsIgnoreCase(titulo)) {
            resultado.add(this);
        }
        return resultado;
    }

    //Busca libros por precio exacto.

    @Override
    public List<Libro> busquedaPrecio(double precio) {
        List<Libro> resultado = new ArrayList<>();
        if (this.precio == precio) {
            resultado.add(this);
        }
        return resultado;
    }


}
