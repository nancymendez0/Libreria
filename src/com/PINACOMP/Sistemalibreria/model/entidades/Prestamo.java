package com.PINACOMP.Sistemalibreria.model.entidades;

import java.time.LocalDate;

public class Prestamo extends OperacionBiblioteca {
    private int idCliente;
    private Libro libro;
    //constructor que inicializa los atributos del préstamo incluyendo los heredados
    public Prestamo(int idOperacion, LocalDate fecha, int idCliente, String libro) {
        super(idOperacion, fecha);
        this.idCliente = idCliente;
        this.libro = libro;
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
