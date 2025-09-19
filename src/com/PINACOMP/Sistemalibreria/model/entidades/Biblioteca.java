package com.PINACOMP.Sistemalibreria.model.entidades;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.PINACOMP.Sistemalibreria.model.enums.TipoGenero;
import com.PINACOMP.Sistemalibreria.model.enums.TipoNacionalidad;
import com.PINACOMP.Sistemalibreria.model.enums.TipoSexo;


public class Biblioteca {
    public static List<Libro> crearBiblioteca() {
        List<Libro> libros = new ArrayList<>();

        // Autor para venta
        Autor autor1 = new Autor(
                1,
                "Gabriel",
                "García",
                "Márquez",
                "gabriel.marquez@sudamericana.com",
                87,
                TipoSexo.Masculino,
                TipoNacionalidad.MEXICANA,
                LocalDate.of(1927, 3, 6),
                25
        );

        libros.add(new Libro(
                1,
                "Cien años de soledad",
                autor1,
                120.0,
                "CBDBC",
                TipoGenero.NARRATIVO,
                "Sudamericana",
                5
        ));

        // Autor para préstamo
        Autor autor2 = new Autor(
                2,
                "Miguel",
                "de Cervantes",
                "Saavedra",
                "miguel.cervantes@alcala.es",
                68,
                TipoSexo.Masculino,
                TipoNacionalidad.ESPAÑOLA,
                LocalDate.of(1547, 9, 29),
                12
        );

        libros.add(new Libro(
                2,
                "Don Quijote de la Mancha",
                autor2,
                95.0,
                "DHJVBD",
                TipoGenero.NARRATIVO,
                "Francisco de Robles",
                3
        ));

        // Autor para devolución
        Autor autor3 = new Autor(
                3,
                "Mario",
                "Vargas",
                "Llosa",
                "mario.llosa@seixbarral.pe",
                79,
                TipoSexo.Masculino,
                TipoNacionalidad.MEXICANA,
                LocalDate.of(1936, 3, 28),
                18
        );

        libros.add(new Libro(
                3,
                "La ciudad y los perros",
                autor3,
                88.0,
                "FDHFJDF",
                TipoGenero.NARRATIVO,
                "Seix Barral",
                0 // stock agotado para probar devolución
        ));

        return libros;
    }

}
