package com.PINACOMP.Sistemalibreria.model.entidades;
import java.time.LocalDate;
//clase que representa una devolucion en el sistema
//registra la fecha de devolucion
public class Devolucion extends OperacionBiblioteca{
    private int idPrestamo;
    private boolean retraso;
    private double multa;
    //constructor que inicializa los atributos de la devolcuion
    public Devolucion(int idOperacion, LocalDate fecha, int idPrestamo,
                      boolean conRetraso, double multa) {
        super(idOperacion, fecha);
        this.idPrestamo = idPrestamo;
        this.retraso = retraso;
        this.multa = multa;
    }
    //representacion de la devolucion
    @Override
    public void mostrarResumen() {
        System.out.println("Devolución #" + idOperacion + " | Préstamo: " + idPrestamo +
                " | Fecha: " + fecha + " | Retraso: " + retraso +
                " | Multa: $" + multa);
    }
}
