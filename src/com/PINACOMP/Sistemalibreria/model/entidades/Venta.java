package com.PINACOMP.Sistemalibreria.model.entidades;
import java.time.LocalDate;

//clase ventas heredando de OperacionBiblioteca
public class Venta extends OperacionBiblioteca {
    private String libro;
    private double precio;
    //constructor publico de la clase ventas
    public Venta(int idOperacion, LocalDate fecha, String libro, double precio) {
        super(idOperacion, fecha);
        this.libro = libro;
        this.precio = precio;
    }
    //método publico que imprime un resumen de la venta
    @Override
    public void mostrarResumen() {
        System.out.println("Venta #" + idOperacion + " | Libro: " + libro +
                " | Fecha: " + fecha + " | Precio: $" + precio);
    }
}
