package com.PINACOMP.Sistemalibreria.model.entidades;

import com.PINACOMP.Sistemalibreria.model.interfaces.Buscador;
import com.PINACOMP.Sistemalibreria.model.enums.TipoGenero;

import java.util.ArrayList;
import java.util.List;
import com.sistemalibreria.excepciones.*;

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
        //validacion
        if (genero == null) {
            throw new GeneroNoReconocidoException("null");
        }
        //método busqueda por genero
        List<Libro> resultado = new ArrayList<>();
        for (Libro libro : biblioteca) {
            if (libro.getGenero() == genero) {
                resultado.add(libro);
            }
        }
        //validacion
        if (resultado.isEmpty()) {
            throw new BúsquedaInvalidaException("No se encontraron libros del género '" + genero + "'.");
        }

        return resultado;
    }
    public List<Libro> buscarPorGenero(String entradaGenero) {
        if (entradaGenero == null || entradaGenero.isBlank()) {
            throw new GeneroNoReconocidoException("El género no puede estar vacío.");
        }

        if (!entradaGenero.matches("^[A-ZÁÉÍÓÚÑ]+$")) {
            throw new GeneroNoReconocidoException("El género contiene caracteres inválidos. Solo se permiten letras mayúsculas.");
        }

        // Validar que la palabra exista en el enum TipoGenero
        boolean esGeneroValido = false;
        for (TipoGenero g : TipoGenero.values()) {
            if (g.name().equals(entradaGenero)) {
                esGeneroValido = true;
                break;
            }
        }

        if (!esGeneroValido) {
            throw new GeneroNoReconocidoException("El género '" + entradaGenero + "' no está registrado.");
        }

        // Convertir y buscar
        TipoGenero genero = TipoGenero.valueOf(entradaGenero);
        return busquedaGeneroLibro(genero);

    }

    /**
     * Busca libros por nombre de autor.
     * @param nombre nombre del autor
     * @return lista de libros escritos por ese autor
     */
    @Override
    public List<Libro> busquedaAutor(String nombre) {
        //validacion
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new AutorNoEncontradoException("El nombre del autor no puede estar vacío .");
        }
        //validacion estricta : solo letras y espacios
        if (!nombre.matches("^[A-Za-zÁÉÍÓÚÑáéíóúñ ]+$")) {
            throw new AutorNoEncontradoException("El nombre contiene caracteres especiales . Solo se permiten letras y espacios");
        }

        List<Libro> resultado = new ArrayList<>();
        for (Libro libro : biblioteca) {
            if (libro.getAutor() != null &&
                    libro.getAutor().getNombreCompleto().equalsIgnoreCase(nombre)) {
                resultado.add(libro);
            }
        }
        //validacion
        if (resultado.isEmpty()) {
            throw new AutorNoEncontradoException("No se encontró ningún autor con el nombre '" + nombre.trim() + "'.");
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
        //validacion
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new BúsquedaInvalidaException("El título no puede estar vacío.");
        }

        if (!titulo.matches("^[A-Za-zÁÉÍÓÚÑáéíóúñ0-9 ,.!?\"'()-]+$")) {
            throw new BúsquedaInvalidaException("El título contiene caracteres inválidos.");
        }

        List<Libro> resultado = new ArrayList<>();
        for (Libro libro : biblioteca) {
            if (libro.getTitulo() != null &&
                    libro.getTitulo().equalsIgnoreCase(titulo)) {
                resultado.add(libro);
            }
        }
        //validacion
        if (resultado.isEmpty()) {
            throw new BúsquedaInvalidaException("No se encontró ningún libro con el título '" + titulo + "'.");
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
        //validacion
        if (precio <= 0) {
            throw new PrecioInvalidoException(String.valueOf("El precio debe ser mayor que cero. Valor ingresado: " + precio));
        }
        List<Libro> resultado = new ArrayList<>();
        for (Libro libro : biblioteca) {
            if (Double.compare(libro.getPrecio(), precio) == 0) {
                resultado.add(libro);
            }
        }
        //validacion
        if (resultado.isEmpty()) {
            throw new BúsquedaInvalidaException("No se encontraron libros con precio exacto $" + precio);
        }
        return resultado;
    }
}