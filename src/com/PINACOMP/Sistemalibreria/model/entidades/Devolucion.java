package com.PINACOMP.Sistemalibreria.model.entidades;
import com.PINACOMP.Sistemalibreria.model.enums.EstadoOperacion;
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
    private EstadoOperacion estadoOperacion;
    //atributos especificos de la devolucion
    private int idPrestamo;
    private Libro libro;
    private boolean retraso;
    private double multa;
    private boolean confirmada;
    //constructor que inicializa los atributos de la devolcuion
    public Devolucion(int idOperacion, LocalDate fecha, int idPrestamo, Libro libro, boolean retraso, double multa) {
        this.idOperacion = idOperacion;
        this.fecha = fecha;
        this.idPrestamo = idPrestamo;
        this.libro = libro;
        this.retraso = retraso;
        this.multa = multa;
        this.confirmada = false;
        this.estadoOperacion = EstadoOperacion.PENDIENTE;
    }

    public Devolucion(int idOperacion, LocalDate now, TipoOperacion tipoOperacion, EstadoOperacion estadoOperacion, LocalDate now1) {
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

    //representacion textual de la devolucion toString
    @Override
    public void mostrarResumen() {
        System.out.println(" RESUMEN DE DEVOLUCIÓN");
        System.out.println("ID Operación: " + idOperacion);
        System.out.println("Fecha: " + fecha);
        System.out.println("Préstamo asociado: " + idPrestamo);
        System.out.println("Libro: " + libro.getTitulo());
        System.out.println("Retraso: " + (retraso ? "Sí" : "No"));
        System.out.println("Multa: $" + multa);
        System.out.println("Confirmada: " + (confirmada ? "Sí" : "No"));
        System.out.println("Estado: " + estadoOperacion);
        System.out.println("Stock actual: " + libro.getStock());
    }

    // Métodos adicionales
    public void confirmarDevolucion() {
        if (!confirmada) {
            confirmada = true;
            libro.setStock(libro.getStock() + 1);
            estadoOperacion = retraso ? EstadoOperacion.RETRASADA : EstadoOperacion.FINALIZADA;
            System.out.println(" Devolución confirmada: " + libro.getTitulo() + " | Stock actualizado: " + libro.getStock());
        } else {
            System.out.println(" La devolución ya fue confirmada.");
        }
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

    public EstadoOperacion getEstadoOperacion() {
        return estadoOperacion;
    }




}
