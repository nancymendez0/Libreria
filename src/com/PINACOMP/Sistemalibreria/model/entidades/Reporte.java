package com.PINACOMP.Sistemalibreria.model.entidades;
import java.util.List;

//Clase que representa un reporte general de operaciones en la biblioteca.
//
public class Reporte {
    private String titulo;
    private String periodo;
    private int totalPrestamos;
    private int totalDevoluciones;
    private double totalMultas;
    private List<String> librosMasPrestados;

    // Constructor con parámetros
    public Reporte(String titulo, String periodo, int totalPrestamos,
                   int totalDevoluciones, double totalMultas,
                   List<String> librosMasPrestados) {
        this.titulo = titulo;
        this.periodo = periodo;
        this.totalPrestamos = totalPrestamos;
        this.totalDevoluciones = totalDevoluciones;
        this.totalMultas = totalMultas;
        this.librosMasPrestados = librosMasPrestados;
    }

    // Getters y Setters
    //Encapsulamiento , los atributos son privados impidiendo el acceso directo fuera de la clase
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public int getTotalPrestamos() {
        return totalPrestamos;
    }

    public void setTotalPrestamos(int totalPrestamos) {
        this.totalPrestamos = totalPrestamos;
    }

    public int getTotalDevoluciones() {
        return totalDevoluciones;
    }

    public void setTotalDevoluciones(int totalDevoluciones) {
        this.totalDevoluciones = totalDevoluciones;
    }

    public double getTotalMultas() {
        return totalMultas;
    }

    public void setTotalMultas(double totalMultas) {
        this.totalMultas = totalMultas;
    }

    public List<String> getLibrosMasPrestados() {
        return librosMasPrestados;
    }

    public void setLibrosMasPrestados(List<String> librosMasPrestados) {
        this.librosMasPrestados = librosMasPrestados;
    }

    // Método para mostrar el resumen del reporte en consola
    public void mostrarResumen() {
        System.out.println("Reporte: " + titulo);
        System.out.println("Periodo: " + periodo);
        System.out.println("Total de préstamos: " + totalPrestamos);
        System.out.println("Total de devoluciones: " + totalDevoluciones);
        System.out.println("Multas acumuladas: $" + totalMultas);
        System.out.println("Libros más prestados:");
        for (String libro : librosMasPrestados) {
            System.out.println(" - " + libro);
        }
    }
}
