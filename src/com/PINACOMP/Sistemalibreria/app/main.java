package com.PINACOMP.Sistemalibreria.app;

import com.PINACOMP.Sistemalibreria.model.entidades.Comics;
import com.PINACOMP.Sistemalibreria.model.entidades.Libro;
import com.PINACOMP.Sistemalibreria.model.enums.TipoGenero;
import com.PINACOMP.Sistemalibreria.model.enums.Tipoedicion;
import com.PINACOMP.Sistemalibreria.model.enums.Tipouniverso;

public class main {
    public static void main(String[] args) {
        //creando instancias de libros
        Libro l1 = new Libro(1,"Año uno",235.56,"12345kkf23", TipoGenero.FANTASIA, "fraile");
        Libro l2 = new Libro(2, "Fundación", 299.99, "9788499088007", TipoGenero.CIENCIAFICCION, "Isaac Asimov");
        Libro l3 = new Libro(3, "1984", 180.50, "9780451524935", TipoGenero.NOVELA, "George Orwell");
        Libro l4 = new Libro(4, "El Hobbit", 250.00, "9780547928227", TipoGenero.FANTASIA, "J.R.R. Tolkien");
        Libro l5 = new Libro(5, "Cien años de soledad", 220.75, "9780307474728", TipoGenero.NOVELA, "Gabriel García Márquez");
        Libro l6 = new Libro(6, "Sherlock Holmes: Estudio en escarlata", 195.20, "9788491050569", TipoGenero.ROMANTICO, "Arthur Conan Doyle");
        System.out.println(l1.toString());

        //creando instancia de comics
        Comics c1 = new Comics(1,"Año uno",235.56,"12345kkf23", TipoGenero.FANTASIA, "fraile","Batman", Tipouniverso.DC, 2, Tipoedicion.EDICIONDELUXE);
        System.out.println(c1.toString());

    }
}
