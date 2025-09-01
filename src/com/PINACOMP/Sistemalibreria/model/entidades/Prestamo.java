package com.PINACOMP.Sistemalibreria.model.entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Prestamo implements OperacionBiblioteca {
    //nuevos atributos para implementar la interfaz
    private String idOperacion;
    private LocalDate fecha;
    private int idCliente;
    private List<Libro> librosPrestados;
    //constructor que inicializa los atributos del préstamo incluyendo los heredados
   //Consructor Actualizado
    public Prestamo(String idOperacion, LocalDate fecha, int idCliente, String libro) {
        this.idOperacion = idOperacion;
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.librosPrestados = librosPrestados;
    }
    public void mostrarResumen() {
        System.out.println(this.toString());
    }
    //sobre escribe toString para representar el préstamo como texto y usar en main para mostrar la información

    @Override
    public String toString() {
        return "Préstamo #" + idOperacion + " | Cliente: " + idCliente + " | Libro: " + libro +
                " | Fecha : " + fecha;
    }
}
