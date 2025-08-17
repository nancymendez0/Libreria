package com.PINACOMP.Sistemalibreria.model.entidades;
import java.time.LocalDate;
public abstract class OperacionBiblioteca {
    //atributos protegidos que almacenan el identificsador de la operacion , accede desde clases hijas
    //abre acceso solo a las subcalses , a diferencia de private que restringe a su misma clase
    protected int idOperacion;
    protected LocalDate fecha;
    //constructor publico
    public OperacionBiblioteca(int idOperacion, LocalDate fecha) {
        this.idOperacion = idOperacion;
        this.fecha = fecha;
    }
    //Get para acceder
    public int getIdOperacion() {
        return idOperacion;
    }

    public LocalDate getFecha() {
        return fecha;
    }
    //obliga a sus hijas :prestamo , devolucion y venta a definir su propia version de resumen
    //método abstracto que es implementado por todas las clases que heredan de OperacionBiblioteca y muestra un resumen de la operación
    public abstract void mostrarResumen();
}
