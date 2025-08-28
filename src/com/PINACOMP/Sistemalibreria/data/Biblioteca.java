package com.PINACOMP.Sistemalibreria.data;

import com.PINACOMP.Sistemalibreria.model.entidades.Autor;
import com.PINACOMP.Sistemalibreria.model.entidades.Libro;
import com.PINACOMP.Sistemalibreria.model.enums.TipoGenero;

import java.util.Arrays;
import java.util.List;

public class Biblioteca {
    public static List<Libro> crearBiblioteca() {
        //  Función que crea autores y libros con instanciación válida


        Autor autor1 = new Autor("Gabriel", "Garcia","Márquez");
        Autor autor2 = new Autor("Alan", "Oswald","Moore");
        Libro libro1 = new Libro(
                1,
                "Cien años de soledad",
                autor1,
                299.0,
                "ISBN-001",
                TipoGenero.NARRATIVO,
                "Editorial Sudamericana"
        );

        Libro libro2 = new Libro(
                2,
                "Watchmen",
                autor2,
                349.0,
                "ISBN-002",
                TipoGenero.NARRATIVO,
                "DC Comics"
        );

        Libro libro3 = new Libro(
                3,
                "La casa de los espíritus",
                autor1,
                279.0,
                "ISBN-003",
                TipoGenero.NARRATIVO,
                "Editorial Plaza & Janés"
        );

        return Arrays.asList(libro1, libro2, libro3);

    }
}
