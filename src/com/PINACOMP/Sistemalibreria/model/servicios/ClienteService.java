package com.PINACOMP.Sistemalibreria.model.servicios;

import com.PINACOMP.Sistemalibreria.data.Biblioteca;
import com.PINACOMP.Sistemalibreria.model.entidades.Libro;
import com.PINACOMP.Sistemalibreria.model.enums.TipoGenero;

import java.util.List;



public class ClienteService {
    private final List<Libro> libros;

    public ClienteService() {
        this.libros = Biblioteca.obtenerLibros();
    }
    public List<Libro> obtenerLibros() {
        return libros;
    }
    public void mostrarLibros(List<Libro> resultados){
        if (resultados.isEmpty()){
            System.out.println("No se encontraron resultados");
        }else{
            System.out.println("Tengo "+resultados.size()+" Libros actualmente\n");
            int contador=1;
            for (Libro libro : resultados){
                System.out.println("INFORMACIÓN LIBRO" + contador+ ":");
                System.out.println(libro);
                System.out.println();
                contador++;
            }
        }
    }

    public void BusquedaPorGenero(int opcion, TipoGenero[] generos, List<Libro> biblioteca){
        if(opcion<1 || opcion>generos.length){
            System.out.println("Opcion no válida");
        }else{
            TipoGenero generoSeleccionado= generos[opcion-1];
            System.out.println("Has seleccionado: "+generoSeleccionado);
            boolean encontrado = false;
            for(Libro libro : biblioteca){
                List<Libro> encontrados = libro.busquedaGeneroLibro(generoSeleccionado);
                if(!encontrados.isEmpty()){
                    mostrarLibros(encontrados);
                    encontrado=true;
                }
            }
            if(!encontrado){
                System.out.println("No tenemos aún libros de ese género");
            }
        }
    }
}
