package com.PINACOMP.Sistemalibreria.model.interfaces;

import com.PINACOMP.Sistemalibreria.model.entidades.Empleado;
import com.PINACOMP.Sistemalibreria.model.enums.TipoPuesto;
import com.PINACOMP.Sistemalibreria.model.enums.TipoSexo;

import java.util.List;

public interface BuscadorEmpleados {

    List<Empleado> busquedaId(int id);

    List<Empleado> busquedaNombre(String nombre);

    List<Empleado> busquedaApellido(String apellido);

    List<Empleado> busquedaSexo(TipoSexo sexo);

    List<Empleado> busquedaPuesto(TipoPuesto puesto);
}
