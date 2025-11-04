package com.PINACOMP.Sistemalibreria.model.servicios;

import com.PINACOMP.Sistemalibreria.data.VentasData;
import com.PINACOMP.Sistemalibreria.model.entidades.Cliente;
import com.PINACOMP.Sistemalibreria.model.entidades.Libro;
import com.PINACOMP.Sistemalibreria.model.entidades.Venta;

import java.time.LocalDate;
import java.util.List;

public class VentaService {
    public void venderPorTitulo(String titulo, Cliente cli, List<Libro> biblioteca){
        Libro libroStock = null;
        for(Libro l : biblioteca){
            List<Libro> encontrado = l.busquedaTitulo(titulo);
            if(!encontrado.isEmpty()){
                libroStock=encontrado.get(0);
                break;
            }
        }//fin de for
        if(libroStock==null){
            System.out.println("No disponible el libro : " + titulo);
            return;
        }
        if (libroStock.getStock()<=0){
            System.out.println("El libro: "+ libroStock.getTitulo() + " Esta agotado");
            return;
        }
        //Realizando venta
        Venta v1 = new Venta(VentasData.obtenerVentas().size()+1, LocalDate.now(),cli,libroStock, libroStock.getPrecio());
        VentasData.agregarVenta(v1);
        //quitar del stock
        libroStock.setStock(libroStock.getStock()-1);
        System.out.println("Venta realizada correctamente");
    }
}
