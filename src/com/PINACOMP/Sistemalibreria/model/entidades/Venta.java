package com.PINACOMP.Sistemalibreria.model.entidades;

import com.PINACOMP.Sistemalibreria.model.enums.EstadoOperacion;
import com.PINACOMP.Sistemalibreria.model.enums.TipoOperacion;
import com.PINACOMP.Sistemalibreria.model.interfaces.OperacionBiblioteca;

import java.time.LocalDate;

public class Venta implements OperacionBiblioteca {
    // Atributos requeridos por la interfaz
    private final int idOperacion;
    private final LocalDate fecha;
    private final TipoOperacion tipoOperacion = TipoOperacion.VENTA;
    private EstadoOperacion estadoOperacion;

    // Atributos específicos de la venta
    private final Libro libro;
    private final Cliente cliente;
    private final double precio;

    // Constructor
    public Venta(int idOperacion, LocalDate fecha, Cliente cliente, Libro libro, double precio) {
        this.idOperacion = idOperacion;
        this.fecha = fecha;
        this.cliente=cliente;
        this.libro = libro;
        this.precio = precio;

        //procesarVenta();
    }


    // Lógica de venta con validación de stock y estado
    private void procesarVenta() {
        if (libro.getStock() > 0) {
            libro.setStock(libro.getStock() - 1);
            estadoOperacion = EstadoOperacion.FINALIZADA;
            System.out.println("Venta realizada: " + libro.getTitulo() +
                    " | Precio: $" + precio +
                    " | Stock restante: " + libro.getStock());
        } else {
            estadoOperacion = EstadoOperacion.CANCELADA;
            System.out.println(" Venta cancelada. El libro '" + libro.getTitulo() + "' está agotado.");
        }
    }

    // Métodos requeridos por la interfaz
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
        System.out.println(" RESUMEN DE VENTA");
        System.out.println("ID Operación: " + idOperacion);
        System.out.println("Fecha: " + fecha);
        System.out.println("Libro: " + libro.getTitulo());
        System.out.println("Precio: $" + precio);
        System.out.println("Estado: " + estadoOperacion);
        System.out.println("Stock actual: " + libro.getStock());
    }

    // Métodos adicionales
    public EstadoOperacion getEstadoOperacion() {
        return estadoOperacion;
    }

    public Libro getLibro() {
        return libro;
    }

    public double getPrecio() {
        return precio;
    }

    public int getId(){
        return this.cliente.getId();
    }
    public String getTitulo(){
        return this.libro.getTitulo();
    }
}



