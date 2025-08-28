package com.PINACOMP.Sistemalibreria.model.entidades;

import com.PINACOMP.Sistemalibreria.model.interfaces.Buscador;
import com.PINACOMP.Sistemalibreria.model.enums.TipoGenero;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que implementa la interfaz Buscador para realizar búsquedas literarias
 * sobre una colección de libros. Aplica validación semántica y lógica técnica
 * para cada criterio de búsqueda.
 */
public abstract class BuscadorObras implements Buscador {

    private final List<Libro> biblioteca;

    /**
     * Constructor que recibe una colección de libros.
     * @param biblioteca lista de libros disponibles para búsqueda
     */
    public BuscadorObras(List<Libro> biblioteca) {
        this.biblioteca = biblioteca;
    }

    /**
     * Busca libros por género literario.
     * @param genero el género a buscar
     * @return lista de libros que coinciden con el género
     */
    @Override
    public List<Libro> busquedaGeneroLibro(TipoGenero genero) {
        List<Libro> resultado = new ArrayList<>();
        for (Libro libro : biblioteca) {
            if (libro.getGenero() == genero) {
                resultado.add(libro);
            }
        }
        return resultado;
    }

    /**
     * Busca libros por nombre de autor.
     * @param nombre nombre del autor
     * @return lista de libros escritos por ese autor
     */
    @Override
    public List<Libro> busquedaAutor(String nombre) {
        List<Libro> resultado = new ArrayList<>();
        for (Libro libro : biblioteca) {
            if (libro.getAutor() != null &&
                    libro.getAutor().getNombreCompleto().equalsIgnoreCase(nombre)) {
                resultado.add(libro);
            }
        }
        return resultado;
    }

    /**
     * Busca libros por título.
     * @param titulo título del libro
     * @return lista de libros cuyo título coincide
     */
    @Override
    public List<Libro> busquedaTitulo(String titulo) {
        List<Libro> resultado = new ArrayList<>();
        for (Libro libro : biblioteca) {
            if (libro.getTitulo() != null &&
                    libro.getTitulo().equalsIgnoreCase(titulo)) {
                resultado.add(libro);
            }
        }
        return resultado;
    }

    /**
     * Busca libros por precio exacto.
     * @param precio valor monetario del libro
     * @return lista de libros con ese precio
     */
    @Override
    public List<Libro> busquedaPrecio(double precio) {
        List<Libro> resultado = new ArrayList<>();
        for (Libro libro : biblioteca) {
            if (Double.compare(libro.getPrecio(), precio) == 0) {
                resultado.add(libro);
            }
        }
        return resultado;
    }
}