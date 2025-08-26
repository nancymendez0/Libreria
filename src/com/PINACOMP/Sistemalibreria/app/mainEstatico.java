package com.PINACOMP.Sistemalibreria.app;

import com.PINACOMP.Sistemalibreria.model.entidades.*;
import com.PINACOMP.Sistemalibreria.model.enums.*;

import java.time.LocalDate;
import java.util.Arrays;

public class mainEstatico {
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

        //Creando instacia de novelas
        Novelas n1 = new Novelas(2,"Romeo y Julieta",500.56,"126775gth3", TipoGenero.ROMANTICO, "Santillana", Tiposubgenero.HISTORICO, 560,Tipoedicion.EDICIONBOLSILLO);
        System.out.println(n1.toString());
        Autor autor = new Autor(
                1,
                "Laura",
                "Méndez",
                "González",
                "laura.mendez@gmail.com",
                45,
                TipoSexo.Femenino,
                TipoNacionalidad.MEXICANA,
                LocalDate.of(1980, 3, 15),
                12
        );

        // Crear cliente con datos completos
        Cliente cliente = new Cliente(
                101,
                "Nancy",
                "Mendez",
                "nancy.mendez@gmail.com",
                30,
                TipoSexo.Femenino,
                TipoPago.Tarjeta_credito,
                "Av. Reforma 123",
                555123
        );

        // Crear préstamo
        Prestamo prestamo = new Prestamo(
                1,
                LocalDate.of(2025, 8, 10),
                cliente.getId(),
                "Álgebra Lineal"
        );

        // Crear devolución
        Devolucion devolucion = new Devolucion(
                2,
                LocalDate.of(2025, 8, 15),
                prestamo.getIdOperacion(),
                true,
                25.0
        );

        // Crear venta
        Venta venta = new Venta(
                3,
                LocalDate.of(2025, 8, 12),
                "Cálculo Vectorial",
                320.0
        );

        // Crear reporte
        Reporte reporte = new Reporte(
                "Resumen Semanal",
                "Del 10 al 15 de agosto",
                1,
                1,
                25.0,
                Arrays.asList("Álgebra Lineal", "Cálculo Integral")
        );

        // Mostrar resúmenes
        prestamo.mostrarResumen();
        devolucion.mostrarResumen();
        venta.mostrarResumen();
        reporte.mostrarResumen();

    }
}
