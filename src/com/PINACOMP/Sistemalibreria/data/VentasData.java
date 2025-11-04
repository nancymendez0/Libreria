package com.PINACOMP.Sistemalibreria.data;

import com.PINACOMP.Sistemalibreria.model.entidades.Cliente;
import com.PINACOMP.Sistemalibreria.model.entidades.Libro;
import com.PINACOMP.Sistemalibreria.model.entidades.Venta;
import com.PINACOMP.Sistemalibreria.model.enums.TipoPago;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VentasData {
    private static final List<Venta> listaVentas = new ArrayList<>();
    static{
        Cliente cli1 = new Cliente(1,"pablito12@gmail.com", TipoPago.Efectivo);
        Cliente cli2 = new Cliente(2 , "anaGarcia@gmail.com", TipoPago.Tarjeta_credito);
        Cliente cli3 = new Cliente(3,"eduar9807@gmail.com", TipoPago.Tarjeta_debito);
        Cliente cli4 = new Cliente (4, "nancyMendez@gmail.com",TipoPago.Transferencia);
        Libro libroVenta1 = Biblioteca.obtenerLibros().get(0); //cien años de soledad
        Libro libroVenta2 = Biblioteca.obtenerLibros().get(1); //Watchmen
        Libro libroVenta3 = Biblioteca.obtenerLibros().get(2); //La casa de los espíritus
        Libro libroVenta4 = Biblioteca.obtenerLibros().get(1); //Watchmen

        listaVentas.add(new Venta(1, LocalDate.of(2025,10,12),cli1,libroVenta1,libroVenta1.getPrecio()));
        listaVentas.add(new Venta(2, LocalDate.of(2025,9,1),cli2,libroVenta2,libroVenta2.getPrecio()));
        listaVentas.add(new Venta(3, LocalDate.of(2025,10,30),cli3,libroVenta3,libroVenta3.getPrecio()));
        listaVentas.add(new Venta(4, LocalDate.of(2025,5,12),cli4,libroVenta4,libroVenta4.getPrecio()));

    }
    //Obtener las ventas
    public static List<Venta> obtenerVentas(){
        return listaVentas;
    }
    //metodo para agregar ventas
    public static void agregarVenta(Venta venta){
        listaVentas.add(venta);
    }
}
