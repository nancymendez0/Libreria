package com.PINACOMP.Sistemalibreria.model.entidades;

import com.PINACOMP.Sistemalibreria.model.enums.TipoPago;
import com.PINACOMP.Sistemalibreria.model.enums.TipoSexo;

//Clase que representa un cliente en el sistema
//Hereda atributos generales de la clase persona
public  class Cliente extends Persona{
    //atributos privados clase CLIENTE
    private int telefono;
    private String direccion;
    private TipoPago pago;
    //constructor que inicializa todos los atributos del cliente incluyendo los heredados de persona
    public Cliente(
            int id,
            String nombre,
            String apellidoPaterno,
            String correo,
            int edad,
            TipoSexo sexo,
            TipoPago pago,
            String direccion,
            int telefono
    ) {
        super(id, nombre, apellidoPaterno, correo, edad, sexo);
        this.direccion = direccion;
        this.telefono = telefono;
        this.pago = pago;
    }
    public Cliente(int id, String correo, TipoPago pago){
        super(id,correo);
        this.pago=pago;
    }
    //Getters para devolver información usando enumeradores
    public String getDireccion() {
        return direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public TipoPago getPago() {
        return pago;
    }

    //representacion textual del cliente , usada en el main
    @Override
    public String toString() {
        return "Cliente # "+getId()+":"+getNombreCompleto()+"_"+direccion+"- Pago:"+pago;
    }
}


