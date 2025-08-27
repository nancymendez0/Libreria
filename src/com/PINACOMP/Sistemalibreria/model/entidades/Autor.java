package com.PINACOMP.Sistemalibreria.model.entidades;

import com.PINACOMP.Sistemalibreria.model.enums.TipoNacionalidad;
import com.PINACOMP.Sistemalibreria.model.enums.TipoSexo;
import java.time.LocalDate;

/**
 * Esta clase representa a un autor en el sistema y hereda atributos de la clase Persona.
 * Incluye información adicional como apellido materno, fecha de nacimiento, nacionalidad y cantidad de libros publicados.
 */
public class Autor extends Persona {
    private String apellidoMaterno;
    private LocalDate fechaNacimiento;
    private TipoNacionalidad nacionalidad;
    private int cantidadLibros;

    /**
     * Constructor que inicializa todos los atributos del autor, incluyendo los heredados de Persona.
     * @param id Identificador único del autor.
     * @param nombre Nombre del autor.
     * @param apellidoPaterno Apellido paterno del autor.
     * @param correo Correo electrónico del autor.
     * @param edad Edad del autor.
     * @param sexo Sexo del autor.
     * @param apellidoMaterno Apellido materno del autor.
     * @param fechaNacimiento Fecha de nacimiento del autor.
     * @param nacionalidad Nacionalidad del autor.
     * @param cantidadLibros Cantidad de libros publicados por el autor.
     */
    public Autor(
            int id,
            String nombre,
            String apellidoPaterno,
            String correo,
            int edad,
            TipoSexo sexo,
            String apellidoMaterno,
            LocalDate fechaNacimiento,
            TipoNacionalidad nacionalidad,
            int cantidadLibros
    ) {
        super(id, nombre, apellidoPaterno, correo);
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.cantidadLibros = cantidadLibros;
    }

    public Autor(Persona persona) {
        super(persona.getId(), persona.getNombre(), persona.getApellidoPaterno(), persona.getCorreo());
        this.edad = persona.getEdad();
        this.sexo = persona.getSexo();
        this.nacionalidad = persona.getNacionalidad();
        this.fechaNacimiento = persona.getFechaNacimiento();
        this.cantidadLibros = 0; // valor por defecto o derivado
    }

    public Autor(String nombre, String apellidoPaterno, String apellidoMaterno) {
        super(nombre, apellidoPaterno);
        this.apellidoMaterno = apellidoMaterno;
    }
    // Getters (sin setters para mantener inmutabilidad)

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public TipoNacionalidad getNacionalidad() {
        return nacionalidad;
    }

    public int getCantidadLibros() {
        return cantidadLibros;
    }

    /**
     * Devuelve el nombre completo del autor, incluyendo nombre, apellido paterno y materno.
     * Utiliza los getters heredados para mantener encapsulamiento.
     * @return Nombre completo como cadena legible.
     */
    @Override
    public String getNombreCompleto() {
        return getNombre() + " " + getApellidoPaterno() + " " + apellidoMaterno;
    }

    /**
     * Representación textual del autor para impresión en consola.
     * @return Cadena con nombre completo, nacionalidad, sexo y cantidad de libros publicados.
     */
    @Override
    public String toString() {
        return getNombreCompleto() + " (" + nacionalidad + ", " + getSexo() + ") - Libros publicados: " + cantidadLibros;
    }
}