package com.PINACOMP.Sistemalibreria.data;

import com.PINACOMP.Sistemalibreria.model.entidades.Cliente;
import com.PINACOMP.Sistemalibreria.model.entidades.Libro;
import com.PINACOMP.Sistemalibreria.model.entidades.Prestamo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PrestamoData {
    private static final List<Prestamo> listaPrestamos = new ArrayList<>();

    static {
        Cliente cli1 = new Cliente(1, "laura.mendoza@gmail.com", "Av. Reforma 123, CDMX");
        Cliente cli2 = new Cliente(2, "roberto.silva@yahoo.com", "Calle 5 de Mayo 45, Puebla");
        Cliente cli3 = new Cliente(3, "karla.romero@hotmail.com", "Blvd. Independencia 88, Torreón");
        Cliente cli4 = new Cliente(4, "fernando.gomez@gmail.com", "Av. Juárez 10, Guadalajara");

        Libro libro1 = Biblioteca.obtenerLibros().get(0); // Ej: El Principito
        Libro libro2 = Biblioteca.obtenerLibros().get(1); // Ej: 1984
        Libro libro3 = Biblioteca.obtenerLibros().get(2); // Ej: Rayuela
        Libro libro4 = Biblioteca.obtenerLibros().get(1); // Ej: Crónica de una muerte anunciada

        listaPrestamos.add(new Prestamo(101, LocalDate.of(2025, 11, 10), cli1, libro1));
        listaPrestamos.add(new Prestamo(102, LocalDate.of(2025, 11, 11), cli2, libro2));
        listaPrestamos.add(new Prestamo(103, LocalDate.of(2025, 11, 12), cli3, libro3));
        listaPrestamos.add(new Prestamo(104, LocalDate.of(2025, 11, 13), cli4, libro4));
    }

    public static List<Prestamo> obtenerPrestamos() {
        return listaPrestamos;
    }

    public static void agregarPrestamo(Prestamo prestamo) {
        listaPrestamos.add(prestamo);
    }

}
