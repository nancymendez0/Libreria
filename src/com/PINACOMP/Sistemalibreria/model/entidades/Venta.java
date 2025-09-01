package com.PINACOMP.Sistemalibreria.model.entidades;
import com.PINACOMP.Sistemalibreria.model.enums.TipoOperacion;

import java.time.LocalDate;

//clase ventas heredando de OperacionBiblioteca
public class Venta {
    //Nuevos atributos para implementar la imterfaz OperacionBliblioteca , ya no herefdan
    private int idOperacion;
    private LocalDate fecha;
    private final TipoOperacion tipoOperacion= TipoOperacion.VENTA;
    //-------Nancy
    private String libro;
    private double precio;
    //constructor publico de la clase ventas
    public Venta(int idOperacion, LocalDate fecha, String libro, double precio) {
        this.idOperacion = idOperacion;// no deberia heredar
        //super(idOperacion, fecha);
        this.libro = libro;
        this.precio = precio;
    }

    @Override
    public TipoOperacion getTipoOperacion() {
        return tipoOperacion;
    }


}
