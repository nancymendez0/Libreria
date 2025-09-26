package com.PINACOMP.Sistemalibreria.servicios;

import com.PINACOMP.Sistemalibreria.model.entidades.Persona;
import com.PINACOMP.Sistemalibreria.model.enums.TipoPuesto;
import com.PINACOMP.Sistemalibreria.model.enums.TipoSexo;

public class Empleado extends Persona {

    private String puesto;

    public Empleado(int id, String nombre, String apellidoPaterno, String correo, int edad, TipoSexo sexo, TipoPuesto puesto) {
        super(id, nombre, apellidoPaterno, correo, edad, sexo);
        this.puesto = String.valueOf(puesto);
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }


}
