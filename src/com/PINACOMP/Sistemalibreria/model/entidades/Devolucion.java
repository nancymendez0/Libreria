package com.PINACOMP.Sistemalibreria.model.entidades;
import com.PINACOMP.Sistemalibreria.model.enums.TipoOperacion;
import com.PINACOMP.Sistemalibreria.model.interfaces.OperacionBiblioteca;

import java.time.LocalDate;
//clase que representa una devolucion en el sistema
//registra la fecha de devolucion
public class Devolucion implements OperacionBiblioteca {
    //atribututos por interfaz
    private int idOperacion;
    private LocalDate fecha;
    private final TipoOperacion tipoOperacion= TipoOperacion.DEVOLUCION;
    //atributos especificos de la devolucion
    private int idPrestamo;
    private boolean retraso;
    private double multa;
    private boolean confirmada;
    //constructor que inicializa los atributos de la devolcuion
    public Devolucion(int idOperacion, LocalDate fecha, int idPrestamo, boolean retraso, double multa) {
        this.idOperacion = idOperacion;
        this.fecha = fecha;
        this.idPrestamo = idPrestamo;
        this.retraso = retraso;
        this.multa = multa;
        this.confirmada = false;
    }
    //Metodos interfaz
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

    //representacion textual de la devolucion toString
    @Override
    public String toString() {
        return "Devolución #" + idOperacion +
                " | Préstamo asociado: " + idPrestamo +
                " | Fecha: " + fecha +
                " | Retraso: " + (retraso ? "Sí" : "No") +
                " | Multa: $" + multa +
                " | Confirmada: " + (confirmada ? "Sí" : "No");
    }

  //Métodos adicionales
  public void confirmarDevolucion() {
      this.confirmada = true;
  }

    public boolean tieneMulta() {
        return multa > 0;
    }

    public boolean fueRetrasada() {
        return retraso;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public double getMulta() {
        return multa;
    }

    public boolean isConfirmada() {
        return confirmada;
    }


}
