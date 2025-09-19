package com.PINACOMP.Sistemalibreria.model.interfaces;
//Importación de clases necesarias para el tipo de retorno y parámetros
import com.PINACOMP.Sistemalibreria.model.entidades.BuscadorObras;
import com.PINACOMP.Sistemalibreria.model.entidades.Libro;
import com.PINACOMP.Sistemalibreria.model.enums.TipoGenero;
import java.util.List;

//Interfaz que define lor métodos de búsqueda para libros , acuerda que deben cumplir las calses que la implementen

public interface Buscador {

    //propósito del método , parámetros y retorno
    //Espera una cadena de texto para buscar por género
    //Regresa una lista de objetos (libros) que tienen el mismo genero
    /**
     * Busca obras que coincidan con el criterio dado.
     * @param criterio Cadena de búsqueda (título, autor, etc.)
     * @return Lista de libros que cumplen con el criterio.
     */
    List<Libro> buscar(String criterio);


    /**
     * Busca libros por género literario.
     * @param genero el género a buscar
     * @return lista de libros que coinciden con el género
     */
    List<Libro> busquedaGeneroLibro(TipoGenero genero);


    /**
     * Busca libros por nombre de autor.
     * @param nombre nombre del autor
     * @return lista de libros escritos por ese autor
     */
    List<Libro> busquedaAutor(String nombre);

    /**
     * Busca libros por título.
     * @param titulo título del libro
     * @return lista de libros cuyo título coincide
     */
    List<Libro> busquedaTitulo(String titulo);

    /**
     * Busca libros por precio exacto.
     * @param precio valor monetario del libro
     * @return lista de libros con ese precio
     */
    List<Libro> busquedaPrecio(double precio);


}
