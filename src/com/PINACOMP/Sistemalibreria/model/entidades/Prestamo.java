package com.PINACOMP.Sistemalibreria.model.entidades;


import com.PINACOMP.Sistemalibreria.model.enums.EstadoOperacion;
import com.PINACOMP.Sistemalibreria.model.enums.TipoOperacion;
import com.PINACOMP.Sistemalibreria.model.interfaces.OperacionBiblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
//Representa una operacion de la biblioteca , prestamo de libro en el sistema de la biblioteca
public class Prestamo implements OperacionBiblioteca {
    //nuevos atributos para implementar la interfaz
    private int idOperacion;
    private LocalDate fecha;
    private final TipoOperacion tipoOperacion = TipoOperacion.PRESTAMO;
    private EstadoOperacion estadoOperacion;
    //Atributos especificos del prestamo
    private int idCliente;
    private Libro libro; // préstamo de un único libro
    private List<Libro> librosPrestados; // opcional: préstamo múltiple
    private LocalDate fechaDevolucionEstimada;
    private LocalDate fechaOperacion;
    private boolean devuelto;

    //constructor que inicializa los atributos del préstamo incluyendo los heredados
   //Consructor Actualizado
    public Prestamo(int idOperacion, LocalDate fechaOperacion, Cliente cliente, Libro libro) {
        this.idOperacion = idOperacion;
        this.fechaOperacion = fechaOperacion;
        this.fecha = fechaOperacion; // para cumplir con la interfaz
        this.idCliente = cliente.getId(); // ← extrae el ID del objeto Cliente
        this.libro = libro;
        this.fechaDevolucionEstimada = fechaOperacion.plusDays(14); // ← ejemplo: 2 semanas
        this.devuelto = false;
        this.estadoOperacion = EstadoOperacion.HABILITADA;
        this.librosPrestados= new ArrayList<>();
        this.librosPrestados.add(libro);

        //validarDisponibilidad();
    }

/*
    private void validarDisponibilidad() {
        if (libro.getStock() > 0) {
            libro.setStock(libro.getStock() - 1);
            System.out.println(" Préstamo realizado: " + libro.getTitulo() + " | Stock restante: " + libro.getStock());
        } else {
            estadoOperacion = EstadoOperacion.CANCELADA;
            System.out.println(" No se puede realizar el préstamo. El libro '" + libro.getTitulo() + "' está agotado.");
        }
    }
    */

    public void registrarDevolucion(LocalDate fechaReal) {
        if (!devuelto) {
            this.devuelto = true;
            libro.setStock(libro.getStock() + 1);

            if (fechaReal.isAfter(fechaDevolucionEstimada)) {
                estadoOperacion = EstadoOperacion.RETRASADA;
            } else {
                estadoOperacion = EstadoOperacion.FINALIZADA;
            }

            System.out.println(" Devolución registrada: " + libro.getTitulo() + " | Estado: " + estadoOperacion + " | Stock actualizado: " + libro.getStock());
        } else {
            System.out.println("El préstamo ya fue devuelto.");
        }
    }





    //Métodos requeridos por la interfaz
    @Override
    public int getIdOperacion() {
        return idOperacion;
    }

    @Override
    public LocalDate getFecha() {
        return fecha;
    }

    @Override
    public TipoOperacion getTipoOperacion() {
        return tipoOperacion;
    }

    @Override
    public void mostrarResumen() {
        System.out.println(this.toString());
    }
    //Métdo toString que representa la operacion
    @Override
    public String toString() {
        return "Préstamo #" + idOperacion +
                " | Cliente: " + idCliente +
                " | Libro: " + libro.getTitulo() +
                " | Fecha: " + fecha +
                " | Devolución estimada: " + fechaDevolucionEstimada +
                " | Devuelto: " + (devuelto ? "Sí" : "No") +
                " | Estado: " + estadoOperacion;
    }



    //Métodos que no aplican a otras operaciones

    public void marcarComoDevuelto() {
        this.devuelto = true;
    }

    public boolean estaVencido() {
        return !devuelto && LocalDate.now().isAfter(fechaDevolucionEstimada);
    }

    public List<Libro> getLibrosPrestados() {
        return librosPrestados;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public Libro getLibro() {
        return libro;
    }

    public LocalDate getFechaDevolucionEstimada() {
        return fechaDevolucionEstimada;
    }

    public boolean isDevuelto() {
        return devuelto;
    }
    public EstadoOperacion getEstadoOperacion() {
        return estadoOperacion;
    }



}
