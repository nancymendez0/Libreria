package com.PINACOMP.Sistemalibreria.data;

import com.PINACOMP.Sistemalibreria.model.entidades.Autor;
import com.PINACOMP.Sistemalibreria.model.entidades.Libro;
import com.PINACOMP.Sistemalibreria.model.enums.TipoGenero;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private static final List<Libro> libros = new ArrayList<>();

    // Bloque estático para inicializar una sola vez
    static {
        Autor autor1 = new Autor("Gabriel", "Garcia", "Márquez");
        Autor autor2 = new Autor("Alan", "Oswald", "Moore");

        libros.add(new Libro(
                1,
                "Cien años de soledad",
                autor1,
                299.0,
                "ISBN-001",
                TipoGenero.NARRATIVO,
                "Editorial Sudamericana", 34
        ));

        libros.add(new Libro(
                2,
                "Watchmen",
                autor2,
                349.0,
                "ISBN-002",
                TipoGenero.NARRATIVO,
                "DC Comics", 10
        ));

        libros.add(new Libro(
                3,
                "La casa de los espíritus",
                autor1,
                279.0,
                "ISBN-003",
                TipoGenero.NARRATIVO,
                "Editorial Plaza & Janés",12
        ));
    }

    // Método para acceder siempre a la misma lista
    public static List<Libro> obtenerLibros() {
        return libros;
    }
}
