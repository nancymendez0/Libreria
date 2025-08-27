package com.PINACOMP.Sistemalibreria.model.entidades;
import com.PINACOMP.Sistemalibreria.model.enums.TipoNacionalidad;
import com.PINACOMP.Sistemalibreria.model.enums.TipoPago;
import com.PINACOMP.Sistemalibreria.model.enums.TipoSexo;

import java.time.LocalDate;
import java.util.Arrays;
public class MainNancy {
    public static void main(String[] args) {
// Crear autor con datos completos
        Autor autor = new Autor(
                1,                                 // id
                "Laura",                           // nombre
                "Méndez",                          // apellidoPaterno
                "Laura.mendez@gmail.com",          // correo
                45,                                // edad
                TipoSexo.Femenino,                 // sexo
                "Mexicana",                        // nacionalidad (String)
                LocalDate.of(1980, 3, 15),         // fechaNacimiento
                TipoNacionalidad.MEXICANA,         // nacionalidad (enum)
                12                                 // cantidadLibros


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
        ) {
            @Override
            public TipoNacionalidad getNacionalidad() {
                return null;
            }
        };

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
