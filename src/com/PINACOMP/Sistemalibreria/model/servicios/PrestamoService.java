package com.PINACOMP.Sistemalibreria.model.servicios;

import com.PINACOMP.Sistemalibreria.data.PrestamoData;
import com.PINACOMP.Sistemalibreria.model.entidades.Cliente;
import com.PINACOMP.Sistemalibreria.model.entidades.Libro;
import com.PINACOMP.Sistemalibreria.model.entidades.Prestamo;

import java.time.LocalDate;
import java.util.List;

public class PrestamoService {
    public void prestarPorTitulo(String titulo, Cliente cliente, List<Libro> biblioteca) {
        Libro libroDisponible = null;

        for (Libro libro : biblioteca) {
            List<Libro> encontrados = libro.busquedaTitulo(titulo);
            if (!encontrados.isEmpty()) {
                libroDisponible = encontrados.get(0);
                break;
            }
        }

        if (libroDisponible == null) {
            System.out.println(" No se encontró el libro: " + titulo);
            return;
        }

        if (libroDisponible.getStock() <= 0) {
            System.out.println(" El libro '" + libroDisponible.getTitulo() + "' está agotado.");
            return;
        }

        // Crear préstamo
        int nuevoId = PrestamoData.obtenerPrestamos().size() + 1;
        LocalDate hoy = LocalDate.now();
        LocalDate fechaDevolucionEstimada = hoy.plusDays(14); // ejemplo: 2 semanas

        Prestamo prestamo = new Prestamo(nuevoId, hoy, cliente, libroDisponible);
        PrestamoData.agregarPrestamo(prestamo);

        System.out.println(" Préstamo registrado correctamente.");
    }

    public void mostrarPrestamos() {
        List<Prestamo> prestamos = PrestamoData.obtenerPrestamos();
        if (prestamos.isEmpty()) {
            System.out.println(" No hay préstamos registrados.");
            return;
        }

        for (Prestamo prestamo : prestamos) {
            prestamo.mostrarResumen();
        }
    }


}
