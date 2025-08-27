package com.PINACOMP.Sistemalibreria.app;

import com.PINACOMP.Sistemalibreria.model.entidades.Autor;
import com.PINACOMP.Sistemalibreria.model.entidades.Libro;
import com.PINACOMP.Sistemalibreria.model.enums.*;

import java.time.LocalDate;

public class main {
            public static void main(String[] args) {
                // Creando instancias de autores
                Autor autor1 = new Autor(
                        101, "Isaac", "Asimov", "asimov@ciencia.com", 72,
                        TipoSexo.Masculino, "Goldstein",
                        LocalDate.of(1920, 1, 2),
                        TipoNacionalidad.ESTADOUNIDENSE, 500
                );

                Autor autor2 = new Autor(
                        102, "J.R.R.", "Tolkien", "tolkien@fantasia.com", 81,
                        TipoSexo.Masculino, "Reuel",
                        LocalDate.of(1892, 1, 3),
                        TipoNacionalidad.BRITANICA, 35
                );

                Autor autor3 = new Autor(
                        103, "Marie", "Curie", "curie@fisica.com", 66,
                        TipoSexo.Femenino, "Sklodowska",
                        LocalDate.of(1867, 11, 7),
                        TipoNacionalidad.FRANCESA, 12
                );

                Autor autor4 = new Autor(
                        104, "Agatha", "Christie", "christie@misterio.com", 85,
                        TipoSexo.Femenino, "Miller",
                        LocalDate.of(1890, 9, 15),
                        TipoNacionalidad.BRITANICA, 80
                );
                // Creando instancias de libros
                Libro libro1 = new Libro(
                        1, "Fundación", 255.55, "9788478887195",
                        TipoGenero.NARRATIVO, "Editorial Planeta",autor1
                );
                libro1.autor = autor1;
                libro1.genero = Tiposubgenero.NOVELA.getGeneroPrincipal();

                Libro libro2 = new Libro(
                        2, "El Señor de los Anillos", 199.99, "9788478887196",
                        TipoGenero.NARRATIVO, "Minotauro",autor2
                );
                libro2.autor = autor2;
                libro2.genero = Tiposubgenero.EPOPEYA.getGeneroPrincipal();

                Libro libro3 = new Libro(
                        3, "La radiactividad", 175.55, "9788478887197",
                        TipoGenero.NARRATIVO, "Santillana",autor3
                );
                libro3.autor = autor3;
                libro3.genero = Tiposubgenero.ENSAYO.getGeneroPrincipal();

                Libro libro4 = new Libro(
                        4, "Asesinato en el Orient Express", 150.55, "9788478887198",
                        TipoGenero.NARRATIVO, "Espasa",autor4
                );
                libro4.autor = autor4;
                libro4.genero = Tiposubgenero.NOVELA.getGeneroPrincipal();
                Autor autorComic = new Autor(
                        105, "Frank", "Miller", "fmiller@dc.com", 68,
                        TipoSexo.Masculino, "James",
                        LocalDate.of(1957, 1, 27),
                        TipoNacionalidad.ESTADOUNIDENSE, 45
                );

                Libro comic1 = new Libro(
                        5, "Batman: Año Uno", 100.99, "9788478887201",
                        TipoGenero.NARRATIVO, "DC Comics",autorComic
                );
                comic1.autor = autorComic;
                comic1.genero = Tiposubgenero.COMIC.getGeneroPrincipal();
                Autor autorNovela = new Autor(
                        106, "Jane", "Austen", "jausten@literatura.com", 41,
                        TipoSexo.Femenino, "Leigh",
                        LocalDate.of(1775, 12, 16),
                        TipoNacionalidad.BRITANICA, 6
                );

                Libro novela1 = new Libro(
                        6, "Orgullo y Prejuicio", 120.50, "9788478887202",
                        TipoGenero.NARRATIVO, "Penguin Classics",autorNovela
                );
                novela1.autor = autorNovela;
                novela1.genero = Tiposubgenero.NOVELA.getGeneroPrincipal();

                // Imprimiendo resultados
                System.out.println(libro1);
                System.out.println(libro2);
                System.out.println(libro3);
                System.out.println(libro4);
                System.out.println(comic1);
                System.out.println(novela1);
            }
        }
