package com.PINACOMP.Sistemalibreria.model.servicios;

import com.PINACOMP.Sistemalibreria.data.Biblioteca;
import com.PINACOMP.Sistemalibreria.model.entidades.Libro;

import java.util.ArrayList;
import java.util.List;

public class LibroService {
    private final List<Libro> libros;

    public LibroService() {
        this.libros = Biblioteca.obtenerLibros();
    }
    public List<Libro> obtenerLibros() {
        return libros;
    }
    public void mostrarLibros(List<Libro> resultados){
        if (resultados.isEmpty()){
            System.out.println("No se encontraron resultados");
        }else{
            System.out.println("Tengo "+resultados.size()+" Libros actualmente\n");
            int contador=1;
            for (Libro libro : resultados){
                System.out.println("INFORMACIÓN LIBRO" + contador+ ":");
                System.out.println(libro);
                System.out.println();
                contador++;
            }
        }
    }
}
