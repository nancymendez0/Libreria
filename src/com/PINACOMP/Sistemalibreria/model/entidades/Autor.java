package com.PINACOMP.Sistemalibreria.model.entidades;
import com.PINACOMP.Sistemalibreria.model.enums.TipoNacionalidad;
import com.PINACOMP.Sistemalibreria.model.enums.TipoSexo;
import java.time.LocalDate;
//Esta clase representa a un autor en el sistema y hereda atributos de la clase persona
public class Autor extends Persona {
    //atributos
    private String apellidoMaterno;
    private LocalDate fechaNacimiento;
    private TipoNacionalidad nacionalidad;
    private int cantidadLibros;//libros publicados por el autor
    //constructor que inicializa todos los atributos del autor incluye los heredados de persona
    //Recibe todos los datos necesarios para crear un autor completo
    public Autor(
            int id,
            String nombre,
            String apellidoPaterno,
            String apellidoMaterno,
            String correo,
            int edad,
            TipoSexo sexo,
            TipoNacionalidad nacionalidad,
            LocalDate fechaNacimiento,
            int cantidadLibros
    ) {
        super(nombre, apellidoPaterno, correo, edad, sexo, id);
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.cantidadLibros = cantidadLibros;
    }



    //Getters , devuelven
    //omite Set para que sean inmutables
    //Get que devuelve el nombre completo del autor
    public String getNombreCompleto() {
        return nombre+" "+apellidoMaterno;
    }

    public TipoNacionalidad getNacionalidad() {
        return nacionalidad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public int getCantidadLibros() {
        return cantidadLibros;
    }
    //representación textual del autor , para poder imprimir en main
    @Override
    public String toString() {
        return getNombreCompleto()+"("+nacionalidad+","+ sexo+")- Libros publicados: "+cantidadLibros;
    }

}
